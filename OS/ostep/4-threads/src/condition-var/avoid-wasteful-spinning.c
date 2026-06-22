#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
#include "../include/common.h"
#include "../include/common_threads.h"

/**

Mutex           -> Mutual Exclusion
Condition Var   -> Waiting / Signalling
Semaphore       -> Resource Counting

pthread_cond_wait(&cond, &lock);
    equivalent to
1. Release lock
2. Sleep
3. Wake up when signalled
4. Re-acquire lock
5. Return

Tip : Hold the lock when calling signal or wait, and you will always be in good shape.
 */

int done = 0;
pthread_mutex_t lock;
pthread_cond_t cond;

void *child()
{
    printf("child\n");
    sleep(20);
    pthread_mutex_lock(&lock); // 3. child wakes up after 20 sec and acquires the lock
    done = 1;
    pthread_cond_signal(&cond);  // 4. child signals
    pthread_mutex_unlock(&lock); // 5. child releases the lock
    return NULL;
}

int main()
{
    pthread_t p;
    pthread_mutex_init(&lock, NULL);
    pthread_cond_init(&cond, NULL);
    printf("parent: begin\n");
    Pthread_create(&p, NULL, child, NULL);
    pthread_mutex_lock(&lock); // 1. parent acquires the lock

    while (done == 0)
        pthread_cond_wait(&cond, &lock); // 2. Parent releases lock and goes to sleep
    // 6. kernel wakes up parent post signal, parent acquires the lock

    pthread_mutex_unlock(&lock);
    printf("parent: end\n");

    pthread_join(p, NULL);
    pthread_mutex_destroy(&lock);
    pthread_cond_destroy(&cond);
    return 0;
}