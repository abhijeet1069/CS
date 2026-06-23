# Common concurrency bugs

## Non deadlock bugs

Non-deadlock bugs make up a majority of concurrency bugs, according to Lu’s study

### Atomicity violation bugs

An Atomicity Violation Bug occurs when a sequence of operations that should execute as a single indivisible (atomic) unit is interrupted by another thread, causing incorrect behavior.

```C
Thread 1::
    if (thd->proc_info) { //the block is supposed to be atomic
        fputs(thd->proc_info, ...);
   }

Thread 2::
    thd->proc_info = NULL;

//Fix : Enforce atomicity

Thread 1::
    pthread_mutex_lock(&proc_info_lock);
        if (thd->proc_info) {
            fputs(thd->proc_info, ...);
        }
    pthread_mutex_unlock(&proc_info_lock);

Thread 2::
    pthread_mutex_lock(&proc_info_lock);
    thd->proc_info = NULL;
    pthread_mutex_unlock(&proc_info_lock);
```

### Order violation bug

An Order Violation Bug occurs when one thread assumes another thread has already performed some action, but the execution order is not guaranteed.

We expect,
Thread1: value = 100
Thread1: initialized = 1
Thread2: print value

But thread 2 may run first

```C
//Thread 1 : initializes the value
int value;
int initialized = 0;

void *thread1(void *arg) {
    value = 100;
    initialized = 1;
    return NULL;
}

//Thread 2 : uses the value
void *thread2(void *arg) {
    if (initialized)
        printf("%d\n", value);
    return NULL;
}

```

Fix using semaphore

```C
sem_t sem;
int value;

void *thread1(void *arg) {
    value = 100;
    sem_post(&sem);   // signal completion
    return NULL;
}

void *thread2(void *arg) {
    sem_wait(&sem);   // wait for thread1
    printf("%d\n", value);
    return NULL;
}
```

## Deadlock bugs

### Conditions for deadlock

Four conditions need to hold for a deadlock to occur:

- Mutual exclusion: Threads claim exclusive control of resources that
    they require (e.g., a thread grabs a lock).
- Hold-and-wait: Threads hold resources allocated to them (e.g., locks
    that they have already acquired) while waiting for additional resources (e.g., locks that 
    they wish to acquire).
- No preemption: Resources (e.g., locks) cannot be forcibly removed
    from threads that are holding them.
- Circular wait: There exists a circular chain of threads such that each
    thread holds one or more resources (e.g., locks) that are being requested by the next thread in the chain.

If any of these four conditions are not met, deadlock cannot occur.
Thus, we first explore techniques to prevent deadlock; each of these strategies seeks to prevent one of the above conditions from arising and thus is one approach to handling the deadlock problem.

## Event Based concurrency

Event-based concurrency is a model where a program handles many concurrent activities by processing events in an event loop rather than creating multiple threads.

### Advantages

- No thread synchronization problems
    - No mutexes
    - No deadlocks
    - No race conditions
- Lower memory usage
- Can handle thousands of connections
-  Simpler resource management

## Disadvantages

- Long running task block the event loop
- Harder to write CPU intensive program
- Callback based code can become complex