#include <unistd.h>
#include <stdio.h>
#include <stdlib.h>
#include "common.h"

int main(int argc, char *argv[])
{
    if (argc != 2)
    {
        fprintf(stderr, "usage: mem <value>\n");
        exit(1);
    }
    int *p = (int *)malloc(sizeof(int));
    assert(p != NULL);
    printf("(%d) addr pointed to by p: %p\n", (int)getpid(), p);
    *p = atoi(argv[1]); // ASCII to integer
    while (1)
    {
        // sleep(1); // gives very low cpu utilisation
        Spin(1); // gives high cpu utilisation
        *p = *p + 1;
        printf("(%d) value of p: %d\n", getpid(), *p);
    }
    return 0;
}