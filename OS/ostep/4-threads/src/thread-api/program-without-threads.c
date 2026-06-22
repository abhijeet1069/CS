#include <stdio.h>
#include <stdbool.h>
#include <unistd.h>

/**
gcc -I  -Wall -Wextra -pthread src/thread-api/program-without-threads.c -o bin/program
./bin/program
my turn
my turn
my turn
my turn
my turn
my turn
 *
 */

void fun1()
{
    while (true)
    {
        printf("my turn\n");
        sleep(1);
    }
}

void fun2()
{
    while (true)
    {
        printf("your turn\n");
        sleep(2);
    }
}

int main()
{
    fun1();
    fun2();
}