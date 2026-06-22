#include <stdio.h>
#include <fcntl.h>
#include <unistd.h>

/***

Number systems in C:
123 - Decimal
0123 - Octal
0x123 - Hexadecimal

0664 - Owner Group Others
6 : rw-
4 : r-

Owner - Person who created the file
Group - Collection of users
Others : Everyone else on the system

chmod 444 p1.c //changes permission for file

444
│││
││└── others: read only
│└── group:  read only
└── owner:  read only
 *
 */

int main()
{
    printf("stdin  fd = %d\n", STDIN_FILENO);
    printf("stdout fd = %d\n", STDOUT_FILENO);
    printf("stderr fd = %d\n\n", STDERR_FILENO);

    int fd1 = open(
        "file1.txt",
        O_CREAT | O_WRONLY | O_TRUNC,
        0644);

    int fd2 = open(
        "file2.txt",
        O_CREAT | O_WRONLY | O_TRUNC,
        0644);

    printf("file1 fd = %d\n", fd1);
    printf("file2 fd = %d\n\n", fd2);

    write(fd1, "Hello File1\n", 12);
    write(fd2, "Hello File2\n", 12);

    write(
        STDOUT_FILENO,
        "Writing directly to stdout\n",
        27);

    close(fd1);
    close(fd2);

    return 0;
}