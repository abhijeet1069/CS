# Clean Code by Robert Cecil Martin

Clean code is not written by following a set of rules. You don’t become a software craftsman by learning
a list of heuristics. Professionalism and craftsmanship come from values that drive
disciplines.

## Choose Descrptive names

Don’t be too quick to choose a name. Make sure the name is descriptive. Remember that
meanings tend to drift as software evolves, so frequently reevaluate the appropriateness of
the names you choose.
    This is not just a “feel-good” recommendation. Names in software are 90 percent of
what make software readable. You need to take the time to choose them wisely and keep
them relevant. Names are too important to treat carelessly.

## Choose Names at the Appropriate Level of Abstraction

Don’t pick names that communicate implementation; choose names the reflect the level of
abstraction of the class or function you are working in.

```java
public interface Modem{
    boolean dial(String phoneNumber); // Bad: what if modem is not a dial up modem
}

public interface Modem{
    boolean connect(String connectionLocator); // Better
}

```

## Use Standard nomenclature where possible

In Java, for example, functions that convert
objects to string representations are often named toString(). It is better to follow conventions
like these than to invent your own.

## Use long names for long scopes

The length of a name should be related to the length of the scope. You can use very short
variable names for tiny scopes, but for big scopes you should use longer and precise names.

## Use intention revealing names

Names should revel intent. It should tell you why it exists, what it does, and how it is used.
For ex : 

```java

// not a good name
int d; //elapsed time in days

//good names
int elapsedTimeInDays
int daysSinceCreation;
int daysSinceModification;
int fileAgeInDays;
List<Integer> accounts;
```

## Avoid disinformation

Consider, for example, the truly hideous practice of creating a variable named klass just because the 
name class was used for something else.

Even if the container is a List, it’s probably better not to encode the container type into the name.

## Make meaningful distinction

In the absence of specific conventions, the variable moneyAmount is indistinguishable from money, 
customerInfo is indistinguishable from customer, accountData is indistinguishable from account, 
and theMessage is indistinguishable from message. Distinguish names in such a way that the reader 
knows what the differences offer.

## Names should descrbe side effects

Names should describe everything that a function, variable, or class is or does. Don’t hide
side effects with a name. Don’t use a simple verb to describe a function that does more
than just that simple action.

```java

public ObjectOutputStream getOos() throws IOException {
    if (m_oos == null) {
        m_oos = new ObjectOutputStream(m_socket.getOutputStream());
    }
    return m_oos;
}

// This function does a bit more than get an “oos”; it creates the “oos” if it hasn’t been created
// already. Thus, a better name might be createOrReturnOos().
```


## Use pronounceable names

```java

//bad
class DtaRcrd102 {
private Date genymdhms;
private Date modymdhms;
private final String pszqint = "102";
/* ... */
};

//good
class Customer {
private Date generationTimestamp;
private Date modificationTimestamp;;
private final String recordId = "102";
/* ... */
};

```

## Avoid prefix or suffix

People quickly learn to ignore the prefix (or suffix) to see the meaningful part of the name. 
The more we read the code, the less we see the prefixes. Eventually the prefixes become unseen 
clutter and a marker of older code.

```java
String strName;         // 'str' is unnecessary — 'name' already tells you it’s a string.
int iCount;             // 'i' is unnecessary — 'count' already implies a number.
UserDTO userDto;        // If the context is clear, `user` is fine; `DTO` suffix is only useful in layers 
						// where distinction is needed.

```

## Avoid Encodings

Names should not be encoded with type or scope information. Prefixes such as m_ or f
are useless in today’s environments. Also project and/or subsystem encodings such as
vis_ (for visual imaging system) are distracting and redundant.

## Class names

Classes and objects should have noun or noun phrase names like Customer, WikiPage, Account, and AddressParser.

## Method Names

Methods should have verb or verb phrase names like postPayment, deletePage, or save. Accessors, mutators, and predicates 
should be named for their value and prefixed with get, set, and is according to the javabean standard.

```java
String name = employee.getName();
customer.setName("mike");
if (paycheck.isPosted())...
```

## Overloading Contructors

When constructors are overloaded, use static factory methods with names that describe the arguments.

```java
//bad
public class User {
    private String name;
    private int age;

    public User(String name) {
        this.name = name;
        this.age = 0; // default
    }

    public User(int age) {
        this.name = "Unknown";
        this.age = age;
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }
}

//client code
User u1 = new User("Alice");     // okay
User u2 = new User(25);          // confusing — what is 25? name or age?
User u3 = new User("Bob", 30);   // fine


//better with static factory Methods

public class User {
    private String name;
    private int age;

    private User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public static User withName(String name) {
        return new User(name, 0);
    }

    public static User withAge(int age) {
        return new User("Unknown", age);
    }

    public static User withNameAndAge(String name, int age) {
        return new User(name, age);
    }
}

//client code : This one is more expressive and good

User u1 = User.withName("Alice");
User u2 = User.withAge(25);
User u3 = User.withNameAndAge("Bob", 30);

```

## Don't be cute

Will they know what the function named HolyHandGrenade() is supposed to do? Sure, it’s cute, but maybe in this case
DeleteItems() might be a better name. 
	Say what you mean. Mean what you say. 

## Pick 1 word per concept
	
A consistent lexicon is a great boon to the programmers who must use your code.