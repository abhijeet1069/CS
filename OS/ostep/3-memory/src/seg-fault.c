#include <stdio.h>
#include <stdlib.h>
#include <string.h>

// ./bin/app
// make: *** [all] Segmentation fault: 11
void accessingRandomInvalidPointer()
{
    int *ptr = (int *)0x1234; // virtual address not mapped for this process,
    *ptr = 10;                // kernel stops illegal access
}

// ./bin/app
// make: *** [all] Segmentation fault: 11s
void dereferencingNullPointer()
{
    int *ptr = NULL;      // NULL = address 0x0
    printf("%d\n", *ptr); // Modern OS intentionally leave low memory unmapped.
}

//./bin/app
// make : ***[all] Bus error : 10

void writingToStringliteral()
{
    char *s = "hello"; // literal reside in read only memory
    s[0] = 'J';
}

//./bin/app
// make: *** [all] Trace/BPT trap: 5
void bufferOverflow()
{
    char buffer[10];
    strcpy(buffer, "this string is enormous");
}

void wrongIndexAccess()
{
    int arr[100];
    printf("%d\n", arr[100]);
}

int main()
{
    wrongIndexAccess();
    return 0;
}