# Error Handling

Error Handling is important, but if it obscures the logic, it's wrong.

In a way, try blocks are like transactions. Your catch has to leave your program in a
consistent state, no matter what happens in the try.

## Use Exceptions Rather Than Return Codes

Best practice is to use custom exceptions like below as it enables DDD (Domain Driven Design)

DDD is about building software that closely models real-world business logic and uses a common 
language shared between developers and domain experts.

```java

class InsufficientBalanceException extends RuntimeException {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public void withdraw(int amount) {
    if (amount > balance) {
        throw new InsufficientBalanceException("Balance too low");
    }
    balance -= amount;
}

//client code
try {
    account.withdraw(100);
} catch (InsufficientBalanceException e) {
    // Handle insufficient funds
} catch (AccountClosedException e) {
    // Handle closed account
}

```

## Use unchecked Exceptions

Checked Exceptions - These are checked at compile time like IOException, SQLException, FileNotFoundException etc
UnChecked Exceptions - These are not checked at compile time like NulPointerException, IllegalArgumentException etc

But checked exceptions are still useful when:
	- You want to force the caller to handle a specific, recoverable failure
	- You're writing low-level code like I/O, file operations, or JDBC

## Provide context with Exceptions

Create informative error messages and pass them along with your exceptions. In Java, you can get a stack trace from 
any exception; however, a stack trace can’t tell you the intent of the operation that failed.

## Don't return null

We should not return null as it:

- Leads to NullPointerExceptions: Clients calling your method have to remember to check for null—if they forget,
 it crashes.
- Breaks Composability: Functions or pipelines break when null appears in the middle.
- Obscures Meaning: Returning null doesn't explain why there’s no value—was it an error, not found, empty?

Instead we should:

- Use Optional

```java
Optional<User> findUser(String id) {
    return Optional.ofNullable(userMap.get(id));
}
```

- Return empty collections instead of null

```java
List<String> getItems() {
    return Collections.emptyList(); // not null
}
```

- Throw exceptions

```java
if (user == null) {
    throw new UserNotFoundException("User not found with id: " + id);
}
```

- Use the null object pattern

```java
class NullUser extends User {
    // override methods to do nothing or return defaults
}
```

- Defensive String comparision

```java
if ("expectedValue".equals(input)) {
    // safe even if input is null
}
```

## Don't pass null

Returning null from methods is bad, but passing null into methods is worse. Unless you
are working with an API which expects you to pass null, you should avoid passing null in
your code whenever possible.

## Conclusion

Clean code is readable, but it must also be robust. These are not conflicting goals. We can
write robust clean code if we see error handling as a separate concern, something that is
viewable independently of our main logic.