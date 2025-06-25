# Smells and Heristics

## Environment

### Build requires more than 1 step

Building a project should be a single trivial operation. You should not have to check many
little pieces out from source code control. For ex:

```java

svn get mySystem
cd mySystem
ant all

```

### Tests require more than one step

You should be able to run all the unit tests with just one command. In the best case you
can run all the tests by clicking on one button in your IDE. In the worst case you should
be able to issue a single simple command in a shell. Being able to run all the tests is so
fundamental and so important that it should be quick, easy, and obvious to do.

## General

### Multiple Languages in 1 source file

The ideal is for a source file to contain one, and only one, language. Realistically, we
will probably have to use more than one. But we should take pains to minimize both the
number and extent of extra languages in our source files.

### Obvious behavior is unimplemented

Following “The Principle of Least Surprise” ("A system should behave in a way that least surprises the user.") 
any function or class should implement the behaviors that another programmer could reasonably expect.
	When an obvious behavior is not implemented, readers and users of the code can no
longer depend on their intuition about function names. They lose their trust in the original
author and must fall back on reading the details of the code.

### Incorrect behavior at the boundaries

There is no replacement for due diligence. Every boundary condition, every corner
case, every quirk and exception represents something that can confound an elegant and
intuitive algorithm. Don’t rely on your intuition. Look for every boundary condition and
write a test for it.

### Overridden Safeties

It is risky to override safeties. Exerting manual control over serialVersionUID may be
necessary, but it is always risky. Turning off certain compiler warnings (or all warnings!)
may help you get the build to succeed, but at the risk of endless debugging sessions. Turning
off failing tests and telling yourself you’ll get them to pass later is as bad as pretending
your credit cards are free money.

### Duplication

Every time you see duplication in the code, it represents a missed opportunity for
abstraction.

The most obvious form of duplication is when you have clumps of identical code that
look like some programmers went wild with the mouse, pasting the same code over and
over again. These should be replaced with simple methods.

A more subtle form is the switch/case or if/else chain that appears again and again in
various modules, always testing for the same set of conditions. These should be replaced
with polymorphism.

```java
//bad
if (shape.getType() == CIRCLE) {
    drawCircle(shape);
} else if (shape.getType() == RECTANGLE) {
    drawRectangle(shape);
} else if (shape.getType() == TRIANGLE) {
    drawTriangle(shape);
}

//good

abstract class Shape {
    abstract void draw();
}

class Circle extends Shape {
    void draw() { System.out.println("Drawing Circle"); }
}

class Rectangle extends Shape {
    void draw() { System.out.println("Drawing Rectangle"); }
}

// Use:
Shape shape = new Circle();
shape.draw();  // No if/switch needed


```

Still more subtle are the modules that have similar algorithms, but that don’t share
similar lines of code. This is still duplication and should be addressed by using the TEMPLATE
METHOD or STRATEGY pattern.

Indeed, most of the design patterns that have appeared in the last fifteen years are simply
well-known ways to eliminate duplication. So too the Codd Normal Forms are a strategy
for eliminating duplication in database schemae. OO itself is a strategy for organizing
modules and eliminating duplication. Not surprisingly, so is structured programming.

### Coding at wrong level of abstraction

Don't mix the higher level concepts with lower level details.
These leads to lower coupling.

### Inconsistency

If you do something a certain way, do all similar things in the same way. 
This goes back to the principle of least surprise. Be careful with the conventions you choose, and once
chosen, be careful to continue to follow them.
Simple consistency like this, when reliably applied, can make code much easier to
read and modify.

### Clutter

Of what use is a default constructor with no implementation? All it serves to do is clutter
up the code with meaningless artifacts. Variables that aren’t used, functions that are never
called, comments that add no information, and so forth. All these things are clutter and
should be removed. Keep your source files clean, well organized, and free of clutter.

### Artificial coupling

Keep general-purpose code separate from domain-specific logic.

```java
public class OrderService {
    public static String formatDate(Date date) { ... }  // unrelated to orders, creates an artificial coupling
}

public class DateUtils {
    public static String formatDate(Date date) { ... }
}

```

### Feature Envy

Feature Envy is when a method is too focused on another object’s data.
Fix it by relocating the method to the class that owns the data. 
Feature Envy increases coupling.

```java
//code with feature envy
class Invoice {
    private Customer customer;

    public double getCustomerDiscount() {
        return customer.getLoyaltyPoints() * 0.05 + customer.getMembershipLevel().getDiscount();
    }
}

//bettter
class Customer {
    public double calculateDiscount() {
        return getLoyaltyPoints() * 0.05 + getMembershipLevel().getDiscount();
    }
}

class Invoice {
    private Customer customer;

    public double getCustomerDiscount() {
        return customer.calculateDiscount();  // Delegated properly
    }
}



```

