# Program Organization

More than one storage class may not be specified. 

```C
extern static int i = 0; //error
```

## Local variables

By default local variable have following property:

- Automatic storage duration : Storage for a local variable is automatically allocated when the enclosing function
    is called and deallocated when the function returns.

- Block scope : Local variable is visible from its point of declaration to the end of the enclosing function body.

```C
void f(void){
    ...
    int i; //scope of i
    ...    //scope of i
}
```

## Static Local variables

A variable with static storage duration has a permanent storage location

- Retains its value between function calls.
- Is initialized only once, the first time the function is executed.
- Is visible only inside the function, just like any other local variable.

## External Variables

- Static storage duration
- File scope

```C
//Counter is visible in single file
#include <stdio.h>

int counter = 0; // external variable

void increment() {
    counter++;
}

int main() {
    increment();
    printf("Counter: %d\n", counter);  // Output: Counter: 1
    return 0;
}

```