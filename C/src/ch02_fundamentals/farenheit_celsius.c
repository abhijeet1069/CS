#include <stdio.h>

#define FREEZING_PT 32.0f
#define SCALE_FACTOR (5.0f / 9.0f)

int main()
{
    float farenheit = 101.0f, celsius = 0.0f;
    celsius = (farenheit - FREEZING_PT) * SCALE_FACTOR;
    printf("Farenheit: %.1f\n", farenheit);
    printf("Celsius: %.1f\n", celsius);
    return 0;
}