#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include "include/common.h"
#include "include/common_threads.h"

/**
# Threads

Threads are like multiple execution paths inside same process.
    While processes are completely separate virtual memory worlds.

Threads INSIDE same process share:

* heap
* globals
* virtual memory
* file descriptors

But each thread has:

* its own stack
* registers
* program counter

 */

void *mythread(void *arg)
{
    printf("%s\n", (char *)arg);
    return NULL;
}

int main()
{

    pthread_t p1, p2;
    printf("main: begin\n");

    Pthread_create(&p1, NULL, mythread, "A");
    Pthread_create(&p2, NULL, mythread, "B");

    Pthread_join(p1, NULL);
    Pthread_join(p2, NULL);
    printf("main: end\n");

    return 0;
}
