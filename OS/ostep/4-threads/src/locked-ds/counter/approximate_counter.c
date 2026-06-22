#include <stdio.h>
#include <pthread.h>
#include "../include/common_threads.h"

/**
 * ./bin/app
Counter = 500000000
make all  16.72s user 76.16s system 745% cpu 12.456 total
 *
 */

#define THREAD_POOL_SIZE 1000
#define NUMCPUS 4

typedef struct __counter_t
{
    int global;            // global count
    pthread_mutex_t glock; // global lock

    int local[NUMCPUS];             // per-cpu count
    pthread_mutex_t llock[NUMCPUS]; // per-cpu locks

    int threshold; // update frequency
} counter_t;

void init(counter_t *c, int threshold)
{

    c->threshold = threshold;
    c->global = 0;

    pthread_mutex_init(&c->glock, NULL);

    for (int i = 0; i < NUMCPUS; i++)
    {
        c->local[i] = 0;
        pthread_mutex_init(&c->llock[i], NULL);
    }
}

void update(counter_t *c, int threadID, int amt)
{

    int cpu = threadID % NUMCPUS;

    pthread_mutex_lock(&c->llock[cpu]);

    c->local[cpu] += amt;

    if (c->local[cpu] >= c->threshold)
    {

        pthread_mutex_lock(&c->glock);

        c->global += c->local[cpu];
        c->local[cpu] = 0;

        pthread_mutex_unlock(&c->glock);
    }

    pthread_mutex_unlock(&c->llock[cpu]);
}

int get(counter_t *c)
{

    pthread_mutex_lock(&c->glock);

    int val = c->global;

    pthread_mutex_unlock(&c->glock);

    return val;
}

typedef struct
{
    counter_t *counter;
    int threadId;
} worker_arg_t;

void *worker(void *arg)
{
    worker_arg_t *workerArg = (worker_arg_t *)arg;
    for (int i = 1; i <= 500000; i++)
    {
        update(workerArg->counter,
               workerArg->threadId,
               1);
    }
    return NULL;
}

int main()
{
    counter_t ctr;
    init(&ctr, 100);
    pthread_t threads[THREAD_POOL_SIZE];
    worker_arg_t args[THREAD_POOL_SIZE];
    for (int i = 0; i < THREAD_POOL_SIZE; i++)
    {
        args[i].counter = &ctr;
        args[i].threadId = i;
        pthread_create(&threads[i],
                       NULL,
                       worker,
                       &args[i]);
    }

    for (int i = 0; i < THREAD_POOL_SIZE; i++)
        Pthread_join(threads[i], NULL);

    printf("Counter = %d\n", get(&ctr));
}