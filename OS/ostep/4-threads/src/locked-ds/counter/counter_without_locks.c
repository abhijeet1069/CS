#include <stdio.h>
#include "../include/common_threads.h"
#define THREAD_POOL_SIZE 1000

/**
 * //wrong answer in short time
 * ./bin/app
Counter = 66997466
make all  2.42s user 0.08s system 359% cpu 0.696 total
 *
 */

typedef struct __counter_t
{
    int value;
} counter_t;

void init(counter_t *c)
{
    c->value = 0;
}

void increment(counter_t *c)
{
    c->value++;
}

void decrement(counter_t *c)
{
    c->value--;
}

int get(counter_t *c)
{
    int rc = c->value;
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