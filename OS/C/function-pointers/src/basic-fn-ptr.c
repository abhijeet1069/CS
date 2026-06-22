// Function pointers let you treat functions like data.
#include <stdio.h>

int add(int a, int b)
{
    return a + b;
}

int square(int s)
{
    return s * s;
}

int main()
{
    int (*bin_fn)(int, int); // function pointer
    bin_fn = add;

    int (*un_fn)(int);
    un_fn = square;

    printf("%d\n", un_fn(bin_fn(2, 3)));
    return 0;
}