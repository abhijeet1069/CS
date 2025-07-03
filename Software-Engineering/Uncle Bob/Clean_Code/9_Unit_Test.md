# Unit Tests

## F.I.R.S.T

Clean tests should adhere to the following principles:

- Fast : Tests should be fast. They should run quickly. When tests run slow, you won’t want
to run them frequently. If you don’t run them frequently, you won’t find problems early
enough to fix them easily. You won’t feel as free to clean up the code. Eventually the code
will begin to rot.

- Independent : Tests should not depend on each other. One test should not set up the conditions
for the next test. You should be able to run each test independently and run the tests in
any order you like. When tests depend on each other, then the first one to fail causes a cascade
of downstream failures, making diagnosis difficult and hiding downstream defects.

- Repeatable : Tests should be repeatable in any environment. You should be able to run the
tests in the production environment, in the QA environment, and on your laptop while
riding home on the train without a network. If your tests aren’t repeatable in any environment,
then you’ll always have an excuse for why they fail. You’ll also find yourself unable
to run the tests when the environment isn’t available.

- Self-Validating : The tests should have a boolean output. Either they pass or fail. You
should not have to read through a log file to tell whether the tests pass. You should not have
to manually compare two different text files to see whether the tests pass. If the tests aren’t
self-validating, then failure can become subjective and running the tests can require a long
manual evaluation.

- Timely : The tests need to be written in a timely fashion. Unit tests should be written just
before the production code that makes them pass. If you write tests after the production
code, then you may find the production code to be hard to test. You may decide that some
production code is too hard to test. You may not design the production code to be testable.


## Testing Pyramid

-  Manual Tests : These are tests which couldn't be automated, but we should reduce this else each release
		will take lot of time.

- End to End Tests : Here we test the entire application, and see that the application is meeting
	business requirements. These tests can include performance testing, regression testing and security testing
		(These take the longest time)

- Integration Tests : Integrate components and test
	We don't test the entire application but only the various integration

- Component Tests : Test each component individually like frontend or backend
	For example, mocking database to verify the happy and unhappy paths of your application

- Unit Tests : Base of the pyramid containing most tests

## Use Test Driven Development

- First Law : You may not write production code until you have written a failing unit test.

- Second Law : You may not write more of a unit test than is sufficient to fail, and not compiling is failing.

- Third Law : You may not write more production code than is sufficient to pass the currently failing test.

## Keep tests clean

Test code is as important as production code. It is not a second class citizen. It requires thought, design and care.
It must be kept as clean as production code.

## Build Operate Check Pattern

Tests following this pattern are readable and easier to understand, debug and maintain

- First part, builds up the test data
- Second part, operates on that test data 
- Third part, checks that the operation yielded the expected results.

```java
@Test
void testAddTwoNumbers() {
    // BUILD
    Calculator calculator = new Calculator();

    // OPERATE
    int result = calculator.add(2, 3);

    // CHECK
    assertEquals(5, result);
}

```

## Test Single concept per test

## Tests

### Insufficient Tests

A test suite should test everything that could possibly break.
The tests are insufficient so long as there are conditions that have not been explored by the
tests or calculations that have not been validated.

### Use a coverage tool

Coverage tools reports gaps in your testing strategy. They make it easy to find modules,
classes, and functions that are insufficiently tested.

### Don't skip trivial tests

They are easy to write and their documentary value is higher than the cost to produce
them.

### Tests Boundary Conditions

Take special care to test boundary conditions. We often get the middle of an algorithm
right but misjudge the boundaries.

### Exhaustively Test Near Bugs

Bugs tend to congregate. When you find a bug in a function, it is wise to do an exhaustive
test of that function. You’ll probably find that the bug was not alone.

## Conclusion

The code within the testing API does have a different set of engineering standards than production
code. It must still be simple, succinct, and expressive, but it need not be as efficient as
production code. After all, it runs in a test environment, not a production environment, and
those two environment have very different needs.

It is the unit tests that keep our code flexible, maintainable and reusable.