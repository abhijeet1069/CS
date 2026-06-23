#include <stdio.h>
#include <pthread.h>
#include <semaphore.h>
#include <unistd.h>

/***
 *
This program can deadlock if
P0 takes fork 0
P1 takes fork 1
P2 takes fork 2
P3 takes fork 3
P4 takes fork 4

Now everybody wants the next fork:

Deadlock Prevention Techniques

1. Resource Ordering: Always acquire forks in a fixed order (e.g., lower-numbered fork first).
2. Asymmetric Solution: One philosopher picks up the right fork first while others pick up the left fork first.
3. Waiter Solution: Allow at most four philosophers to compete for forks simultaneously.
4. Try-Lock Approach: Release acquired forks and retry later if both forks cannot be obtained.
*
 */

#define N 5

sem_t forks[N];

int left(int p)
{
    return p;
}

int right(int p)
{
    return (p + 1) % N;
}

void think(int p)
{
    printf("Philosopher %d is thinking\n", p);
    sleep(1);
}

void eat(int p)
{
    printf("Philosopher %d is eating\n", p);
    // sleep(1);
}

void *philosopher(void *arg)
{
    int id = *(int *)arg;

    while (1)
    {
        think(id);

        printf("Philosopher %d wants forks\n", id);

        sem_wait(&forks[left(id)]);
        sleep(1);
        sem_wait(&forks[right(id)]);

        eat(id);

        sem_post(&forks[left(id)]);
        sem_post(&forks[right(id)]);
    }

    return NULL;
}

int main()
{
    pthread_t philosophers[N];
    int ids[N];

    for (int i = 0; i < N; i++)
    {
        sem_init(&forks[i], 0, 1);
    }

    for (int i = 0; i < N; i++)
    {
        ids[i] = i;
        pthread_create(&philosophers[i], NULL, philosopher, &ids[i]);
    }

    for (int i = 0; i < N; i++)
    {
        pthread_join(philosophers[i], NULL);
    }

    return 0;
}