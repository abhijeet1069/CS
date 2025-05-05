#include <stdio.h>
#define INCHES_PER_POUND 166

int main()
{
    int height = 8, length = 12, width = 10;
    int volume = (height * length * width);
    int dim_weight = (volume + (INCHES_PER_POUND - 1)) / INCHES_PER_POUND;

    printf("Dimensions: %d\" x %d\" x %d\"\n", length, width, height);
    printf("Volume: %d\n", volume);
    printf("Dimensional weight (pounds): %d\n", dim_weight);

    return 0;
}