#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>
#include <string.h>

/**
 *
File descriptor is a small integer that represents an open resource.

- Input : 0
- Output : 1
- Errors : 2
open always returns the lowest numbered file descriptor

satyam@satyam-2 2-process % make all
.
.
fd = 61436
fd = 61437
fd = 61438
fd = 61439
fd = -1
open failed: Too many open files
 *
 */

int main()
{
    while (1)
    {
        int fd = open(
            "file1.txt",
            O_CREAT | O_WRONLY | O_APPEND,
            0644);
        printf("fd = %d\n", fd);

        if (fd == -1)
        {
            perror("open failed");
            return 1;
        }
        char buffer[100];

        sprintf(
            buffer,
            "My file descriptor is %d\n", fd);

        write(fd, buffer, strlen(buffer));
    }
    return 0;
}