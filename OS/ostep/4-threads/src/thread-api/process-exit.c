

/**
 *
return 0 actually exits the process, which includes
every thread associated with the process
On process exit, OS will free every resource attached to the it.
gcc -I  -Wall -Wextra -pthread src/thread-api/process-exit.c -o bin/program
./bin/program
child
child
child
child
child
parent exit
 */

#include <stdio.h>
#include <unistd.h>
#include <pthread.h>
#include <stdbool.h>
#include "../include/common_threads.h"

void *thread()
{
    while (true)
    {
        printf("child\n");
        sleep(1);
    }
}

int main()
{
    pthread_t c;
    Pthread_create(&c, NULL, thread, NULL);
    sleep(5);
    printf("parent exit\n");
    return 0;
}