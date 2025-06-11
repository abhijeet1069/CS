package cleanCode.concurrency.executionModel;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReaderWriter {
    private final ReentrantReadWriteLock rwLock = new ReentrantReadWriteLock(true);
    private int sharedData = 0;

    // Reader method
    public void read() {
        rwLock.readLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " reads: " + sharedData);
            Thread.sleep(200); // simulate read time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            rwLock.readLock().unlock();
        }
    }

    // Writer method
    public void write(int value) {
        rwLock.writeLock().lock();
        try {
            System.out.println(Thread.currentThread().getName() + " writes: " + value);
            sharedData = value;
            Thread.sleep(300); // simulate write time
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        } finally {
            rwLock.writeLock().unlock();
        }
    }

    public static void main(String[] args) {
        ReaderWriter rw = new ReaderWriter();

        // Create multiple reader threads
        for (int i = 0; i < 3; i++) {
            new Thread(() -> {
                while (true) {
                    rw.read();
                }
            }, "Reader-" + i).start();
        }

        // Create writer thread
        new Thread(() -> {
            int value = 0;
            while (true) {
                rw.write(value++);
            }
        }, "Writer").start();
    }
}


/**
Output:
Reader-1 reads: 0
Reader-0 reads: 0
Reader-2 reads: 0
Writer writes: 0
Reader-2 reads: 0
Reader-1 reads: 0
Reader-0 reads: 0
Writer writes: 1
Reader-0 reads: 1
Reader-2 reads: 1
Reader-1 reads: 1
Writer writes: 2
Reader-1 reads: 2
Reader-2 reads: 2
Reader-0 reads: 2
Writer writes: 3
Reader-0 reads: 3
Reader-1 reads: 3
Reader-2 reads: 3
Writer writes: 4
Reader-2 reads: 4
Reader-0 reads: 4
Reader-1 reads: 4
Writer writes: 5
Reader-0 reads: 5
Reader-2 reads: 5
Reader-1 reads: 5
Writer writes: 6
Reader-0 reads: 6
Reader-1 reads: 6
Reader-2 reads: 6
Writer writes: 7
Reader-1 reads: 7
Reader-0 reads: 7
Reader-2 reads: 7
Writer writes: 8
Reader-2 reads: 8
Reader-1 reads: 8
Reader-0 reads: 8
Writer writes: 9
Reader-0 reads: 9
Reader-1 reads: 9
Reader-2 reads: 9
Writer writes: 10
Reader-2 reads: 10
Reader-0 reads: 10
Reader-1 reads: 10
Writer writes: 11
Reader-2 reads: 11
Reader-0 reads: 11
Reader-1 reads: 11
Writer writes: 12
Reader-1 reads: 12
Reader-2 reads: 12
Reader-0 reads: 12
Writer writes: 13
Reader-1 reads: 13
Reader-0 reads: 13
Reader-2 reads: 13
Writer writes: 14
Reader-0 reads: 14
Reader-1 reads: 14
Reader-2 reads: 14
Writer writes: 15
Reader-2 reads: 15
Reader-1 reads: 15
Reader-0 reads: 15

 * */