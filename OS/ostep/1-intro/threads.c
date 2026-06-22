#include <stdio.h>
#include <stdlib.h>
#include "common.h"
#include "common_threads.h"

volatile int counter = 0; // shared state

void *worker(void *arg)
{
    int loops = *((int *)arg); // read 4 bytes of data
    for (int i = 0; i < loops; i++)
        counter++;
    return NULL;
}

int main(int argc, char *argv[])
{
    if (argc != 2)
    {
        fprintf(stderr, "usage: threads <loops>\n");
        exit(1);
    }
    int loops = atoi(argv[1]);
    pthread_t p1, p2;
    printf("Initial value : %d\n", counter);
    Pthread_create(&p1, NULL, worker, &loops); // loops is passing argument to thread
    Pthread_create(&p2, NULL, worker, &loops);
    Pthread_join(p1, NULL);
    Pthread_join(p2, NULL);
    printf("Final value   : %d\n", counter);
    return 0;
}