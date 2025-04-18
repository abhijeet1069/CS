# Bloaters

Bloaters are code, methods and classes that have increased to such gargantuam proportions that they are hard to work
with.

## Long Method

A Long Method is a method (function) that does too many things and becomes too big.
It looks like a wall of code — hard to read, hard to understand.

```java

//bad : process order is doing way too many things
void processOrder(Order order) {
    // Validate order
    if (order == null || order.items.isEmpty()) {
        throw new IllegalArgumentException("Invalid order");
    }

    // Calculate total price
    double total = 0;
    for (Item item : order.items) {
        total += item.price * item.quantity;
    }

    // Apply discount
    if (order.customer.isPremium()) {
        total *= 0.9;
    }

    // Save order to database
    Database.save(order);

    // Send confirmation email
    EmailService.sendConfirmation(order.customer.email);
}

//better : method broken to multiple methods
void processOrder(Order order) {
    validateOrder(order);
    double total = calculateTotal(order);
    total = applyDiscountIfEligible(order, total);
    saveOrder(order);
    sendConfirmation(order.customer.email);
}

private void validateOrder(Order order) { ... }

private double calculateTotal(Order order) { ... }

private double applyDiscountIfEligible(Order order, double total) { ... }

private void saveOrder(Order order) { ... }

private void sendConfirmation(String email) { ... }

```

## Large Class

A Large Class is a class that has too many responsibilities and becomes bloated.

```java
//bad : way too much stuff hapenning in one class
public class Employee {
    private String name;
    private double salary;
    
    // UI related
    public String generateHtml() { ... }

    // Business logic
    public void calculateAnnualBonus() { ... }

    // Database operations
    public void saveToDatabase() { ... }

    // Reporting
    public void printReport() { ... }

    // Payroll
    public void processPayroll() { ... }

    // Leave Management
    public void applyLeave() { ... }
}

//better : class separated to multiple classes
public class Employee {
    private String name;
    private double salary;
    
    public double calculateAnnualBonus() { ... }
}

public class EmployeeDatabaseService {
    public void save(Employee employee) { ... }
}

public class EmployeeReportService {
    public void print(Employee employee) { ... }
}

public class PayrollService {
    public void processPayroll(Employee employee) { ... }
}

```

## Primitive Obsession

-  Using String or int everywhere instead of meaningful types.
-  Passing too many primitive arguments to a method.
-  Encoding rules/validations everywhere instead of putting them in one place.

```java
// bad : client of this class will have to validate phone number, which is bad.
class User {
    String name;
    String phoneNumber; //primitive obsession
    String email;
}

//Better
class User {
    String name;
    PhoneNumber phoneNumber;
    String email;
}

class PhoneNumber {
    private final String value;
    public PhoneNumber(String value) {
        if (!value.matches("\\d{10}")) {
            throw new IllegalArgumentException("Invalid phone number");
        }
        this.value = value;
    }    
    public String getValue() {
        return value;
    }
}

```
## Long Parameter List

More than three parameters for a method.

```java

// bad : too long a method
void createUser(String name, String email, String address, String phone, String dob, String gender, String nationality) { 
    ...
}

//better : Using parameter object
class UserInfo {
    String name;
    String email;
    String address;
    String phone;
    String dob;
    String gender;
    String nationality;

    // Constructor, getters, setters
}

void createUser(UserInfo userInfo) {
    ...
}

//better : Using builder pattern
UserInfo userInfo = new UserInfo.Builder()
    .name("John Doe")
    .email("john@example.com")
    .address("123 Street")
    .phone("1234567890")
    .dob("01-01-1990")
    .gender("Male")
    .nationality("American")
    .build();
```

## Data Clumps

Data Clumps happen when two or more pieces of data always appear together — in method parameters, fields, or classes.

```java
//bad
public void createEmployee(String name, String address, String phoneNumber) { ... }
public void updateEmployee(String name, String address, String phoneNumber) { ... }
public void deleteEmployee(String name, String address, String phoneNumber) { ... }

//better : data has been grouped properly
public class ContactInfo {
    private String address;
    private String phoneNumber;
    
    // Constructor, getters, setters
}

public class Employee {
    private String name;
    private ContactInfo contactInfo;
    
    // Constructor, getters, setters
}

```

