package com.satyam.concurrency.intro.start;

public class MyRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 1; i <= 20; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread is running");
        }
    }
}
