#include <stdio.h>

int counter = 0; // external variable

void increment()
{
    counter++;
}

int main()
{
    increment();
    printf("Counter: %d\n", counter); // Output: Counter: 1
    return 0;
}