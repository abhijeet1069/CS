#include <stdio.h>

// very similar to callback
int add(int a, int b)
{
    return a + b;
}

int multiply(int a, int b)
{
    return a * b;
}

int calculate(int (*op)(int, int), int a, int b)
{
    return op(a, b);
}

int main()
{
    printf("%d\n", calculate(add, 2, 3));
    printf("%d\n", calculate(multiply, 2, 3));
}