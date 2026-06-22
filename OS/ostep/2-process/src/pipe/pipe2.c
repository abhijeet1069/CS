/**
 * same as doing
 * ls -l | wc -l
 *
 */

#include <stdio.h>
#include <unistd.h>
#include <sys/wait.h>

int main()
{
    int fd[2];

    pipe(fd);

    if (fork() == 0)
    {
        // make stdout point to same write end of pipe
        dup2(fd[1], STDOUT_FILENO);

        close(fd[0]);
        close(fd[1]);

        execlp("ls", "ls", "-l", NULL);
    }

    if (fork() == 0)
    {
        dup2(fd[0], STDIN_FILENO);

        close(fd[1]);
        close(fd[0]);

        execlp("wc", "wc", "-l", NULL);
    }

    close(fd[0]);
    close(fd[1]);

    wait(NULL);
    wait(NULL);
    return 0;
}