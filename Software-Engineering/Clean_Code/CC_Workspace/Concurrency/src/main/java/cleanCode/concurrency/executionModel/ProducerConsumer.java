package cleanCode.concurrency.executionModel;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumer {
    private static final int CAPACITY = 5;
    private final Queue<Integer> buffer = new LinkedList<>();

    public void produce(int item) throws InterruptedException {
        synchronized (buffer) {
            while (buffer.size() == CAPACITY) {
                buffer.wait();  // wait if buffer full
            }
            buffer.add(item);
            System.out.println("Produced: " + item+ " capacity : "+buffer.size());
            buffer.notifyAll(); // notify consumers
        }
    }

    public int consume() throws InterruptedException {
        synchronized (buffer) {
            while (buffer.isEmpty()) {
                buffer.wait();  // wait if buffer empty
            }
            int item = buffer.poll();
            System.out.println("Consumed: " + item+ " capacity : "+buffer.size());
            buffer.notifyAll(); // notify producers
            return item;
        }
    }

    public static void main(String[] args) {
        ProducerConsumer pc = new ProducerConsumer();

        // Producer Thread
        Thread producer = new Thread(() -> {
            int item = 0;
            try {
                while (true) {
                    pc.produce(item++);
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        // Consumer Thread
        Thread consumer = new Thread(() -> {
            try {
                while (true) {
                    pc.consume();
                    Thread.sleep(800);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });

        producer.start();
        consumer.start();
    }
}

