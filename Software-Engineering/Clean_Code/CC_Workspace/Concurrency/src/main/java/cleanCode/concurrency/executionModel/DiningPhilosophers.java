package cleanCode.concurrency.executionModel;

import java.util.concurrent.*;

public class DiningPhilosophers {

    static class Philosopher extends Thread {
        private final int id;
        private final Semaphore leftFork;
        private final Semaphore rightFork;

        public Philosopher(int id, Semaphore leftFork, Semaphore rightFork) {
            this.id = id;
            this.leftFork = leftFork;
            this.rightFork = rightFork;
        }

        @Override
        public void run() {
            try {
                while (true) {
                    think();
                    
                    // Pick up forks in a particular order to avoid deadlock
                    if (id % 2 == 0) {
                        leftFork.acquire();
                        rightFork.acquire();
                    } else {
                        rightFork.acquire();
                        leftFork.acquire();
                    }

                    eat();

                    leftFork.release();
                    rightFork.release();
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }

        private void think() throws InterruptedException {
            System.out.println("Philosopher " + id + " is thinking.");
            Thread.sleep((long) (Math.random() * 1000));
        }

        private void eat() throws InterruptedException {
            System.out.println("Philosopher " + id + " is eating.");
            Thread.sleep((long) (Math.random() * 1000));
        }
    }

    public static void main(String[] args) {
        final int N = 5;
        Semaphore[] forks = new Semaphore[N];

        for (int i = 0; i < N; i++) {
            forks[i] = new Semaphore(1);  // Each fork is a binary semaphore
        }

        for (int i = 0; i < N; i++) {
            Semaphore left = forks[i];
            Semaphore right = forks[(i + 1) % N];
            new Philosopher(i, left, right).start();
        }
    }
}


/**
Sample Output:
Philosopher 0 is thinking.
Philosopher 4 is thinking.
Philosopher 3 is thinking.
Philosopher 2 is thinking.
Philosopher 1 is thinking.
Philosopher 0 is eating.
Philosopher 0 is thinking.
Philosopher 3 is eating.
Philosopher 0 is eating.
Philosopher 0 is thinking.
Philosopher 3 is thinking.
Philosopher 2 is eating.
Philosopher 4 is eating.
Philosopher 2 is thinking.
Philosopher 1 is eating.
Philosopher 1 is thinking.
Philosopher 4 is thinking.
Philosopher 0 is eating.
Philosopher 3 is eating.
Philosopher 0 is thinking.
Philosopher 1 is eating.
Philosopher 3 is thinking.
Philosopher 1 is thinking.
Philosopher 2 is eating.
Philosopher 0 is eating.
Philosopher 2 is thinking.
Philosopher 0 is thinking.
Philosopher 1 is eating.
Philosopher 4 is eating.
Philosopher 4 is thinking.
Philosopher 3 is eating.
Philosopher 1 is thinking.
Philosopher 0 is eating.
Philosopher 3 is thinking.
Philosopher 2 is eating.
Philosopher 2 is thinking.
Philosopher 0 is thinking.
Philosopher 1 is eating.
Philosopher 4 is eating.

 * */
