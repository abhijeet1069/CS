# Predicates and Quantfied Statements

## Predicate

A predicate is a sentence that contains a finite number of variables and becomes a statement when specific values are
substituted for the variables. The domain of a predicate variable is the set of all values that may be substituted in
place of the variable.

## Universal Quantifier ∀

Another way to obtain statements from predicates is to add quantifiers. The symbol ∀ is called universal quantifer.
Depending on the context, its read as "for every", "for each", "for any", "given any", "for all".

## Existential Quantifier ∃

Depending on the context its read as "there exists","there is atleast one","for some","for atleast one"

## Universal Conditional Statements

One of the most important statements in the language of mathematics
∀x, if P(x) then Q(x)

## Implicit quantification

If quantifier are mentioned explicitly then below statements would be

1. (x+2)^2 = (x^2+2x+1)
∀ real number x, (x+2)^2 = (x^2+2x+1)

2. Solve 3x-4 = 5
∃ real number x, 3x-4 = 5

3. P(x) => Q(x)
∀x, P(x) => Q(x)

4. P(x) <=> Q(x)
∀x, P(x) <=> Q(x)
Here, P(x) and Q(x) has identical truth sets 

The quantification of a statement—whether universal or existential—crucially determines both how the statement can be 
applied and what method must be used to establish its truth. Thus it is important to be alert to the presence of hidden 
quantifiers when you read mathematics so that you will interpret statements in a logically correct way.

## Negation of a Universal Statement

~(∀x ∈ D, Q(x)) ≡ ∃x ∈ D such that ~Q(x)
~(∃x ∈ D, Q(x)) ≡ ∀x ∈ D such that ~Q(x)