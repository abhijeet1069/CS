#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
#include "../include/common.h"
#include "../include/common_threads.h"

volatile int done = 0;

void *child()
{
    printf("child\n");
    sleep(20);
    done = 1;
    return NULL;
}

int main()
{
    pthread_t p;
    printf("parent: begin\n");
    Pthread_create(&p, NULL, child, NULL);
    while (done == 0)
        ; // wastes CPU cycles, justs spins to keep living in memory
    printf("parent: end\n");
    return 0;
}