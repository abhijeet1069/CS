#include <stdio.h>
#include "../include/common_threads.h"
#define THREAD_POOL_SIZE 1000

/**
./bin/app
Counter = 500000000
make all  9.86s user 79.37s system 747% cpu 11.935 total
 *
 */

typedef struct __counter_t
{
    int value;
    pthread_mutex_t lock;
} counter_t;

void init(counter_t *c)
{
    c->value = 0;
    Mutex_init(&c->lock);
}

void increment(counter_t *c)
{
    Pthread_mutex_lock(&c->lock);
    c->value++;
    Pthread_mutex_unlock(&c->lock);
}

void decrement(counter_t *c)
{
    Pthread_mutex_lock(&c->lock);
    c->value--;
    Pthread_mutex_unlock(&c->lock);
}

int get(counter_t *c)
{
    Pthread_mutex_lock(&c->lock);
    int rc = c->value;
    Pthread_mutex_unlock(&c->lock);
    return rc;
}

void *worker(void *arg)
{
    // printf("worker started\n");
    counter_t *ctrPtr = (counter_t *)arg;
    for (int i = 1; i <= 500000; i++)
    {
        increment(ctrPtr);
    }
    return NULL;
}

int main()
{
    counter_t ctr;
    init(&ctr);

    pthread_t threads[THREAD_POOL_SIZE];

    for (int i = 0; i < THREAD_POOL_SIZE; i++)
        Pthread_create(&threads[i], NULL, worker, &ctr);

    for (int i = 0; i < THREAD_POOL_SIZE; i++)
        Pthread_join(threads[i], NULL);

    printf("Counter = %d\n", get(&ctr));
}