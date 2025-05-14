# Boundaries

## Learning test are better than free

Not only are learning tests free, they have a positive return on investment. When there
are new releases of the third-party package, we run the learning tests to see whether there
are behavioral differences.

Below code is a good example of a learning test, doesen't assert anything. For logging I used the logback
framework, but tomorrow suppose some critical vulnerability comes up and I need to migrate to Log4J. This
test will help me in testing the API, before shipping to prod.

```java
 // a simple learning test for logging
@Test
    public void isLogGenerating(){
        LogUtil.logInfo("Tests executed");
    }
}

```

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