#include <stdio.h>
#include <unistd.h>
#include <pthread.h>

// join is not there in this example.

#define BUFFER_SIZE 5

int buffer[BUFFER_SIZE];

int count = 0;

pthread_mutex_t lock;
pthread_cond_t can_consume;
pthread_cond_t can_produce;

void *producer()
{
    int item = 1;

    while (1)
    {
        pthread_mutex_lock(&lock);
        while (count == BUFFER_SIZE) // condition for waiting
        {
            printf("Producer waiting.. \n");
            pthread_cond_wait(&can_produce, &lock);
        }
        buffer[count] = item;
        printf("Produced %d\n", item);
        count++;
        item++;
        pthread_cond_signal(&can_consume);
        pthread_mutex_unlock(&lock);
        sleep(1);
    }
    return NULL;
}

void *consumer()
{
    while (1)
    {
        pthread_mutex_lock(&lock);
        while (count == 0) // condition for waiting
        {
            printf("Consumer waiting.. \n");
            pthread_cond_wait(&can_consume, &lock);
        }
        int item = buffer[count - 1];
        count--;

        printf("Consumed %d\n", item);
        pthread_cond_signal(&can_produce);
        pthread_mutex_unlock(&lock);
        sleep(3);
    }
    return NULL;
}

int main()
{
    pthread_t p;
    pthread_t c;
    pthread_mutex_init(&lock, NULL);
    pthread_cond_init(&can_consume, NULL);
    pthread_cond_init(&can_produce, NULL);
    pthread_create(&p, NULL, producer, NULL);
    pthread_create(&c, NULL, consumer, NULL);
    pthread_join(p, NULL);
    pthread_join(c, NULL);
    return 0;
}