# Dependency Inversion Principle

At compile time we want the dependencies inverted. The source code of the high level policies should not mention the 
source code of the lower level policies.

```java
/***************** without dependency inversion ************/
class Engine {
    public void start() {
        System.out.println("Engine started.");
    }
}

class Car {
    private Engine engine;

    public Car() {
        engine = new Engine();  // tightly coupled
    }

    public void startCar() {
        engine.start();
    }
}

public class Main {
    public static void main(String[] args) {
        Car car = new Car();
        car.startCar();
    }
}

/***************** with dependency inversion ************/
interface Engine { //interface implmentors are reversed
    void start();
}

class PetrolEngine implements Engine {
    public void start() {
        System.out.println("Petrol engine started.");
    }
}

class Car {
    private Engine engine;

    // Dependency injected via constructor
    public Car(Engine engine) {
        this.engine = engine;
    }

    public void startCar() {
        engine.start();
    }
}

public class Main {
    public static void main(String[] args) {
        Engine engine = new PetrolEngine();  // You can easily switch implementation
        Car car = new Car(engine);          // Inject dependency
        car.startCar();
    }
}
```

## Note

SOLID principles are class design principles.