# Boundaries

## Learning test are better than free

Not only are learning tests free, they have a positive return on investment. When there
are new releases of the third-party package, we run the learning tests to see whether there
are behavioral differences.

```java

// Suppose I want to learn Java Jackson library. I can write below test to check.
// This is a very good tip, even learning effort will not be wasted.
@Test
void testBasicSerialization() throws JsonProcessingException {
    ObjectMapper mapper = new ObjectMapper();
    User user = new User("Alice", 30);
    String json = mapper.writeValueAsString(user);
    assertEquals("{\"name\":\"Alice\",\"age\":30}", json);
}
```
### Lifecycle of change

TDD has an ama
Here’s the ideal lifecycle of change when dealing with third-party code or unknown behavior:	
- Learning Test	 : Understand the lib
- Production Test :	Define your need
- Production Code :	Fulfill that need

## Use code that does not yet exist

The ADAPTER encapsulated the interaction with the API and provides a single place to change when the API evolves.

Use an abstraction when...
- You might switch libraries
	e.g., Jackson ↔ Gson, or SQL database ↔ NoSQL

- The external API is unstable or complicated
	Wrapping protects your app from breaking changes

- You want to write learning tests
	Learning tests isolate and validate your expectations

- You're building reusable or core business logic
	Decoupling makes testing and reuse easier

- You want to limit the "blast radius"
	Wrapping keeps third-party failures contained

Skip the wrapper when...
- The library is extremely stable and simple
	e.g., java.util.List, SLF4J logging, commons-lang StringUtils
	
- You're using it in one tiny place only
	Extra layers might just add noise
	
- It’s just glue code or infrastructure
	Sometimes it’s okay to be pragmatic in throwaway scripts or one-off tools