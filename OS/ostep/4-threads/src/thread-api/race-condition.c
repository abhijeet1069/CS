#include<stdio.h>
#include<stdlib.h>
#include<pthread.h>

#include "include/common.h"
#include "include/common_threads.h"

/***
satyam@satyam-2 4-threads % ./bin/app 5000
main: begin [counter = 0] [c8c000]
A: begin [addr of i: 0x16f202fac]
B: begin [addr of i: 0x16f28efac]
A: done
B: done
main: done
 [counter: 8257]
 [should: 10000]
*/

int max;
// volatile “This memory may change unexpectedly — do NOT aggressively optimize accesses.”
volatile int counter = 0; //shared global data

void *mythread(void* arg){
    char *letter = arg;
    int i;
    printf("%s: begin [addr of i: %p]\n", letter, &i);
    for(i = 0; i < max; i++)
        counter = counter+1;
    printf("%s: done\n", letter);
    return NULL;
}

int main(int argc, char *argv[]){
    if (argc != 2) {
	fprintf(stderr, "usage: main-first <loopcount>\n");
	exit(1);
    }
    max = atoi(argv[1]);

    pthread_t p1, p2;
    printf("main: begin [counter = %d] [%x]\n", counter, 
        (unsigned int) &counter);
    Pthread_create(&p1, NULL, mythread, "A"); 
    Pthread_create(&p2, NULL, mythread, "B");
    Pthread_join(p1, NULL); 
    Pthread_join(p2, NULL); 
    printf("main: done\n [counter: %d]\n [should: %d]\n", 
	   counter, max*2);
    return 0;
}