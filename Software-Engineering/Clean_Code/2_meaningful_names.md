# Clean Code by Robert Cecil Martin

Learning to write clean code is hard work. It requires more than just the knowledge 
of principles and patterns. You must sweat  over it. You must practice it yourself, 
and watch yourself fail. You must watch others practice it and fail. You must see them 
stumble and retrace their steps. You must see them agonize over decisions and see the 
price they pay for making those decisions the wrong way. 
	Be prepared to work hard while reading this book.
	
For coding, ratio of time spent reading vs. writing is well over 10:1.

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

## Use pronouneable names

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