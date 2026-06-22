#include <stdio.h>
#include <unistd.h>
#include <assert.h>
#include <string.h>
#include <fcntl.h>
#include <sys/stat.h>
#include <sys/types.h>

/**
./io writes hello world to a file.

fsync() is one of those functions that makes a lot more sense once you understand that writing to a file
doesn’t necessarily write to the disk immediately.

Program
   |
   v
Kernel Page Cache (RAM)
   |
   v
Disk (later)

The kernel keeps the data in memory and writes it to disk whenever it feels like it.

fsync() tells the kernel:
“Don’t return until the file’s data has actually reached stable storage.”

Program
   |
write()
   |
RAM cache
   |
fsync()
   |
Disk
   |
return

But do note fsync is expensive

O_WRONLY - open for writing only
O_CREAT - create file if it doesen't exist
O_TRUNC - truncate the file to length 0

// 2nd argument group
S_IRUSR - user can read
S_IWUSR - user can write

chmod 600 file.txt
Owner: rw-
Group: ---
Other: ---

sprintf() means string print formatted.
It works like printf(), but instead of printing to the terminal, it writes the
formatted output into a character buffer.

satyam@satyam-2 1-intro % ./io
writes hello world to file.txt

Do note, sprintf() won't work for strings larger than buffer.
or
 */

int main(int argc, char *argv[])
{
    int fd = open("/Users/satyam/Personal/Temp/OS/ostep/1-intro/file.txt",
                  O_WRONLY | O_CREAT | O_TRUNC, S_IRUSR | S_IWUSR);
    assert(fd >= 0);
    char buffer[20];
    sprintf(buffer, "hello world\n");
    int rc = write(fd, buffer, strlen(buffer));
    assert(rc == strlen(buffer));
    fsync(fd);
    close(fd); // close file descriptor
    return 0;
}