package com.satyam.concurrency.intro.start;

/**
Interface is much like java saying, pass me an object that knows how to perform this operation

Thread can be created either by extending Thread class or implementing Runnable

 The runnable approach is very much like the C approach

 void* worker(void* arg) {
 printf("Hello\n");
 return NULL;
 }

 pthread_t t;
 pthread_create(&t, NULL, worker, NULL);

* */

public class App 
{
    public static void main( String[] args ) throws InterruptedException {
//        MyThread myThread = new MyThread();
//        myThread.start();
//        myThread.join();
        MyRunnable myRunnable = new MyRunnable();
        Thread t1 = new Thread(myRunnable);
        t1.start();
    }
}
