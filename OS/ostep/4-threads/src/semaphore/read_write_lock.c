/**
Readers-Writers Lock

Purpose: Allow multiple readers to access a shared resource concurrently while
ensuring writers get exclusive access.

Conditions

1. Multiple readers can read simultaneously
    * If no writer is active, any number of readers may enter.
2. Writer gets exclusive access
    * While a writer is writing, no reader or other writer can access the resource.
3. No reader-writer overlap
    * Readers and writers must never access the resource at the same time.
4. Only one writer at a time
    * Two writers cannot write concurrently.
5. Fairness / No starvation (not covered in below code)
    * Readers should not starve writers.
    * Writers should not starve readers.
    * Fair implementations provide bounded waiting.

Output:
Notice, each reader takes 1 sec, however 10 readers completed in 1 sec, not 10sec
satyam@satyam-2 4-threads % time make run
./bin/program
write done
read 100
read 100
read 100
read 100
read 100
read 100
read 100
read 100
read 100
read 100
all done
make run  0.01s user 0.01s system 1% cpu 1.026 total
 */

#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>
#include "../include/common.h"
#include "../include/common_threads.h"
#ifdef linux
#include <semaphore.h>
#elif __APPLE__
#include "zemaphore.h"
#endif

typedef struct _rwlock_t
{
    sem_t writelock;
    sem_t lock;
    int readers;
} rwlock_t;

void rwlock_init(rwlock_t *lock)
{
    lock->readers = 0;
    Sem_init(&lock->lock, 1); // readers go through one by one
    Sem_init(&lock->writelock, 1);
}

// Readers pass one - by - one through the checkpoint
// Once inside,
// they can all read simultaneously
void rwlock_acquire_readlock(rwlock_t *lock)
{
    Sem_wait(&lock->lock);
    lock->readers++;
    if (lock->readers == 1)
        Sem_wait(&lock->writelock); // first reader acquires writer lock
    Sem_post(&lock->lock);
}

void rwlock_release_readlock(rwlock_t *lock)
{
    Sem_wait(&lock->lock);
    lock->readers--;
    if (lock->readers == 0)
        Sem_post(&lock->writelock); // last reader releases writer lock
    Sem_post(&lock->lock);
}

void rwlock_acquire_writelock(rwlock_t *lock)
{
    Sem_wait(&lock->writelock);
}

void rwlock_release_writelock(rwlock_t *lock)
{
    Sem_post(&lock->writelock);
}

int read_loops;
int write_loops;
int counter = 0;

rwlock_t mutex;

void *reader()
{
    int local = 0;
    rwlock_acquire_readlock(&mutex);
    local = counter; // read
    printf("read %d \n", local);
    sleep(1);
    rwlock_release_readlock(&mutex);
    return NULL;
}

void *writer()
{
    for (int i = 0; i < 100; i++)
    {
        rwlock_acquire_writelock(&mutex);
        counter++;
        rwlock_release_writelock(&mutex);
    }
    printf("write done\n");
    return NULL;
}

int main()
{
    int readers_count = 10;
    rwlock_init(&mutex);
    pthread_t r[readers_count];
    pthread_t w;

    Pthread_create(&w, NULL, writer, NULL);

    for (int i = 0; i < readers_count; i++)
        Pthread_create(&r[i], NULL, reader, NULL);

    for (int i = 0; i < readers_count; i++)
        Pthread_join(r[i], NULL);

    Pthread_join(w, NULL);
    printf("all done \n");
    return 0;
}