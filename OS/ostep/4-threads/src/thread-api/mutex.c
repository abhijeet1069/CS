#include <stdio.h>
#include <pthread.h>

/**
Without mutex: race condition
    ./bin/app
    counter = 151699

With mutex: correct answer
    ./bin/app
    counter = 200000
 */

int counter = 0;
pthread_mutex_t mutex;

void *worker(void *arg)
{
    for (int i = 0; i < 100000; i++)
    {
        pthread_mutex_lock(&mutex);
        counter++; // critical section
        pthread_mutex_unlock(&mutex);
    }
    return NULL;
}

int main()
{
    pthread_t t1, t2;
    pthread_mutex_init(&mutex, NULL);
    pthread_create(&t1, NULL, worker, NULL);
    pthread_create(&t2, NULL, worker, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    printf("counter = %d\n", counter);
    pthread_mutex_destroy(&mutex);
    return 0;
}