#include <stdio.h>
int main()
{
    printf("Size of int: %zu\n", sizeof(int));
    printf("Size of long: %zu\n", sizeof(long));
    printf("Size of void *: %zu\n", sizeof(void *));
    printf("Size of size_t: %zu\n", sizeof(size_t));
}