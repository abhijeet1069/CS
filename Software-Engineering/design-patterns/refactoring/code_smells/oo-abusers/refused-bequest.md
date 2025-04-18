# Object Orientation Abusers

## Befused Request

Befused request happens when a subclass inherits methods or fields from a superclass but doesn’t use them — or worse, overrides them just to throw exceptions or ignore their behavior.
This usually signals bad inheritance — the subclass doesn't really fit the "is-a" relationship with the superclass.

```java

//bad: violates Liskov substitution principle
class Bird {
    public void fly() {
        System.out.println("Flying");
    }

    public void layEggs() {
        System.out.println("Laying eggs");
    }
}

class Ostrich extends Bird {
    @Override
    public void fly() {
        // Ostriches can't fly
        throw new UnsupportedOperationException("Ostriches can't fly");
    }
}
```

## Solution

### Split the Hierarchy

```java
abstract class Bird {
    public abstract void layEggs();
}

abstract class FlyingBird extends Bird {
    public abstract void fly();
}

class Sparrow extends FlyingBird {
    @Override
    public void fly() {
        System.out.println("Flying");
    }

    @Override
    public void layEggs() {
        System.out.println("Laying eggs");
    }
}

class Ostrich extends Bird {
    @Override
    public void layEggs() {
        System.out.println("Laying eggs");
    }
}

```

### Replace inheritance with delegation

```java
class Bird {
    public void layEggs() {
        System.out.println("Laying eggs");
    }
}

class FlightBehavior {
    public void fly() {
        System.out.println("Flying");
    }
}

class Sparrow {
    private Bird bird = new Bird();
    private FlightBehavior flight = new FlightBehavior();

    public void fly() {
        flight.fly();
    }

    public void layEggs() {
        bird.layEggs();
    }
}

```
