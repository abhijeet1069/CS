# Classes

## Class Organization

Following the standard Java convention, a class should begin with a list of variables. Public
static constants, if any, should come first. Then private static variables, followed by private
instance variables. There is seldom a good reason to have a public variable.
	Public functions should follow the list of variables. We like to put the private utilities
called by a public function right after the public function itself. This follows the stepdown
rule and helps the program read like a newspaper article.

## Single Responsibility Principle

We want our systems to be composed of many small classes, not a few large ones. Each small class encapsulates a single responsibility,
has a single reason to change, and collaborates with a few others to achieve the desired system behaviors.

Many developers fear that a large number of small, single-purpose
classes makes it more difficult to understand the bigger picture. They are concerned that
they must navigate from class to class in order to figure out how a larger piece of work gets
accomplished.
	However, a system with many small classes has no more moving parts than a system
with a few large classes. There is just as much to learn in the system with a few large
classes. 
	So the question is: Do you want your tools organized into toolboxes with many
small drawers each containing well-defined and well-labeled components? Or do you want
a few drawers that you just toss everything into?

```java

//Bad : This class does too much:
	Business logic, Presentation, Persistence It has multiple reasons to change.
	
public class Invoice {
    private String customer;
    private double amount;

    public double calculateTotal() { return amount * 1.18; }

    public void printInvoice() { System.out.println("Printing invoice..."); }

    public void saveToFile() { /* save logic */ }
}

//Better
public class Invoice {
    private String customer;
    private double amount;

    public Invoice(String customer, double amount) {
        this.customer = customer;
        this.amount = amount;
    }

    public double calculateTotal() {
        return amount * 1.18; // add 18% tax
    }
}

public class InvoicePrinter {
    public void print(Invoice invoice) {
        System.out.println("Invoice for " + invoice.getCustomer() + ": ₹" + invoice.calculateTotal());
    }
}


public class InvoiceSaver {
    public void saveToFile(Invoice invoice) {
        // save invoice to file logic here
    }
}

```

## Cohesion

Classes should have a small number of instance variables. 

## When classes lose cohesion, split them!

Cohesion refers to how tightly related and focused the responsibilities and behaviors (methods) of a class are.

A class is more cohesive when

- It does one clear job or represents one concept.
E.g., Invoice, User, Circle, Authenticator.

- Most methods use most instance variables.
The methods are working together on shared data.

- All methods support the same purpose.
E.g., a Circle class only has geometry-related functions.

- It is easy to describe the class in one sentence.
This class handles everything related to processing an order.

A Class is Less Cohesive When:
- It handles unrelated concerns.
Mixing business logic, I/O, data access, etc.

- Methods operate on disjoint sets of data.
Method A uses variable X, Method B uses unrelated Y and Z.

- The class grows too big (“God class”).
Does too much; hard to test and maintain.

- You struggle to explain its purpose clearly.
"Well, it does a bit of everything..."

## Open closed principle

(Prefer Polymorphism to If/Else or Switch/Case)
Classes should be open for extension but closed for modification.
In an ideal system, we incorporate new features by extending the system, not by making modifications to existing code.

```java
// Violates OCP, since not scalable.
public class TollCalculator {
    public int calculateToll(String vehicleType) {
        switch (vehicleType) {
            case "car": return 60;
            case "truck": return 120;
            case "bus": return 100;
            case "bike": return 30;
            default: return 50;
        }
    }
}

//better design : follows OCP
public interface Vehicle {
    int calculateToll();
}

public class Car implements Vehicle {
    public int calculateToll() {
        return 60;
    }
}

public class Truck implements Vehicle {
    public int calculateToll() {
        return 120;
    }
}

public class Bus implements Vehicle {
    public int calculateToll() {
        return 100;
    }
}

public class Bike implements Vehicle {
    public int calculateToll() {
        return 30;
    }
}

public class TollService {
    public int getToll(Vehicle vehicle) {
        return vehicle.calculateToll();
    }
}

Vehicle myVehicle = new Truck();
TollService tollService = new TollService();
int toll = tollService.getToll(myVehicle); // returns 120

```

## Dependency Inversion Principle

Classes should depend upon abstractions, not on concrete details.