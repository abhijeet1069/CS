# Clean Architecture

> The only way to go fast is to go well.

## Goal of clean architecture

The primary purpose of architecture is to support the lifecycle of the system. 
Good architecture makes the system easy to understand, easy to develop, easy to maintain, and easy to deploy. 
The ultimate goal is to minimize the lifetime cost of the system and to maximize programmer productivity.

A good architect maximizes the number of decisions not made.

Every software system provides two different values to the stakeholders: **behavior and structure.**
    Software developers are responsible for ensuring that both those values remain high. Unfortunately, they often 
    focus on one to the exclusion of the other.

If architecture comes last, then the system will become ever more costly to develop, and eventually change will become 
practically impossible for part or all of the system.

The dilemma for software developers is that business managers are not equipped to evaluate the importance of 
architecture. 
    That's what software developers were hired to do. Therefore it is the responsibility of the software development 
team to assert the importance of architecture over the urgency of features.

## Paradigms of programming

- Structured programming
- Object oriented programming
- Functional programming

### Structured programming

Structured programming imposes discipline on direct transfer of control.

In early programming (assembly, BASIC, FORTRAN) goto statements were common. These allowed the programs to jump 
arbitrarily to another line or label, creating sphagetti code.

Structured programming introduced control structures that replaced arbitrary jumps:

1. Sequence - Execute statements in order
2. Selection - Use if-then or switch for branching
3. Iteration - Use while,for or repeat-until loops for repetition"

### Object oriented programming

Object oriented programming imposes discipline on indirect transfer of control.

In OOP, control flow becomes indirect because:

- You call a method on an object.
- The actual method that runs might depend on the object's runtime type.

This is polymorphism — the method pointer is resolved dynamically.

```java
// So, instead of doSomething();
// we do,
Shape s = new Circle(); 
s.draw(); // which draw() gets called depends on s's runtime type"
```

### Functional programming

Functional programming imposes discipline upon assignment.

You can assign a value — but only once. After that, you must transform, not mutate.

Notice each paradigm takes something away from us. The three paradigms together remove goto statements,
function pointers, and assignment.

## The Combined Philosophy

- Structured programming → gives you the algorithmic discipline inside a module.

- Functional programming → gives you the data discipline across modules.

- Polymorphism → gives you the boundary discipline between modules.

Together, they form a layered architecture where:

**Algorithms are clean and testable.**

**Data is immutable and explicit.**

***Boundaries are crossed via contracts, not leaks.***