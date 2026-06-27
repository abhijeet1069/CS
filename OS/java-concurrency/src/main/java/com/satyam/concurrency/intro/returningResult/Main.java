package com.satyam.concurrency.intro.returningResult;

class Worker implements Runnable{
    private int result;

    @Override
    public void run() {
        for(int i = 1; i <= 20; i++) {
            result = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getResult(){
        return result;
    }
}

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Worker worker = new Worker();
        Thread t = new Thread(worker);
        t.start();
       while(t.isAlive()) //polling and not a good idea
           System.out.println(worker.getResult());
    }
}
