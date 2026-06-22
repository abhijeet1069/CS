#ifndef common_h
#define common_h

#include <sys/time.h>
#include <sys/stat.h>
#include <assert.h>

double GetTime()
{
    struct timeval t;
    int rc = gettimeofday(&t, NULL);
    assert(rc == 0);
    return (double)t.tv_sec + (double)t.tv_usec / 1e6;
}

/**
 * Waits for howlong
 */
void Spin(int howlong)
{
    double t = GetTime();
    while ((GetTime() - t) < (double)howlong)
        ;
}

#endif