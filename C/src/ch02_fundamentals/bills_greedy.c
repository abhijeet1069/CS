#include <stdio.h>

#define ARRAY_LEN(arr) ((int)(sizeof(arr) / sizeof((arr)[0])))

void showBills(int[], int, int);

int main()
{
    int currency[] = {500, 100, 20, 10, 5, 1};
    int amount = 5053;
    showBills(currency, ARRAY_LEN(currency), amount);
}

void showBills(int currency[], int curr_size, int balance)
{
    printf("Amount = Rs %d\n", balance);
    for (int i = 0; i < curr_size; i++)
    {
        int bills = balance / currency[i];
        balance = balance % currency[i];
        printf("Rs %d notes: %d\n", currency[i], bills);
    }
}