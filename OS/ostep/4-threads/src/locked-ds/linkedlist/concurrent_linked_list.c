#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

/**
 *
The list is inserting at front of list.

rm -f bin/app
mkdir -p bin
gcc -I  -Wall -Wextra -pthread src/linkedlist/concurrent_linked_list.c -o bin/app
./bin/app
0-> 0-> 0-> 0-> 0-> NULL
3-> 3-> 3-> 3-> 3-> 0-> 0-> 0-> 0-> 0-> NULL
1-> 1-> 1-> 1-> 1-> 3-> 3-> 3-> 3-> 3-> 0-> 0-> 0-> 0-> 0-> NULL
2-> 2-> 2-> 2-> 2-> 1-> 1-> 1-> 1-> 1-> 3-> 3-> 3-> 3-> 3-> 0-> 0-> 0-> 0-> 0-> NULL
Lookup 42 = -1
Lookup 999999 = -1

 */

typedef struct __node_t
{
    int key;
    struct __node_t *next;
} node_t;

typedef struct __list_t
{
    node_t *head;
    pthread_mutex_t lock;
} list_t;

void list_init(list_t *l)
{
    l->head = NULL;
    pthread_mutex_init(&l->lock, NULL);
}

int list_insert(list_t *l, int key)
{
    pthread_mutex_lock(&l->lock);
    node_t *newNode = malloc(sizeof(node_t));
    if (newNode == NULL)
    {
        perror("malloc failed");
        pthread_mutex_unlock(&l->lock);
        return -1;
    }
    newNode->key = key;
    newNode->next = l->head;
    l->head = newNode;
    pthread_mutex_unlock(&l->lock);
    return 0;
}

int list_lookup(list_t *l, int key)
{
    pthread_mutex_lock(&l->lock);
    node_t *curr = l->head;
    while (curr != NULL)
    {
        if (curr->key == key)
        {
            pthread_mutex_unlock(&l->lock);
            return 0;
        }
        curr = curr->next;
    }
    pthread_mutex_unlock(&l->lock);
    return -1;
}

void list_print(list_t *l)
{
    pthread_mutex_lock(&l->lock);
    node_t *curr = l->head;
    while (curr != NULL)
    {
        printf("%d-> ", curr->key);
        curr = curr->next;
    }
    printf("NULL\n");
    pthread_mutex_unlock(&l->lock);
}

void list_destroy(list_t *l)
{
    pthread_mutex_lock(&l->lock);
    node_t *curr = l->head;
    while (curr != NULL)
    {
        node_t *temp = curr;
        curr = curr->next;
        free(temp);
    }

    l->head = NULL;
    pthread_mutex_unlock(&l->lock);
    pthread_mutex_destroy(&l->lock);
}

#define NUM_THREADS 4
#define ITEMS_PER_THREAD 5

list_t list;
void *worker(void *arg)
{
    int threadId = *(int *)arg;
    for (int i = 0; i < ITEMS_PER_THREAD; i++)
    {
        list_insert(
            &list,
            threadId);
    }
    list_print(&list);
    return NULL;
}

int main()

{
    pthread_t threads[NUM_THREADS];
    int ids[NUM_THREADS];
    list_init(&list);
    for (int i = 0; i < NUM_THREADS; i++)
    {
        ids[i] = i;
        pthread_create(
            &threads[i],
            NULL,
            worker,
            &ids[i]);
    }

    for (int i = 0; i < NUM_THREADS; i++)
    {
        pthread_join(
            threads[i],
            NULL);
    }

    printf("Lookup 42 = %d\n",
           list_lookup(&list, 42));

    printf("Lookup 999999 = %d\n",
           list_lookup(&list, 999999));

    list_destroy(&list);
    return 0;
}