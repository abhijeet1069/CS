#include <stdio.h>
#include <unistd.h>
#include <stdlib.h>
#include "../include/common_threads.h"
#ifdef linux
#include <semaphore.h>
#elif __APPLE__
#include "zemaphore.h"
#endif

#define BUFFER_SIZE 5

int buffer[BUFFER_SIZE];
int in = 0;
int out = 0;

sem_t empty;
sem_t full;
sem_t mutex;

void *producer()
{
    for (int i = 1; i <= 20; i++) // 20 items produced per producer
    {
        Sem_wait(&empty); // producer waits on empty
        Sem_wait(&mutex);

        buffer[in] = i;
        printf("Produced: %d\n", i);
        in = (in + 1) % BUFFER_SIZE;
        Sem_post(&mutex);
        Sem_post(&full);
        sleep(1);
    }
    return NULL;
}

void *consumer()
{
    for (int i = 1; i <= 10; i++) // 10 items consumed per cumsumer
    {
        Sem_wait(&full); // comsumer waits on full
        Sem_wait(&mutex);

        int item = buffer[out];
        printf("Consumed: %d\n", item);

        out = (out + 1) % BUFFER_SIZE;
        Sem_post(&mutex);
        Sem_post(&empty);
        sleep(2);
    }
    return NULL;
}

int main()
{
    pthread_t producer_thread, consumer_thread1, consumer_thread2;

    Sem_init(&empty, BUFFER_SIZE); // fully empty
    Sem_init(&full, 0);            // not full
    Sem_init(&mutex, 1);           // allow only 1 thread to update buffer

    Pthread_create(&producer_thread, NULL, producer, NULL);
    Pthread_create(&consumer_thread1, NULL, consumer, NULL);
    Pthread_create(&consumer_thread2, NULL, consumer, NULL);

    pthread_join(producer_thread, NULL);
    pthread_join(consumer_thread1, NULL);
    pthread_join(consumer_thread2, NULL);

    return 0;
}