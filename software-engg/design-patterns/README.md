# Design Patterns

Learn more about Inversion of control

## Creational Patterns (Object creation mechanisms)

- Singleton : Ensures a class has only one instance (e.g., Spring beans by default).

- Factory Method : Creates objects without specifying the exact class.

- Abstract Factory : Produces families of related objects without specifying their concrete classes.

- Builder : Step-by-step object construction, useful for complex objects.

- Prototype : Cloning objects (less common in modern codebases).

## Structural Patterns (Class/object composition)
- Adapter : Transforms one interface to another (e.g., Legacy system integration).

- Bridge : Decouples abstraction from implementation.

- Composite : Tree structures of objects (e.g., UI components).

- Decorator : Adds behavior dynamically (e.g., Filters, Wrappers).

- Facade : Simplifies a complex system via a unified interface (common in Spring services).

- Flyweight : Memory optimization via sharing (rarely needed directly).

- Proxy : Placeholder for another object (e.g., AOP proxies, lazy loading).

## Behavioral Patterns (Object interaction)

- ~~ Strategy : Family of interchangeable algorithms (e.g., payment modes). ~~

- ~~ Template Method : Base class defines algorithm skeleton; subclasses override steps.~~

- ~~Observer : One-to-many notification (e.g., event handling, ApplicationListener in Spring).~~

- ~~Command : Encapsulates request as an object (e.g., task queues, undo operations).~~

- ~~Chain of Responsibility : Pass requests along a chain (e.g., Spring Security filters).~~

- ~~State : Changes behavior when internal state changes.~~

- Mediator : Centralizes complex communication (e.g., UI components).

- Memento : Captures and restores object state (e.g., undo operations).

- ~~Visitor : Adds operations to objects without changing classes (used in compilers or ASTs).~~

- Interpreter : Evaluates language grammar (rare unless building DSLs).

## Enterprise & Spring-Relevant Patterns

- ~~Dependency Injection : Delegates object creation to a container (Spring core pattern).~~

- Service Locator : Alternative to DI (less preferred now).

- DAO (Data Access Object) : Abstracts persistence logic.

- Repository : Domain-focused data access abstraction.

- DTO (Data Transfer Object) : Data carrier between layers.

- Business Delegate : Decouples presentation from business logic.

- ~~ MVC (Model-View-Controller) : Web applications (Spring MVC). ~~

- Observer/Event Publisher : Used in @EventListener, ApplicationEventPublisher.