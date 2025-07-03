# Objects and Data-Structures

There is a reason that we keep our variables private. We don’t want anyone else to depend
on them. We want to keep the freedom to change their type or implementation on a whim
or an impulse. Why, then, do so many programmers automatically add getters and setters
to their objects, exposing their private variables as if they were public?


## Law of Demeter (LoD)

The Law of Demeter, also called the principle of least knowledge, is a design guideline for building 
more maintainable and loosely coupled object-oriented code. This also helps to prevent transitive navigation.

```java

//Bad
class Address {
    private String city;
    public Address(String city) { this.city = city; }
    public String getCity() { return city; }
}

class Customer {
    private Address address;
    public Customer(Address address) { this.address = address; }
    public Address getAddress() { return address; }
}

class Order {
    private Customer customer;
    public Order(Customer customer) { this.customer = customer; }
    public Customer getCustomer() { return customer; }
}

public class Main {
    public static void main(String[] args) {
        Order order = new Order(new Customer(new Address("Delhi")));

        // ❌ Law of Demeter violated: multiple chained calls
        String city = order.getCustomer().getAddress().getCity();

        System.out.println("Customer's city: " + city);
    }
}
```

```java
//better : client doesen't need to know my internals of classes, only the operation which it requires
class Address {
    private String city;
    public Address(String city) { this.city = city; }
    public String getCity() { return city; }
}

class Customer {
    private Address address;
    public Customer(Address address) { this.address = address; }
    public Address getAddress() { return address; }
}

class Order {
    private Customer customer;
    public Order(Customer customer) { this.customer = customer; }

    // ✅ Law of Demeter followed: expose only what’s needed
    public String getCustomerCity() {
        return customer.getAddress().getCity();
    }
}

public class Main {
    public static void main(String[] args) {
        Order order = new Order(new Customer(new Address("Delhi")));

        // ✅ Clean interaction
        String city = order.getCustomerCity();

        System.out.println("Customer's city: " + city);
    }
}


```
- A method can call:
	Its own methods
	
	```java
	public void process() {
    validate(); 	//internal helper methods or behaviors for process()
    save();
	}

	private void validate() { ... }
	private void save() { ... }

	```
- Methods of objects passed as arguments
	
	```java
	public void process(Data data) {
		data.clean();
	}
	```
	
- Methods of objects it created
	
	```java
	public void process() {
    Logger logger = new Logger();
    logger.log("Processing started");
	}

	```
	
- Methods of its own fields (direct dependencies)
	
	```java
	private final Repository repository;

	public Service(Repository repository) {
		this.repository = repository;
	}

	public void save(Data data) {
		repository.save(data);
	}
	
	```
	


## Don't put business logic into your data Structures

- Treat the Active Record, POJO as just a data holder.
- Put business rules in domain services or value objects.

```java
//don't put business logic in this POJO
class WeatherResponse {
    public String city;
    public double temperature;
    public String condition;
}

//Here logic is separated from POJO
class WeatherService {
    public boolean shouldTakeUmbrella(WeatherResponse response) {
        return response.condition.toLowerCase().contains("rain");
    }
}

```

## Conclusion

Objects expose behavior and hide data. This makes it easy to add new kinds of objects
without changing existing behaviors.

## Case

- Camel Case : firstName
- Snake Case : first_name
- Kebab Case : first-name
- Pascal Case : FirstName

