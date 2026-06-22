# Template Pattern

The Template Method Pattern defines the skeleton of an algorithm in a base class, but lets subclasses override certain 
steps without changing the overall structure.
    Its like extracting common factors in base class, and implementing non common factors in child class.

```java

// Abstract class (template)
abstract class Beverage {
    // behavior seqeunce for class
    public final void makeBeverage() {
        boilWater();
        brew();
        pourInCup();
        addCondiments();
    }

    //common behaviors
    private void boilWater() {
        System.out.println("Boiling water");
    }

    //common behaviors
    private void pourInCup() {
        System.out.println("Pouring into cup");
    }

    // Unique steps that sub classes need to implement
    protected abstract void brew();
    protected abstract void addCondiments();
}

// Concrete Subclass
class Tea extends Beverage {
    protected void brew() {
        System.out.println("Steeping the tea");
    }

    protected void addCondiments() {
        System.out.println("Adding lemon");
    }
}

// Concrete Subclass
class Coffee extends Beverage {
    protected void brew() {
        System.out.println("Dripping coffee through filter");
    }

    protected void addCondiments() {
        System.out.println("Adding sugar and milk");
    }
}

//Usage
public class Main {
    public static void main(String[] args) {
        Beverage tea = new Tea();
        tea.makeBeverage();

        System.out.println();

        Beverage coffee = new Coffee();
        coffee.makeBeverage();
    }
}
```