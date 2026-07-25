# Component Cohesion

Which classes belong to which components?

## Principles of component cohesion

### Reuse/Release Equivalence Principle (REP)

The granule of reuse is the granule of release.

### Common Closure Principle (CCP)

Gather into components those classes that change for the same reasons and the same times. 
Separate into different components those classes that change at different times and for different reasons.

This the Single responsibility principle restated for components.

### Common Reuse Principle

Don't force users of a component to depend on things they don't need.

This the Interface Segregation principle restated for components.

## Acyclic Dependendency Principle

The component dependency graph must be a Directed Acyclic Graph (DAG).

Direction: Dependencies must point from volatile details(low level) towards stable policies(high level abstractions)

## Business Rules

Business rules are rules or procedures that make or save the business money.Very strictly speaking, 
these rules would make or save the business money, irrespective of whether they were implemented on a computer or 
were executed manually. 
    The fact that a bank charges N% interest for a loan is a business rule that makes the bank money. 
It doesn’t matter if a computer program calculates the interest, or if a clerk with an abacus calculates the interest.

**Business rules should depend on data structures, not to any framework.**

## Working Rule

1. First make it work - You are out of business if it doesn’t work.

2. Then make it right  - Refactor the code so that you and others can understand
                        it and evolve it as needs change or are better understood.

3. Then make it fast -  Refactor the code for “needed” performance.

## Detail

Database is a detail (low level mechanism). 
**Data model is significant to architecture, but not database.**

The WEB is a detail. Its an IO device.

Frameworks are details.