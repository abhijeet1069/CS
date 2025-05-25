# Static

## JVM memory overview

- Heap : Instance objects (created with new)
- Stack : Local variables, method calls (each thread has its own stack)
- Method Area (Metaspace) : Class definitions, static variables/methods, constant pool, static nested classes
- Program Counter : Keeps track of current instruction being executed per thread
- Native Method Stack : Used for native (non-Java) method calls (e.g., C/C++ libraries)


## Static variables

🔸 Static Variable Lifecycle
•	Loaded into memory once, when the class is loaded.
•	Shared among all instances of the class.
•	Exists until the class is unloaded (typically only happens when the classloader is garbage collected).

## Static methods

We can't refer non-static variables from static methods.
    There is a logic to it, suppose I want to print an instance variable, now which instance variable to print?

main() is static
    This has to be static, as this is where program starts or the first method of the program, if I make it non-static
then I need to create an instance of class in which main() is, so how come main() will be first method?stat


