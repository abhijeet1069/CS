#include <stdio.h>
#include <stdlib.h>
#include <sys/time.h>

int main(int argc, char *argv[])
{
    if (argc != 3)
    {
        printf(
            "usage: %s <pages> <trials>\n",
            argv[0]);

        return 1;
    }

    int pages = atoi(argv[1]);
    int trials = atoi(argv[2]);

    int pageSize = 16384;
    int jump = pageSize / sizeof(int);

    int *arr = (int *)malloc(pages * pageSize);

    if (arr == NULL)
    {
        perror("malloc failed");
        return 1;
    }

    struct timeval start, end;

    gettimeofday(&start, NULL);

    for (int t = 0; t < trials; t++)
    {
        for (int i = 0; i < pages; i++) // touch integer in a different page
        {
            arr[i * jump] += 1;
        }
    }

    gettimeofday(&end, NULL);

    long seconds =
        end.tv_sec - start.tv_sec;

    long useconds =
        end.tv_usec - start.tv_usec;

    double elapsed =
        seconds +
        useconds / 1000000.0;

    printf(
        "Pages: %d Time: %f seconds\n",
        pages,
        elapsed);

    free(arr);

    return 0;
}