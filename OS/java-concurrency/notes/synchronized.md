# Synchronized

> synchronized only works if every thread that accesses the same shared data synchronizes on the same lock.

## Why do we need synchronization?

Multiple threads may access the same shared mutable data simultaneously.
Without synchronization updates are not atomic.
Two threads can interleave these operations and lose updates, resulting in race conditions.

```java
// for ex simple updates like below are not atomic
count++;

// is actually
Read count -> Increment -> Write count
```

## What does synchronized do?

It provides mutual exclusion. Only one thread can execute a synchronized block for a particular lock.

```java
synchronized(lock){
    //critical section - Code that access shared mutable data
        }
```

## Every Java object has a monitor

Every object has an associated monitor(lock). Threads acquire and release this monitor.

```java
Object
 ├── Fields
 └── Monitor
```

## Instance synchronized method

```java
public synchronized void increment() {
}

//equivalent to, here lock owner is the object (this)
public void increment() {
    synchronized(this) {

    }
}

```

## Static synchronized method

```java
public static synchronized void increment() {
}

// equivalent to, here lock owner is ThreadSafeCounter.class, which is only one per JVM
synchronized(ThreadSafeCounter.class) {
        }

```

## Explicit lock object

```java
private static final Object LOCK = new Object();
synchronized(LOCK) {
    //critical section
}

// note below code is not similar to above code. Both are class based lock.
// However, there the LOCK object has ownership, here the class has ownership
public static void foo() {
    synchronized(Counter.class) {
    }
}

// both are similar
public static synchronized void foo() {
}
```

## Common mistakes

### synchronized makes code thread safe

No, it only protects code executed under same lock.

### One synchronized method blocks all synchronized methods

No, only methods synchronized on the same lock block each other

## Threads own locks

No, objects own monitors, threads only borrow them