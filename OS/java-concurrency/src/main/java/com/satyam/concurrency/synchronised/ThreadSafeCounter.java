package com.satyam.concurrency.synchronised;

public class ThreadSafeCounter {
    private static int count = 0;
    private static final Object COUNTER_LOCK = new Object();
    public void increment(){
        synchronized (COUNTER_LOCK){
            count++;
        }
    }

    public int getCount(){
        return count;
    }
}
