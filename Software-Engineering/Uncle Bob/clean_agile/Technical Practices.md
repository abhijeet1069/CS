# Technical Practices

## Test driven development

Test-Driven Development is the corresponding practice for programmers. Every required behavior is entered twice: once as
a test, and then again as production code that makes the test pass. The two entries are complementary, just as assets
are complementary to liabilities and equities. When executed together, the two entries produce a zero result: Zero tests
failed.
    Programmers who learn TDD are taught to enter every behavior one at a time—once as a failing test, and then again as
    production code that passes the test. This allows them to catch errors quickly. They are taught to avoid writing a
    lot of production code and then adding a batch of tests, since errors would then be hard to find.

The tests are a form of documentation that describe the system being tested. This documentation is written in a language
that the programmers know fluently. It is utterly unambiguous, it is so formal it executes, and it cannot get out of
sync with the application code. The tests are the perfect kind of documentation for programmers: code.
    What’s more, the tests do not form a system in and of themselves. The tests don’t know about each other. There are
    no dependencies between the tests. Each test is a small and independent unit of code that describes the way one
    small part of the system behaves.

## Refactoring

Refactoring is the practice of improving the structure of the code without altering the behavior, as defined by the
tests.

Refactoring is a continuous process, and not one that is performed on a scheduled basis. We don’t make a huge mess for
days and days, and then try to clean it up. Rather, we make a very small mess, over a period of a minute or two, and
then we clean up that small mess.

Finally, never, ever, ever, ask for permission to pair. Or test. Or refactor. Or… You are the expert. You decide.

## Values of Agile

The four values of Agile:

- Courage
- Communication
- Feedback
- Simplicity

### Courage

The members of an Agile team are not so focused upon political safety that they sacrifice quality and opportunity. They
realize that the best way to manage a software project over the long term is with a certain degree of aggression.
    There is a difference between courage and recklessness. It requires courage to deploy a minimum feature set. It also
requires courage to maintain high code quality and maintain high-quality disciplines. However, it is reckless to deploy
code that you are not highly confident in or that has an unsustainable design. It is reckless to conform to a schedule
by sacrificing quality. The belief that quality and discipline increase speed is a courageous belief because it will
constantly be challenged by powerful but naive folks who are in a hurry.

### Communication

We value direct and frequent communication that crosses channels. Agile team members want to talk with one another. The
programmers, customers, testers, and managers want to sit near each other and interact with each other frequently, and
not just in the context of meetings. Not just through emails, chat, and memos. Rather, they value face-to-face,
informal, interpersonal conversation.

### Feedback

Maximize the frequency and quantity of feedback. They allow us to determine when things are going wrong early enough to
correct them.

Simplicity:

Simplicity is directness—directness in the code, and directness in communication and behavior. Keep the code simple.
Keep the team simpler.

The strongest advice I can give you, however, is to adopt the full Circle of Life, including, and most especially,
the technical practices. Far too many teams have adopted the outer business ring and have found themselves in
the trap that Martin Fowler has labeled “Flaccid Scrum.”
