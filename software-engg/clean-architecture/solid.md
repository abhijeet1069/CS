# Design principles:

## SOLID principle

### Single Responsibility Principle

SRP - A module should be responsible to one and only one actor.

Actor - A group of users or stakeholders who request changes
Module - A module is a boundary around a cohesive policy

SRP decides who owns a rule; DRY ensures that rule is defined in one place.

### Open Closed Principle 

A software artifact should be open for extension but closed for modification.
    The goal of OCP is to make the system easy to extend without incurring a high impact of change. 
    The goal is accomplished by partitioning the system into components, and arranging those components into a 
    dependency hierarchy that protects higher level components from changes in lower level components. 
    (If you use DIP correctly, you get this for free)

### Liskov Substitution Principle

Subtypes must not surprise

### Interface Segregation Principle 

Don't force clients to depend on what they dont use.

### Dependency Inversion Principle

Low level mechanics, should depend on high level intent

This is one of the most powerful principles of software architecture.

In Dependency inversion, the source code of the high level policies
do not mention the source code of the lower level mechanism.

Dependency inversion keeps control in your hands by making details adapt to your design, not the other way around.

Dependency inversion lets programmer exit early, skim code at high level

- High-level code sees intent
- Low-level code deals with mechanics

👉 Low-level code should throw exceptions.
👉 High-level code should decide what to do with them.

**Exceptions are not bugs — they’re signals.**

For guard rails:
Validate once at the boundary.
Assume correctness inside the module.

Also, later if you want some private subfunction for another client, expose that via public function

## DRY principle

DRY - One piece of knowledge (rule, fact, or decision) should have single authoritative source in the system.
**DRY prevents contradictory truths, not duplication per se.**

Apply DRY inside a module (low-level mechanics); avoid DRY across modules (high-level policy). 
DRY is not increasing coupling in the system.

## YAGNI

You aren't gonna need it. Don't build functionality until you actually need it.

## KISS

Keep it simple and stupid. Start simple, refactor when complexity actually appears