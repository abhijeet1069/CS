#include <stdio.h>
#include <unistd.h>
#include <sys/types.h>

/***
./bin/app
child
global_var = 42, addr = 0x104398000
local_var = 100, addr = 0x16ba6ebd8

Parent
global_var = 42, addr = 0x104398000 //also parent and child have same memory location but different value
local_var = 100, addr = 0x16ba6ebd8 // which doesen't make sense, these are virtual address

child after modification
global_var = 999
local_var = 888

parent after child modification //no affect on parent, not even for global variable
global_var = 42
local_var = 100
 */

int global_var = 42;

int main()
{
    int local_var = 100;
    pid_t pid = fork();
    if (pid == 0)
    {
        printf("child\n");
        printf("global_var = %d, addr = %p\n", global_var, (void *)&global_var);
        printf("local_var = %d, addr = %p\n", local_var, (void *)&local_var);

        global_var = 999;
        local_var = 888;

        sleep(2);

        printf("child after modification\n");
        printf("global_var = %d\n", global_var);
        printf("local_var = %d\n", local_var);
    }
    else
    {
        sleep(1);
        printf("Parent\n");
        printf("global_var = %d, addr = %p\n", global_var, (void *)&global_var);
        printf("local_var = %d, addr = %p\n", local_var, (void *)&local_var);
        sleep(3);
        printf("parent after child modification\n");
        printf("global_var = %d\n", global_var);
        printf("local_var = %d\n", local_var);
    }
}