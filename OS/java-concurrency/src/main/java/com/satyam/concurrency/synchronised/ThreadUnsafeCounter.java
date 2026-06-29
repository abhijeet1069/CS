package com.satyam.concurrency.synchronised;

public class ThreadUnsafeCounter {

    private int count = 0;

    public void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
}
