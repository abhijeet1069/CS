/**

Mutex = ownership

Condition Variable = wait until some condition becomes true

Semaphore = count available permits/resources

Basic idea of semaphore:

wait():
    if count > 0
        count--
        continue
    else
        sleep

post():
    count++
    wake someone
 */

#include <stdio.h>
#include <stdlib.h>
#include "zemaphore.h"
#include <unistd.h>

#define VAL 71
#define BUFFER_LENGTH 5
int arr[BUFFER_LENGTH];
Zem_t empty_slots;

void *child()
{
    int i = 0;
    while (1)
    {
        Zem_wait(&empty_slots);
        arr[i] = VAL;
        printf("Produced item at index %d\n", i);
        i++;
        sleep(1);
    }
    return NULL;
}

int main()
{
    pthread_t c1, c2;
    Zem_init(&empty_slots, 3);
    Pthread_create(&c1, NULL, child, NULL);
    Pthread_create(&c2, NULL, child, NULL);
    Pthread_join(c1, NULL);
    Pthread_join(c2, NULL);
    return 0;
}