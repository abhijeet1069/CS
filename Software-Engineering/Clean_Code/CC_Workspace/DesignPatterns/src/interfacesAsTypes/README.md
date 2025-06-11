# Interfaces as Types

Interfaces can be used as types.

## Instance Variables

Using interfaces for fields allows swapping implementations easily.

```java

interface Repository {
	//some methods
}

public class Service {
    private final Repository repo;

    public Service(Repository repo) { // An implementation of Repository interface can be passed.
        this.repo = repo;			  // Also known as constructor injection
    }
}

```

## Method Parameters

Interfaces as parameter types make methods more flexible and reusable.

```java

public void process(Storage storage) {
    storage.save("important data");
}

```

## Return types

Returning an interface allows the caller to use the behavior without knowing the actual class.

```java
public List<String> getNames() {
    return new ArrayList<>();
}

```

## Local Variables

Using interfaces in local variables makes temporary code flexible too.

```java
Storage tempStorage = new FileStorage();
tempStorage.save("temp data");

```