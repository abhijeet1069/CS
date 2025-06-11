package cleanCode.concurrency.threadAPI.simulateAPI;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class PubSubAPIDemo{
	
	public static void main(String[] args) throws InterruptedException {
        BlockingQueue<String> queue = new LinkedBlockingQueue<>();

        // Publisher thread - publishes 10 messages
        Thread publisher = new Thread(() -> {
            try {
                for (int i = 0; i < 10; i++) {
                    String message = "Request- " + i;
                    System.out.println("Publishing: " + message);
                    queue.put(message);
                    Thread.sleep(300);  // simulate delay between publish
                }

                // Send termination signals (one per subscriber)
                int numSubscribers = 3;
                for (int i = 0; i < numSubscribers; i++) {
                    queue.put("DONE");
                }

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Subscribers - thread pool with 3 threads
        int numSubscribers = 3;
        ExecutorService subscriberPool = Executors.newFixedThreadPool(numSubscribers);

        Runnable subscriberTask = () -> {
            try {
                while (true) {
                    String message = queue.take();
                    if ("DONE".equals(message)) {
                        break;
                    }
                    callAPI(message);  // simulate API call
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        };

        // Start publisher
        publisher.start();

        // Start subscriber threads
        for (int i = 0; i < numSubscribers; i++) {
            subscriberPool.submit(subscriberTask);
        }

        // Wait for publisher to finish
        publisher.join();

        // Shutdown subscriber pool
        subscriberPool.shutdown();
        subscriberPool.awaitTermination(1, TimeUnit.MINUTES);

        System.out.println("PubSub API demo finished.");
    }
	
	static void callAPI(String msg) {
		try {
			Random rand = new Random();
			int delay = rand.nextInt(2000)+500; // 500ms to 2500ms
			System.out.println(Thread.currentThread().getName() + " calling API with: " + msg + " (delay: " + delay + "ms)");
			Thread.sleep(delay);
			System.out.println(Thread.currentThread().getName() + " API response for: " + msg);
		}
		catch(InterruptedException e) {
			Thread.currentThread().interrupt();
		}
	}
	
	
}