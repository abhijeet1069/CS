# Strategy pattern

The Strategy Pattern allows you to define a family of algorithms, put them in separate classes, and make them 
interchangeable at runtime.

```java
//without strategy pattern

class PaymentService {
    public void pay(String type) {
        if (type.equals("credit")) {
            System.out.println("Paid using Credit Card");
        } else if (type.equals("paypal")) {
            System.out.println("Paid using PayPal");
        }
    }
}

//with strategy pattern

interface PaymentStrategy {
    void pay();
}

class CreditCardPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paid using Credit Card");
    }
}

class PayPalPayment implements PaymentStrategy {
    public void pay() {
        System.out.println("Paid using PayPal");
    }
}

class PaymentService {
    private PaymentStrategy strategy;

    public PaymentService(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void makePayment() {
        strategy.pay();
    }
}

public class Main {
    public static void main(String[] args) {
        PaymentService service1 = new PaymentService(new CreditCardPayment());
        service1.makePayment(); // Paid using Credit Card

        PaymentService service2 = new PaymentService(new PayPalPayment());
        service2.makePayment(); // Paid using PayPal
    }
}


```