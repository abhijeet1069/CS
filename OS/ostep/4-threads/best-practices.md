# Multithreading Best Practices

## 1. Keep Critical Sections Small

### Bad

```c
pthread_mutex_lock(&lock);  
read_file(); 
process_data(); 
write_database();  
pthread_mutex_unlock(&lock);
```
 
All threads wait for the entire operation to complete.

### Better

```C
c read_file(); 
process_data(); 
pthread_mutex_lock(&lock);  
write_database();  
pthread_mutex_unlock(&lock); 
```

Only the shared state is protected.

---

## 2. Avoid One Giant Lock

### Bad

Application     
    |     
    +-- One Lock 

Every thread contends for the same lock.

### Better

Hash Table     
    |     
    +-- Bucket Lock 1     
    +-- Bucket Lock 2     
    +-- Bucket Lock 3 

Partition the data and the locks.

## 3. Prefer Message Passing

Instead of sharing data directly:

Thread A modifies Thread B's data 

Use:

Thread A ---> Queue ---> Thread B 

This reduces synchronization complexity.


## 4. Minimize Shared Mutable State

### Bad

```C
globalCounter 
globalList 
globalQueue 
globalCache 
globalMap 
``` 
Every shared variable becomes a synchronization problem.

### Better

- Each thread owns its data. 
- Only necessary state is shared. 


## 5. Lock Only What You Protect

### Bad

c pthread_mutex_t lock; 

Nobody knows what it protects.

### Better

c queue_lock 
cache_lock 
counter_lock 

Use descriptive names.

## 6. Document Lock Ownership

Example:

```C
// caller must hold queue_lock 
void queue_remove(...); 
```
 
or

```C
// acquires queue_lock internally 
void queue_insert(...); 
```

Documenting ownership prevents mistakes.

---

## 7. Use Consistent Lock Ordering

### Deadlock Example

Thread A:

lock A 
lock B 

Thread B:

lock B 
lock A 

Both threads can wait forever.

### Rule

Always acquire locks in a consistent order.

A before B 

throughout the entire codebase.

## 8. Always Use While With Condition Variables

### Never

```c
if (queue_empty()) {    
     pthread_cond_wait(...); 
     } 
```

### Always

```c
while (queue_empty()) {     
    pthread_cond_wait(...); 
    } 
```

Condition variables can experience spurious wakeups.

## 9. Prefer Immutable Data

If data never changes:

No lock required. 

Read-only data is concurrency-friendly.

## 10. Use Atomics For Simple Counters

Instead of:

```C
pthread_mutex_lock(&lock); 
counter++; 
pthread_mutex_unlock(&lock); 
```

Consider:

```C
c atomic_fetch_add(&counter, 1); 
```
for simple counters and flags.

## 11. Avoid Busy Waiting

### Bad

```C 
while(done == 0)     
    ; 
```
Consumes CPU continuously.

### Better

```c 
pthread_cond_wait(...) 
or
pthread_join(...) 
```
Let the thread sleep.

## 12. Design To Reduce Contention

Ask:
What data is actually shared? 

Examples:

One counter
↓ 
Per-thread counters 

One queue
↓ 
Multiple queues 

Reduce contention whenever possible.

## 13. Start Correct, Then Optimize

### Wrong Approach

Lock-free structure 
Complex synchronization 
Premature optimization 

### Better Approach

Correct mutex solution         
↓ 
Measure         
↓ 
Optimize 

Correctness comes first.

## 14. Prefer Thread Pools

### Bad

```C
pthread_create(...) 
pthread_create(...) 
pthread_create(...) 
```

Creating threads for every task is expensive.

### Better

Fixed worker threads        
+ 
Work queue 

This is the standard design used by servers.


## 15. Understand What Each Primitive Does

### Mutex

Protects shared data.

Who can access the resource? 

### Condition Variable

Allows threads to sleep and be signalled.

When should I wake up? 

### Semaphore

Tracks available resources.

How many resources are available? 

Use the right tool for the problem.

## 16. Think In Terms Of Ownership

For every shared variable ask:

What data is shared? 
Who modifies it? 
What lock protects it? 

If you cannot answer these questions quickly, the design is probably too complicated.


## 17. Prefer Simpler Designs

Good concurrent designs are usually easy to explain.

Examples:

### Concurrent Queue

Producer uses tail lock 
Consumer uses head lock 

### Concurrent Hash Table

One lock per bucket 

These designs reduce contention while remaining easy to reason about.


# Golden Rule

Before writing concurrent code, answer:

1. What data is shared?
2. Who can modify it?
3. What protects it?

If these answers are clear, the design is usually manageable.