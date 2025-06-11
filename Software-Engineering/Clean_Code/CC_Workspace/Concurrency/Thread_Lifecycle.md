# Thread Life-cycle in JAVA

A thread in Java goes through several states during its lifetime.

NEW → RUNNABLE → RUNNING → BLOCKED / WAITING / TIMED_WAITING → TERMINATED

## NEW

Thread object has been created but start() not called yet.

```java
Thread t = new Thread(() -> { ... });
```

## RUNNABLE

Thread is ready to run, but CPU may or may not be executing it.

```java
t.start();
```

## RUNNING

(Conceptually) thread is actually running on CPU. (Java does not distinguish RUNNABLE and RUNNING — both are RUNNABLE in Thread.State.)

```java
t.start();
```

## BLOCKED

Thread is waiting to enter a synchronized block because another thread holds the lock.

```java
synchronized block (if blocked)
```

## WAITING

Thread is waiting indefinitely for another thread to do something (e.g. join(), wait()).

```java
join()
```

## TIMED_WAITING

Thread is waiting for a specific time (e.g. sleep(), wait(timeout), join(timeout)).

```java
join(time)
```

## TERMINATED

Thread has finished execution or was stopped.