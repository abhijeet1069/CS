package com.satyam.concurrency.intro.passingArgs;

class Worker implements Runnable{

    private final int x;
    private final int y;

    public Worker(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public void run() {
        System.out.println(x+y);
    }
}

public class Main {
    public static void main(String[] args) {
        Thread t = new Thread(new Worker(10,20));
        t.start();
    }
}
