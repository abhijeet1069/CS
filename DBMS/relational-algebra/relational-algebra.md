# Relational Algebra

The relational algebra consists of a set of operations that take one or two relations as
input and produce a new relation as their result.

## Select operator (σ)

The select operation selects tuples that satisfy a given predicate.

```shell
# select those tuples of the instructor relation where the instructor is in the “Physics” department.
σ(dept) name =“Physics” (instructor)
```

## Project operator (Π)

The project operation allows us to produce this relation. The project
operation is a unary operation that returns its argument relation, with certain attributes
left out.

```shell
# Find the names of all instructors in the Physics department. We write:

Πname (σ dept name =“Physics” (instructor))
```

## Cartesian product (x)

The Cartesian product combines every row of one relation with every row of another relation.

If you have:

- Relation R with m rows
- Relation S with n rows

R × S → produces m × n rows

## Join operation (⨝)

R ⨝ condition S  =  σ(condition)(R × S)

## Assignment (←)

```shell
# Find courses that run in Fall 2017 as well as Spring 2018, which we saw earlier

courses fall 2017 ← Πcourse id(σsemester =“Fall”∧ year=2017 (section))
courses spring 2018 ← Πcourse id(σsemester =“Spring” ∧ year=2018 (section))
courses fall 2017 ∩ courses spring 2018
```

## Rename (ρ)

Rename operator, denoted by the lowercase Greek letter rho (ρ), lets us do
this. Given a relational-algebra expression E, the expression
ρx (E), returns the result of expression E under the name x.

