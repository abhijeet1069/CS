/**
Signal handlers are basically like callbacks trigerred by the OS

OS Event
    ↓
Your Function
 */

#include <stdio.h>
#include <signal.h>
#include <unistd.h>

void handle_signal(int sig)
{
    printf("Caught SIGINT\n");
}

int main()
{
    // OS:
    // If SIGINT ever arrives,
    // call handle_sigint()
    signal(SIGINT, handle_signal); // registers a callback, You’re registering interest in a future event.
    while (1)
    {
        // sleep(1);
    }
    return 0;
}