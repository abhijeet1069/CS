#include <stdio.h>
#include <stdbool.h>
#include <unistd.h>
#include <pthread.h>
#include "../include/common_threads.h"

/**
satyam@satyam-2 4-threads % make all
rm -f bin/program
mkdir -p bin
gcc -I  -Wall -Wextra -pthread src/thread-api/program-with-threads.c -o bin/program
./bin/program
my turn
your turn
my turn
your turn
 *
 */

void *fun1()
{
    while (true)
    {
        printf("my turn\n");
        sleep(1);
    }
    return NULL;
}

void *fun2()
{
    while (true)
    {
        printf("your turn\n");
        sleep(2);
    }
    return NULL;
}

int main()
{
    pthread_t p1, p2;

    Pthread_create(&p1, NULL, fun1, NULL);
    Pthread_create(&p2, NULL, fun2, NULL);

    Pthread_join(p1, NULL);
    Pthread_join(p2, NULL);

    return 0;
}