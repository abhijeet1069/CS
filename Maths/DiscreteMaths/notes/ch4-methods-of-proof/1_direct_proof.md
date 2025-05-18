# Elementary number theory and methods of proof

"... it is demanded for proof that every doubt becomes impossible." - Charles Friedrich Gauss

One of the most important reasons for requiring proof in mathematics is that writing a proof forces us to become aware
of weaknesses in our arguments and in the unconscious assumptions we have made.

## Definitions

### Even Odd

An integer n is even iff n equals twice some integer. An integer n is odd iff n equals twice some integer plus 1.
    n is even <=> n = 2k for some integer k
    n is odd  <=> n = 2k+1 for some integer k

### Prime

n is prime <=> ∀ positive integers r and s, if n = rs
                then either r=1 and s=n or r=n and s=1
n is composite <=> ∃ positive integers r and s, if n = rs
                and 1 < r < n and 1 < s < n

### Perfect Square

An integer n is called a perfect square iff, n = k^2 for some integer k

### Rational numbers

A real number r is rational iff it can be expressed as a quotient of 2 integers with a nonzero denominator. A real
number that is not rational is irrational.
More formally,
    r is rational <=> ∃ integers a and b such that r = a/b and b ≠ 0

$$
\text{Is } 0.121212\ldots \text{ a rational number?} \\
Solution: \\
x = 0.1212.... \\
\text{Then } 100x = 12.121212\ldots \\
100x - x = 12.1212\ldots - 0.1212\ldots \\
99x = 12 \\
x = \frac{12}{99}
$$

## Proving existential generalization (Existential Generalization)

∃x ∈ D such that Q(x) is true iff,
    Q(x) is true for at least one x in D

## Disproving Universal statments by Counterexample

To disprove a statement ∀x in D, if P(x) then Q(x),
prove ∃x ∈ D such that P(x) and not Q(x) and this x is called a counter example

## Generalizing from the Generic particular

To show that every element of a set satisfies a certain property, suppose x is a particular but arbitrarily chosen
element of the set, and show that x satisfies the property.

## Method of Direct Proof

- Express the statement to be proved in the form "For every x ∈ D, if P(x) then Q(x)"
- Start the proof by supposing x is particular but arbitrarily chosen element of D for which the hypothesis
    P(x) is true
- Show that the conclusion Q(x) is true using definitions, previously established results and the rules for
    logical inference.

## Existential Instantiation

If the existence of a certain kind of object is assumed or has been deduced, then it can be given a name, as long as
that name is not currently being used to refer something else in the same discussion.