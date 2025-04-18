# Uncle Bob - Clean Code

## The only way to go fast is to go well

What is it that is going to make you go fast tomorrow? Nothing. Only way is to go well, don't build the road blocks.
Make the code working (half the job), then clean the code.

## Clean code is a necessity

Keeping your code clean is not just cost effective, it's a matter of professional survival.

## Avoid switch and goto statements

## Indenting

1-2 level indents are sufficient for a function, even if it is for try catch statements. And avoid
nesting of try-catch.

## Computer Science

In software, we do science not mathematics. We don't prove our programs correct, we just surround
our software with tests to prove that its not failing.

## Use Design patterns

## Naming strategy

- Reveal your intent. The name of a variable should tell us the significance of what that variable contains.
  Names should be unambiguous.

## Pair programming is good

They are even better than code reviews.

## Programmers Oath

This is a professional promise, and it exceeds the authority of your employer.

In order to defend and preserve the honor and profession of computer programmers, I promise that:

1. I will not produce harmful code
    - I will not release a defect
    - I will not make code for others harder to understand or change (soft-ware is supposed to be easy to change)

2. The code that I produce will always be my best work
   - I will not willingly release code that is defective either in behavior or structure

3. I will provide with each release a quick, sure and repeatable proof that every element of the code works as
   it is supposed to.
   - Write tests

4. I will make frequent and small releases
    - So that other team members don't have to remain idle for the programmer to finish his job

5. I will fearlessly and relentlessly improve at any opportunity, will not make the code worse

6. I will keep productivity my own and my team high, I will do nothing that decreases that productivity
   - I will not damage the code, I will not make things worse

7. I will continuously ensure, that others can cover for me and that I can cover for them

8. I will produce estimates that are honest both in magnitude and precision, I will not make promises without certainty

9. I will never stop learning and improving my craft

When do professionals learn?

Not on the job. It is not your employer's responsibility to groom your career. You take that responsibility, you learn
at home. Because that's what professionals do, professionals spend much more than 40 hours a week on their career. It's
just the truth of the matter, you may not like it but that's the way it is.

## Importance of Unit Tests

It is the unit tests that keep our code flexible, maintainable and reusable.

## Test driven development

TDD is analogous to double entry book-keeping in software, both production code and test code should excute and  
have 0 tests failed. Zero on both sides, is double entry book keeping.

- Write a test for the next bit of functionality you want to add.
- Write the functional code until it passes
- Refactor both new and old code to make it well structured

## A programmer is a stakeholder of his software

## Trade-Off

There is an inevitable tradeoff in project management. We can only pick any three of four.

- Good (Quality)
- Fast (Time from idea to final product to market)
- Cheap (Cost effectiveness)
- Done

## QA testing

When the developer has shared code to QA. They should find nothing.

## Why is estimating so hard?

Tasks that appear easy for a human to solve are often described by complex procedures. So when estimating, make sure you
aren’t affected by the apparent ease of that task. Look below the surface to try to enumerate the number of procedural
elements.

## Waterfall Model

Developed by Winston Royce in 1970

- Software Requirements
- Analysis
- Program Design
- Coding
- Testing
- Operations

## Agile

- Break a project into fixed size chunks or iteration.
- Measure how much time you take to complete an iteration.
- Study those numbers and adjust accordingly.

Each iteration produces data, not code.
Agile may improve speed of project, but it actually tells us what is the speed of the project.
