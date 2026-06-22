#include <stdio.h>
#include <unistd.h>
#include <string.h>

/**
A pipe is a kernel-provided communication channel between processes.
The pipe() system call creates:

- two file descriptors
- fd[0] -> read end
- fd[1] -> write end

Kernel stores bytes temporarily:
write --> kernel buffer --> read
 *
 */

int main()
{
    int fd[2];
    pipe(fd);
    int rc = fork();
    if (rc == 0) // child is reading
    {
        close(fd[1]); // close write
        char buffer[100];
        read(fd[0], buffer, sizeof(buffer));
        printf("child recieved: %s\n", buffer);
        close(fd[0]);
    }
    else
    {
        // close(fd[0]); // close read
        char *msg = "Hello from parent";
        write(fd[1], msg, strlen(msg) + 1);
        close(fd[1]);
    }
    return 0;
}