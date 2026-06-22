# Extreme Programming (XP) Technical Practices

## Test-Driven Development (TDD)

Test-Driven Development is the core engineering practice of Extreme Programming.

Every required behavior is implemented twice:

1. As a failing test that describes the desired behavior.
2. As production code that makes the test pass.

The goal is simple:

Zero failing tests.

### The TDD Cycle

Programmers practice TDD by implementing one behavior at a time:

1. Write a test that fails.
2. Write the simplest code that makes the test pass.
3. Refactor the code while keeping all tests green.
4. Repeat.

This process is often summarized as:

Red → Green → Refactor

* Red: Write a failing test.
* Green: Make the test pass.
* Refactor: Improve the code without changing behavior.

### Why TDD?

TDD provides several benefits:

* Errors are detected immediately.
* New functionality is verified continuously.
* Developers gain confidence when making changes.
* The codebase becomes easier to maintain.

Writing a large amount of production code first and adding tests later makes defects harder to locate and fix.

### Tests as Documentation

Tests serve as a highly effective form of documentation because they:

* Describe expected system behavior.
* Are written in a language developers understand fluently.
* Are precise and unambiguous.
* Execute automatically.
* Remain synchronized with the application code.

Unlike traditional documentation, tests cannot become outdated without failing.

### Independent Tests

A well-designed test suite consists of small, independent tests.

Each test should:

* Verify one behavior.
* Be isolated from other tests.
* Run in any order.
* Avoid dependencies on external state whenever possible.

Key Principle: Tests document behavior and provide confidence for change.

## Refactoring

Refactoring is the practice of improving the internal structure of code without changing its externally 
observable behavior.

> Behavior is protected by the test suite.

Characteristics of Refactoring

Refactoring is:

* Continuous
* Incremental
* Safe
* Supported by automated tests

It is not a scheduled cleanup activity.

Bad approach:

Create a large mess over several days and clean it up later.

Preferred approach:

Make a small change, clean it immediately, and move forward.

Common Refactoring Goals

* Improve readability.
* Reduce duplication.
* Simplify complex logic.
* Improve naming.
* Increase maintainability.
* Strengthen design.

## Professional Responsibility

Testing, refactoring, and maintaining code quality are part of a developer’s professional responsibility.

Developers should not view these activities as optional tasks requiring special approval.

Key Principle: Leave the code cleaner than you found it.


## Pair Programming

Pair Programming is a collaborative development practice in which two or more developers work together on the same task.

The goal is to improve:

* Code quality
* Knowledge sharing
* Design decisions
* Defect detection

### Driver–Navigator Model

The most common pairing style.

Driver

* Operates the keyboard.
* Writes the code.
* Focuses on immediate implementation details.

Navigator

* Reviews the code as it is written.
* Thinks about design and architecture.
* Identifies potential issues.
* Suggests improvements and alternatives.

Roles should switch frequently.

### Ping-Pong Pairing

A TDD-focused pairing technique.

Process:

1. Developer A writes a failing test.
2. Developer B writes production code to make the test pass.
3. Developer B writes the next failing test.
4. Developer A makes it pass.

The cycle continues throughout development.

Benefits:

* Reinforces TDD discipline.
* Encourages collaboration.
* Keeps both developers actively engaged.

### Mob Programming

Mob Programming extends Pair Programming to a larger group.

Typical setup:

* One person controls the keyboard.
* The rest of the team collaborates on decisions.
* Driver responsibilities rotate regularly.

Benefits:

* Rapid knowledge sharing.
* Strong team ownership.
* Better handling of complex problems.
* Reduced knowledge silos.


Key Principle: Collaboration is a tool for improving both code quality and team capability.

⸻

## Summary of XP Technical Practices

* Write tests before production code.
* Follow the Red → Green → Refactor cycle.
* Treat tests as executable documentation.
* Keep tests independent and reliable.
* Refactor continuously rather than periodically.
* Improve code structure without changing behavior.
* Use Pair Programming to share knowledge and improve quality.
* Select the pairing strategy that best fits the problem and team.