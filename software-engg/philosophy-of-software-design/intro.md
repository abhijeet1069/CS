# Philosophy of software design

## Modules should be deep

One of the important techniques for managing software complexity is to design systems so
that developers only need to face a small fraction of the overall complexity at any given time.
This approach is called modular design.

The goal of modular design is to minimize dependencies between modules. A module has two parts,
an interface and an implementation.

The interface consists of everything that a developer working in a different module must know in order 
to use the given module. 
    Typically, the interface describes what the module does but not how it does it. 
The implementation consists of the code that carries out the promises made by the interface.

By separating the interface of a module from its implementation, we can hide the
complexity of the implementation from the rest of the system.

### Shallow Module

A shallow module is one whose interfaces is complicated relative to the functionality it provides. Shallow modules 
don’t help much in the battle against complexity, because the benefit they provide (not having to learn about how 
they work internally) is negated by the cost of learning and using theirinterfaces. 
Small modules tend to be shallow.

```java
// for ex : this is a shallow module, the interface doesen't hide any complexity, 
// infact it increases cognitive load to developer
private void addNullValueForAttribute(String attribute) {
    data.put(attribute, null);
}
```

> Optimize for reducing the amount a reader has to think about.

A deep module lets the reader ignore a lot of details.

A shallow module often forces the reader to jump between files and methods without reducing the amount 
they have to understand.

### Temporal Decomposition

In temporal decomposition execution order is reflected in the code structure: operations that happen at different times
are in different methods or classes. If the same knowledge is used at different points in execution, it gets encoded
in multiple places, resulting in information leakage.

### Overexposure

If the API for a commonly used feature forces users to learn about other features that are rarely used, this increases
the cognitive load on users who don't need the rarely used features.

## Different layer, Different Abstraction

Software systems are composed in layers, where higher layers use the facilities provided by lower layers. 
> In a well-designed system, each layer provides a different abstraction from the layers above and below it.
    If a system contains adjacent layers with similar abstractions, this is a red flag that suggests a 
    problem with the class decomposition.  

Each piece of design infrastructure added to a system, such as an interface,
argument, function, class, or definition, adds complexity, since developers must
learn about this element. In order for an element to provide a net gain against
complexity, it must eliminate some complexity that would be present in the
absence of the design element. Otherwise, you are better off implementing the
system without that particular element.

### Pass through methods

A pass-through method is one that does nothing except pass its arguments to another method, usually with the same 
API as the pass-through method. 
    This typically indicates that there is not a clean division of responsibility between the classes.

```java
/**
 * In below example Calculator did nothing, Adder did nothing. Their methods are just pass through methods.
 * Only increased the cognitive load, without adding any value.
 * 
*/

class Calculator {
    
    private Adder adder = new Adder();

    public int add(int a, int b) {
        return adder.add(a, b); 
    }
}

class Adder {

    private MathEngine engine = new MathEngine();

    public int add(int a, int b) {
        return engine.add(a, b);
    }
}

class MathEngine {

    public int add(int a, int b) {
        return a + b;
    }
}
```

### Pass through variable

A pass-through variable is similar in spirit to a pass-through method.

It is a variable that exists only to be passed somewhere else, without adding any new meaning or computation.

```java
class Student {

    private String name;

    public Student(String name) {
        this.name = name;
    }

    public void print() {
        Printer printer = new Printer();

        String studentName = name;   // Pass-through variable, doesen't accomplish anything

        printer.print(studentName);
    }
}

class Printer {

    public void print(String text) {
        System.out.println(text);
    }
}
```

### Red flag : Repetition

If the same piece of code (or code that is almost the same) appears over and over again, that's a red flag that
you haven't found the right abstractions.

Each method should do one thing and do it completely.

## Define errors out of existence

Every error exposed by an API increases complexity.
Every error pushed to the caller increases the complexity of every caller.

But don't hide real error. For ex, if the file is missing report that error

Before adding an exception to your API, ask whether the caller should ever have had to worry 
about this situation in the first place.

```java
// for ex : instead of returning null and adding null check in client
// we can give a default value, and save client from unnecessary complexity
map.getOrDefault(key, defaultValue);

```