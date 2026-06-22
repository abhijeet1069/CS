/**
Another way for conditional execution for parent and child process

RETURN VALUE of fork:
       On success, the PID of the child process is returned in the
       parent, and 0 is returned in the child.  On failure, -1 is
       returned in the parent, no child process is created
 */

#include <stdio.h>
#include <sys/types.h>
#include <unistd.h>

int main()
{
    int i = 10;
    printf("Hello before calling fork()\n");
    pid_t ppid = getpid();
    fork();
    pid_t pid = getpid();
    if (ppid != pid)
    {
        i = 20;
        printf("hello from child process i : %d\n", i);
    }
    else
    {
        printf("hello from parent process i = %d\n", i);
    }
}