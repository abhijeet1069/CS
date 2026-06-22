# Uncle Bob - Clean Code

## When do professionals learn?

Not on the job. It is not your employer's responsibility to groom your career. You take that responsibility, 
you learn at home. Because that's what professionals do, professionals spend much more than 40 hours a week on 
their career. It's just the truth of the matter, you may not like it but that's the way it is.

## The only way to go fast is to go well

What is it that is going to make you go fast tomorrow? Nothing. Only way is to go well, don't build the 
road blocks.
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

Tasks that appear easy for a human to solve are often described by complex procedures. So when estimating, 
make sure you aren’t affected by the apparent ease of that task. Look below the surface to try to enumerate the 
number of procedural elements.

## Waterfall Model

Developed by Winston Royce in 1970

- Software Requirements
- Analysis
- Program Design
- Coding
- Testing
- Operations

## Expectations of your CTO

### We will not ship shit

Any system that requires its users to think like programmers in order to enter data in the expected format is crap.

### Continuous technical readiness

At the end of each iteration all the coding, all the testing, all the documentation, and all the stabilization for the
stories should be implemented.

Is it possible for the system to be technically deployable every week or two?
Of course it is. The team simply has to pick a batch of stories that is small enough to allow them to complete all the 
deployment readiness tasks before the end of the iteration. They’d better be automating the vast majority of their
testing, too.

### Stable productivity

Customers and managers don’t expect software teams to slow down with time. Rather, they expect that a feature similar to
one that took two weeks at the start of a project will take two weeks a year later. They expect productivity to be
stable over time.
    Developers should expect no less. By continuously keeping the architecture, design, and code as clean as possible,
    they can keep their productivity high and prevent the otherwise inevitable spiral into low productivity and redesign.

### Inexpensive adaptability

Software is a compound word. The word “ware” means “product.” The word “soft” means easy to change. Therefore, software
is a product that is easy to change.

If a change to the requirements breaks your architecture, then your architecture sucks.
We developers should celebrate change because that’s why we are here.
Changing requirements is the name of the whole game. Those changes are the justification for our careers and our
salaries. Our jobs depend on our ability to accept and engineer changing requirements and to make those changes
relatively inexpensive.

### Continuous Improvement

The older a software system is, the better it should be.
The design and architecture of a software system should get better with time. The structure of the code should improve,
and so should the efficiency and throughput of the system.

### Fearless Competence

Why don’t most software systems improve with time? Fear. More specifically, fear of change.

### QA should find nothing

QA should find no faults with the system. When QA runs their tests, they should come back saying that everything works
as required. Any time QA finds a problem, the development team should find out what went wrong in their process and fix
it so that next time QA will find nothing.

### Test automation

Manual tests are always eventually lost.

However, there is a more insidious mechanism for losing manual tests.
Developers seldom deliver to QA on time. This means that QA has less time than planned to run the tests they need to run.
So, QA must choose which tests they believe are most appropriate to run in order to make the shipment deadline.
And so some tests aren’t run. They are lost.

And besides, humans are not machines. Asking humans to do what machines can do is expensive, inefficient, and immoral.
There is a much better activity for which QA should be employed—an activity that uses their human creativity and
imagination.

### We cover for each other

I don’t expect the team to keep knowledge in silos; I expect knowledge to be shared. If I need to reassign half the
members of the team to a new project, I do not expect that half the knowledge will be removed from the team.

### Honest Estimates

I expect estimates, and I expect them to be honest.

For example, you may not know how long something will take, but you can compare one task to another in relative terms.
You may not know how long it will take to build the Login page, but you might be able to tell me that the
Change Password page will take about half the time as Login. Relative estimates like that are immensely valuable.

### You need to say "NO"

I expect that, no matter how much schedule pressure you feel, no matter how many managers are demanding results, you
will say “no” when the answer really is “no.”

### Continuous Agressive Learning

As CTO, I expect you to keep learning. Our industry changes quickly. We must be able to change with it.
**So learn, learn, learn!** Sometimes the company can afford to send you to courses and conferences. Sometimes the
company can afford to buy books and training videos. But if not, then you must find ways to continue learning without
the company’s help.

### Mentoring

As CTO I expect you to teach. Indeed, the best way to learn is to teach. So when new people join the team, teach them.
Learn to teach each other.
