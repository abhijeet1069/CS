/**
Producer and consumer can often proceed simultaneously.
That’s the big idea.

Producer Thread
      |
      v
 tail_lock

Consumer Thread
      |
      v
 head_lock

 ./bin/app
Dequeued 1
Dequeued 1
Dequeued 1
Dequeued 1
Dequeued 2
Dequeued 2
Dequeued 2
Dequeued 2
Dequeued 3
Dequeued 3
Dequeued 3
Dequeued 3
Dequeued 4
Dequeued 4
Dequeued 4
Dequeued 4
Items dequeued 16

 */
#include <stdio.h>
#include <pthread.h>
#include <stdlib.h>
#include <assert.h>

typedef struct __node_t
{
    int value;
    struct __node_t *next;
} node_t;

typedef struct __queue_t
{
    node_t *head;
    node_t *tail;
    pthread_mutex_t head_lock;
    pthread_mutex_t tail_lock;
} queue_t;

void queue_init(queue_t *q)
{
    node_t *dummy = malloc(sizeof(node_t));
    assert(dummy != NULL);
    dummy->next = NULL;
    q->head = dummy;
    q->tail = dummy;
    pthread_mutex_init(&q->head_lock, NULL);
    pthread_mutex_init(&q->tail_lock, NULL);
}

void queue_enqueue(queue_t *q, int value)
{
    node_t *tmp = malloc(sizeof(node_t));
    assert(tmp != NULL);
    tmp->value = value;
    tmp->next = NULL;
    pthread_mutex_lock(&q->tail_lock);

    q->tail->next = tmp;
    q->tail = tmp;

    pthread_mutex_unlock(&q->tail_lock);
}

int queue_dequeue(queue_t *q, int *value)
{
    pthread_mutex_lock(&q->head_lock);
    node_t *tmp = q->head;
    node_t *new_head = tmp->next;
    if (new_head == NULL) // trying to dequeue an empty list
    {
        pthread_mutex_unlock(&q->head_lock);
        return -1;
    }
    *value = new_head->value;
    q->head = new_head;
    pthread_mutex_unlock(&q->head_lock);
    free(tmp);
    return 0;
}

void queue_destroy(queue_t *q)
{
    int value;
    while (queue_dequeue(q, &value) == 0)
        ;
    free(q->head);
    pthread_mutex_destroy(&q->head_lock);
    pthread_mutex_destroy(&q->tail_lock);
}

#define PRODUCERS 100
#define ITEMS_PER_THREAD 100

queue_t queue;

void *producer(void *arg)
{
    int id = *(int *)arg;
    for (int i = 0; i < ITEMS_PER_THREAD; i++)
    {
        queue_enqueue(&queue, id);
    }
    return NULL;
}

int main()
{
    queue_init(&queue);
    pthread_t threads[PRODUCERS];
    for (int i = 0; i < PRODUCERS; i++)
        pthread_create(&threads[i], NULL, producer, &i);
    for (int i = 0; i < PRODUCERS; i++)
        pthread_join(threads[i], NULL);

    int value;
    int count = 0;

    while (queue_dequeue(&queue, &value) == 0)
    {
        printf("Dequeued %d \n", value);
        count++;
    }

    printf("Items dequeued %d\n", count);
    queue_destroy(&queue);
    return 0;
}