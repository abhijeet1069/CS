#include <stdio.h>
#include <stdlib.h>

/**
 * gcc -Wall -Wextra src/va.c -o bin/app
./bin/app
location of code: 0x100324460 //near about start of virtual address space
location of heap: 0xcd4000000
location of stack: 0x16fada9c8 //near about end of virtual address space

gcc -fsanitize=address -g main.c -o app
 *
 */

int main()
{
    printf("location of code: %p\n", main);
    printf("location of heap: %p\n", malloc(100e6));
    int x = 3;
    printf("location of stack: %p\n", &x);
    return 0;
}