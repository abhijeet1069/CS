package cleanCode.concurrency.semaphore;

import java.util.concurrent.Semaphore;

public class SemaphoreExample {
    // Only 2 threads can access this at once
    private static final Semaphore semaphore = new Semaphore(2);

    public static void main(String[] args) {
        Runnable task = () -> {
            try {
                System.out.println(Thread.currentThread().getName() + " waiting for permit...");
                semaphore.acquire();
                System.out.println(Thread.currentThread().getName() + " got permit and working...");
                Thread.sleep(2000); // simulate work
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println(Thread.currentThread().getName() + " releasing permit.");
                semaphore.release();
            }
        };

        // Launch 5 threads
        for (int i = 0; i < 5; i++) {
            new Thread(task, "Thread-" + i).start();
        }
    }
}

/**
Output :  
Thread-0 waiting for permit...
Thread-4 waiting for permit...
Thread-4 got permit and working...
Thread-3 waiting for permit...
Thread-2 waiting for permit...
Thread-1 waiting for permit...
Thread-0 got permit and working...
Thread-0 releasing permit.
Thread-4 releasing permit.
Thread-2 got permit and working...
Thread-3 got permit and working...
Thread-2 releasing permit.
Thread-3 releasing permit.
Thread-1 got permit and working...
Thread-1 releasing permit.

 * */
