# System

## Separate construction from use	

Don’t mix object creation logic with business logic

If the object is a dependency (used repeatedly or across components), separate construction from use.
If the object is transient, small, or tightly scoped, it's okay to construct inline.

✅ How to Apply
- Use Dependency Injection (manual or via a framework like Spring).
- Use Factory classes or Builders if object creation is complex.
- Use Inversion of Control (IoC) containers to manage lifecycles and wiring.

## Use POJOs	

Keep domain logic simple and testable

## Minimize coupling	

Each part of your system should know as little as possible about others
This is the general case of Law of Demeter

## Use Aspects (or tools)	

Cleanly handle cross-cutting concerns (like logging, security, etc.)

##Testability of systems	

You should be able to drive system development with tests