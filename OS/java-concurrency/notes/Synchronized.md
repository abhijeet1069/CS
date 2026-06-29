# Synchronized

Synchronized gives mutual exclusion.

> synchronized only works if every thread that accesses the same shared data synchronizes on the same lock.

## Bug

```java
// concurrency just broke the correctness. Each time different answer
/*
2026-06-29 09:31:10 [main] INFO  c.s.concurrency.synchronised.Main - Thread safe final count  = 199249
2026-06-29 09:31:10 [main] INFO  c.s.concurrency.synchronised.Main - Thread safe final count  = 199249
 * */
public class ThreadSafeCounter {
    private static int count = 0;

    public synchronized void increment(){
        count++;
    }

    public int getCount(){
        return count;
    }
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
```
## Fix

We made the lock a class lock.

```java
// 2026-06-29 09:34:49 [main] INFO  c.s.concurrency.synchronised.Main - Thread safe final count  = 200000
// 2026-06-29 09:34:49 [main] INFO  c.s.concurrency.synchronised.Main - Thread safe final count  = 200000
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
```