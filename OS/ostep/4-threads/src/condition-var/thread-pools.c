#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <pthread.h>

#define NUM_WORKERS 3
#define MAX_TASKS 100

typedef struct
{
    void (*function)(void *);
    void *arg;
} task_t;

task_t queue[MAX_TASKS];

int head = 0;
int tail = 0;
int count = 0;

pthread_mutex_t lock = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t not_empty = PTHREAD_COND_INITIALIZER;

void submit(task_t task)
{
    pthread_mutex_lock(&lock);
    if (count == MAX_TASKS)
    {
        printf("Queue full\n");
        pthread_mutex_unlock(&lock);
        return;
    }
    queue[tail] = task;
    tail = (tail + 1) % MAX_TASKS;
    count++;
    pthread_cond_signal(&not_empty);
    pthread_mutex_unlock(&lock);
}

void *worker(void *arg)
{
    int id = *(int *)arg;
    while (1)
    {
        pthread_mutex_lock(&lock);
        while (count == 0)
        {
            printf("Worker %d waiting \n", id);
            pthread_cond_wait(&not_empty, &lock);
        }
        task_t task = queue[head];
        head = (head + 1) % MAX_TASKS;
        count--;
        pthread_mutex_unlock(&lock);
        task.function(task.arg);
    }
    return NULL;
}

void print_task(void *arg)
{
    int value = *(int *)arg;
    printf("Thread %lu processing task %d\n", (unsigned long)pthread_self(), value);
    sleep(1);
    free(arg);
}

int main()
{
    pthread_t workers[NUM_WORKERS];
    int ids[NUM_WORKERS];
    for (int i = 0; i < NUM_WORKERS; i++)
    {
        ids[i] = i + 1;
        pthread_create(&workers[i], NULL, worker, &ids[i]);
    }
    sleep(1);

    for (int i = 0; i < 10; i++)
    {
        int *value = malloc(sizeof(int));
        *value = i;
        task_t task;
        task.function = print_task;
        task.arg = value;
        printf(
            "Main: submitting task %d\n", i);
        submit(task);
    }
    sleep(10);
    return 0;
}