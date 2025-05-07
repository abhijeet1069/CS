/** Computing 3x^5 + 2x^4 - 5x^3 - x^2 + 7x -6
 *
 * Horner's Rule algorithm:
 *
 * function horner(coeffs[], n, x):
    result = coeffs[0]
    for i = 1 to n-1:
        result = result * x + coeffs[i]
    return result

    •	coeffs is an array [a_n, a_{n-1}, ..., a_0]
    •	n is the number of coefficients
    •	x is the value at which the polynomial is evaluated
*/

#include <stdio.h>

#define ARRAY_LEN(arr) ((int)(sizeof(arr) / sizeof((arr)[0])))

long poly_at_x(int[], int, int);

int main(void)
{
    int coeff[] = {3, 2, -5, -1, 7, -6};
    int x = 5;
    long res = poly_at_x(coeff, ARRAY_LEN(coeff), x);
    printf("F(%d) = %ld\n", x, res);
}

long poly_at_x(int coeff[], int n, int x)
{
    long result = coeff[0];
    for (int i = 1; i < n; i++)
    {
        result = result * x + coeff[i];
    }
    return result;
}