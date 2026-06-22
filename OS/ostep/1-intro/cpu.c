#include <stdio.h>
#include <stdlib.h>
#include "common.h"

/**
 * Foreground vs Background Jobs

A terminal can have only one foreground process group at a time.
The foreground job owns the terminal:
    * Receives keyboard input
    * Receives Ctrl+C (SIGINT)
    * Receives Ctrl+Z (SIGTSTP)
A background job runs without owning the terminal.

satyam@satyam-2 1-intro % ./cpu "hello"
hello
hello
hello

If we run multiple jobs, the program will stop recieving input.
One process will stop other will continue to keep on running

./cpu "hello" & ./cpu "bye"
 *
 */

int main(int argc, char *argv[])
{
    if (argc != 2)
    {
        fprintf(stderr, "usage : cpu <string>\n");
        exit(1);
    }

    char *str = argv[1];
    while (1)
    {
        printf("%s\n", str);
        Spin(1);
    }
    return 0;
}