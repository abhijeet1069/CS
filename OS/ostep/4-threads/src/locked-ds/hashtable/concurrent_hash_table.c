#include <stdlib.h>
#include <pthread.h>
#include <stdio.h>

/**
 * Here instead of one big lock on hashtable, locks are given at bucket end.
 * So, each thread can access buckets separately
 *
 * Contention means multiple threads want the same resource at the same time.
 *
 */

typedef struct __node_t
{
    int key;
    struct __node_t *next;
} node_t;

typedef struct __list_t
{
    node_t *head;
    pthread_mutex_t lock; // this is smart, only the list have locks, each list can be inserted independently
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

void list_destroy(list_t *l)
{
    pthread_mutex_lock(&l->lock);
    node_t *curr = l->head;
    while (curr)
    {
        node_t *tmp = curr;
        curr = curr->next;
        free(tmp);
    }
    pthread_mutex_unlock(&l->lock);
    pthread_mutex_destroy(&l->lock);
}

#define BUCKETS 101
typedef struct __hash_t
{
    list_t lists[BUCKETS];
} hash_t;

void hash_init(hash_t *h)
{
    for (int i = 0; i < BUCKETS; i++)
        list_init(&h->lists[i]);
}

int hash_insert(hash_t *h, int key)
{
    int bucket = key % BUCKETS;
    return list_insert(&h->lists[bucket], key);
}

int hash_lookup(hash_t *h, int key)
{
    int bucket = key % BUCKETS;
    return list_lookup(&h->lists[bucket], key);
}

void hash_destroy(hash_t *h)
{
    for (int i = 0; i < BUCKETS; i++)
        list_destroy(&h->lists[i]);
}

void hash_print(hash_t *h)
{
    for (int i = 0; i < BUCKETS; i++)
    {
        list_t *list = &h->lists[i];
        node_t *curr = list->head;
        printf("bucket %d ->", i);
        while (curr != NULL)
        {
            printf(" %d ", curr->key);
            curr = curr->next;
        }
        printf("\n");
    }
}

#define THREADS 4
#define ITEMS_PER_THREAD 10

hash_t table;

void *worker(void *arg)
{
    int id = *(int *)arg;
    for (int i = 0; i < ITEMS_PER_THREAD; i++)
        hash_insert(&table, id);
    return NULL;
}

int main()
{
    hash_init(&table);
    pthread_t threads[THREADS];
    int ids[THREADS];
    for (int i = 0; i < THREADS; i++)
    {
        ids[i] = i;
        pthread_create(&threads[i], NULL, worker, &ids[i]);
    }

    for (int i = 0; i < THREADS; i++)
        pthread_join(threads[i], NULL);

    // printf("Lookup = %d\n", hash_lookup(&table, 42));
    // printf("Lookup = %d\n", hash_lookup(&table, 2));
    hash_print(&table);
    hash_destroy(&table);
    return 0;
}