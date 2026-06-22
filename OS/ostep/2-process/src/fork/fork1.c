/**
 * fork() copies the entire address space of the current process to create a new process
 * which includes program counter
 *
 * gcc -Wall -Wextra src/fork/fork1.c -o bin/app
./bin/app
count: 1 , PID : 4950
count: 2 , PID : 4950
count: 3 , PID : 4950
count: 4 , PID : 4950
count: 5 , PID : 4950
fork()
count: 6 , PID : 4950 //parent
count: 6 , PID : 4958 //child
count: 7 , PID : 4958
count: 7 , PID : 4950
count: 8 , PID : 4958
count: 8 , PID : 4950
count: 9 , PID : 4958
count: 9 , PID : 4950
count: 10 , PID : 4958
count: 10 , PID : 4950
 *
 */

#include <stdio.h>
#include <unistd.h>

int main()
{
    int i = 1;
    for (; i <= 5; i++)
    {
        printf("count: %d , PID : %d\n", i, getpid());
        sleep(1);
    }

    printf("fork()\n¬");
    fork();

    for (; i <= 10; i++)
    {
        printf("count: %d , PID : %d\n", i, getpid());
        sleep(1);
    }
}