#include <stdio.h>
#include <string.h>
#include <unistd.h>
#include <pthread.h>
#include <stdlib.h>

/***
single thread execution
satyam@satyam-2 4-threads % time ./bin/app
res = 25
./bin/app  0.00s user 0.00s system 0% cpu 13.605 total

multithreaded execution
satyam@satyam-2 4-threads % time ./bin/app
res = 25
./bin/app  0.00s user 0.00s system 0% cpu 8.618 total
*/

typedef struct
{
    int a;
    int b;
    int op;
} binaryargs;

int add(int a, int b)
{
    sleep(5);
    return a + b;
}

int sub(int a, int b)
{
    sleep(3);
    return a - b;
}

void *mythread(void *arg)
{
    binaryargs *args = (binaryargs *)arg;
    int *res = malloc(sizeof(int));
    if (args->op == 0)
        *res = add(args->a, args->b);
    else
        *res = sub(args->a, args->b);
    return res;
}

int main()
{
    pthread_t ta1, ta2;
    binaryargs args1 = {10, 20, 0};
    binaryargs args2 = {2, 3, 0};
    void *addres1;
    void *addres2;
    void *res;
    pthread_create(&ta1, NULL, mythread, &args1);
    pthread_create(&ta2, NULL, mythread, &args2);

    void *result;
    pthread_join(ta1, &result);
    int *a = (int *)result;

    pthread_join(ta2, &result);
    int *b = (int *)result;

    printf("res = %d\n", sub(*a, *b));
    free(a);
    free(b);

    return 0;
}