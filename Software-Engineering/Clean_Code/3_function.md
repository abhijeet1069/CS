# Function

## Small

As per Linux style guideline, avoid >3 levels of nesting.

```java
// for example below function is 3 level nested.

public void processData(List<Integer> data) {
    for (Integer number : data) {
        if (number % 2 == 0) { 
            System.out.println("Even: " + number);
        } //3 deep 
        else { 
            System.out.println("Odd: " + number);
        } // 3 deep
    } //2 deep
} //1 deep

```

## Do one thing

A function should do one thing and do it well.

## Use descriptive names

A long descriptive name is better than a long descriptive comment.

## Function Arguments

The ideal number of arguments for a function is zero (niladic). Next comes one (monadic), followed
closely by two (dyadic). Three arguments (triadic) should be avoided where possible. More than three
(polyadic) requires very special justification—and then shouldn’t be used anyway. (Better wrap those arguments
in a class of their own).

## Have no side effects

Side effects are lies. Your function promises to do one thing, but it also does other hidden things. It also violates the 
Single responsibility principle.

```java
public class UserValidator {
    private Cryptographer cryptographer;
    public boolean checkPassword(String userName, String password) {
        User user = UserGateway.findByName(userName);
        if (user != User.NULL) {
            String codedPhrase = user.getPhraseEncodedByPassword();
            String phrase = cryptographer.decrypt(codedPhrase, password);

        if ("Valid Password".equals(phrase)) {
            Session.initialize(); //side-effect
            return true;
    }
}
return false;
}
}

```

## Command query separation (CQS)

CQS states that a method should either be a command that performs an action or a query that returns data, but not both.
A good case of single responsibility principle

```java

//bad : violates CQS
public class BankAccount {
    private int balance = 100;

    public int withdraw(int amount) {
        this.balance -= amount; // Command: changes state
        return this.balance;    // Query: returns new state
    }
}

//good: follows CQS

public class BankAccount {
    private int balance = 100;

    public void withdraw(int amount) { // Command
        this.balance -= amount;
    }

    public int getBalance() { // Query
        return this.balance;
    }
}

```

## Prefer exceptions to returning error code

## Extract try catch blocks

Error handing is one thing. Thus, a function that handles errors should do nothing else.

```java
public void delete(Page page) {
    try {
        deletePageAndAllReferences(page);
    }
    catch (Exception e) {
        logError(e);
    }
}

private void deletePageAndAllReferences(Page page) throws Exception {
    deletePage(page);
    registry.deleteReference(page.name);
    configKeys.deleteKey(page.name.makeKey());
}

private void logError(Exception e) {
    logger.log(e.getMessage());
}

````

## Don't Repeat Yourself (DRY)

## Structured Programming

Dijkstra said that every function, and every block within a function, should have one entry and one exit. 
Following these rules means that there should only be one return statement in a function, no break or continue 
statements in a loop, and never, ever, any goto statements.

While we are sympathetic to the goals and disciplines of structured programming,
those rules serve little benefit when functions are very small. It is only in larger functions
that such rules provide significant benefit.

## Conclusion

- Write the code.
- Test the code.
- Refactor the code.

Every system is built from a domain-specific language designed by the programmers to describe that system. 
Functions are the verbs of that language, and classes are the nouns.
The art of programming is, and has always been, the art of language design.
	Master programmers think of systems as stories to be told rather than programs to be written. They use the facilities of their 
chosen programming language to construct a much richer and more expressive language that can be used to tell that story.