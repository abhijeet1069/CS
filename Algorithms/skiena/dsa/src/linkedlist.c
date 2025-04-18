#include <ctype.h>
#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

#include "list.h"

list *init_list(void)
{
    return NULL;
}

bool empty_list(list *l)
{
    if (l == NULL)
        return true;
    else
        return false;
}

list *item_ahead(list *l, list *x)
{
    if (l == NULL || l->next == NULL)
        return NULL;

    if (l->next == x)
        return l;
    else
        return item_ahead(l->next, x);
}

// insert node at beginning
void insert_list(list **l, item_type x)
{
    list *p;
    p = malloc(sizeof(list));
    p->item = x;
    p->next = *l;
    *l = p;
}

void print_list(list *l)
{
    while (l != NULL)
    {
        printf("%d ", l->item);
        l = l->next;
    }
    printf("\n");
}

int main()
{
    list *ll = init_list();
    char *str = "fe fi fo fum";

    for (char *ch = str; *ch != '\0'; ch++)
    {
        insert_list(&ll, *ch);
    }
    print_list(ll);
}