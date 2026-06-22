// implementing join using semaphores, parent will wait for child's completion

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

sem_t s;

void *child()
{
    printf("child started\n");
    sleep(5);
    printf("child done\n");
    Sem_post(&s);
    return NULL;
}

int main()
{
    Sem_init(&s, 0);
    printf("parent started\n");
    pthread_t c;
    Pthread_create(&c, NULL, child, NULL);
    Sem_wait(&s);
    printf("parent done\n");
    return 0;
}