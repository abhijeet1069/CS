# Java memory model

                     Operating System Process
┌────────────────────────────────────────────────────────────┐
│                                                            │
│                 JVM Process Memory                         │
│                                                            │
│  ┌─────────────────────────────────────────────────────┐   │
│  │                  Java Heap                          │   │
│  │                                                     │   │
│  │  Young Generation                                   │   │
│  │   ├── Eden                                          │   │
│  │   ├── Survivor S0                                   │   │
│  │   └── Survivor S1                                   │   │
│  │                                                     │   │
│  │  Old Generation                                     │   │
│  │                                                     │   │
│  │  Objects live here                                  │   │
│  └─────────────────────────────────────────────────────┘   │
│                                                            │
│  ┌─────────────────────────────────────────────────────┐   │
│  │                  Metaspace                          │   │
│  │                                                     │   │
│  │ Class metadata                                      │   │
│  │ Method bytecode                                     │   │
│  │ Constant pools                                      │   │
│  │ Field descriptions                                  │   │
│  │ Inheritance information                             │   │
│  └─────────────────────────────────────────────────────┘   │
│                                                            │
│  ┌─────────────────────────────────────────────────────┐   │
│  │                 Code Cache                          │   │
│  │                                                     │   │
│  │ JIT compiled machine code                           │   │
│  └─────────────────────────────────────────────────────┘   │
│                                                            │
│  ┌─────────────────────────────────────────────────────┐   │
│  │              Thread Stack (Thread 1)                │   │
│  │                                                     │   │
│  │ Frame 3                                             │   │
│  │ Frame 2                                             │   │
│  │ Frame 1                                             │   │
│  └─────────────────────────────────────────────────────┘   │
│                                                            │
│  ┌─────────────────────────────────────────────────────┐   │
│  │              Thread Stack (Thread 2)                │   │
│  └─────────────────────────────────────────────────────┘   │
│                                                            │
│  ┌─────────────────────────────────────────────────────┐   │
│  │             Native Memory                           │   │
│  │                                                     │   │
│  │ JVM internals                                       │   │
│  │ Metaspace allocation                                │   │
│  │ GC data structures                                  │   │
│  └─────────────────────────────────────────────────────┘   │
│                                                            │
└────────────────────────────────────────────────────────────┘

## Class

A class is a runtime description of a type that tells the JVM how objects of that type are laid out in memory
and what operations they support.

Millions of objects point to the same class definition.

Real memory picture

              Disk
        -----------------
        Person.class
        -----------------
               |
         Class Loader
               |
               V
        Metaspace (Native Memory)
        -------------------------
        Class metadata
        - field layout
        - method bytecode
        - constant pool
        - superclass
        - interfaces
        -------------------------
               ^
               |
        Class<Person> object
             (Heap)
               ^
               |
        Person instance
             (Heap)

* A C struct definition exists only at compile time; once the program is compiled, the running program doesn’t generally
    keep rich metadata about the struct.
* Java keeps detailed runtime type information (RTTI) in Metaspace, which is why features like reflection, dynamic 
    class loading, annotations, and frameworks such as Spring and Hibernate are possible.

So Java trades some memory and startup overhead for a much richer runtime environment.