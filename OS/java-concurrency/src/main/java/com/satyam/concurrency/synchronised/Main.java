package com.satyam.concurrency.synchronised;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 Synchronized gives mutual exclusion
 * */
public class Main {

    static void useThreadUnsafeCounter() throws InterruptedException {
        ThreadUnsafeCounter counter = new ThreadUnsafeCounter();

        Thread t1 = new Thread(()->{
            for(int i = 0; i < 100000;i++)
                counter.increment();
        });

        Thread t2 = new Thread(()->{
            for(int i = 0; i < 100000;i++)
                counter.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        logger.info("Final count  = {}",counter.getCount());
    }

    static void useThreadSafeCounter() throws InterruptedException {
        ThreadSafeCounter counter1 = new ThreadSafeCounter();
        ThreadSafeCounter counter2 = new ThreadSafeCounter();

        Thread t1 = new Thread(()->{
            for(int i = 0; i < 100000;i++)
                counter1.increment();
        });

        Thread t2 = new Thread(()->{
            for(int i = 0; i < 100000;i++)
                counter2.increment();
        });

        t1.start();
        t2.start();

        t1.join();
        t2.join();
        logger.info("Thread safe final count  = {}",counter1.getCount());
        logger.info("Thread safe final count  = {}",counter2.getCount());
    }

    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws InterruptedException {
        logger.info("\n\n==================== NEW RUN ====================\n");
        useThreadUnsafeCounter();
        useThreadSafeCounter();
    }
}
