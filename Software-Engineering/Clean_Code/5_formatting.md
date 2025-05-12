# Formatting

Code formatting is about communication, and communication is the professional developer’s first order of business.

## Size of a class

A class can be typically 200 lines long, with an upper limit of 500.

## Variable declaration

Variables should be declared as close to their usage as possible.

## Instance variables

Instance variable should be declared at the top of the class.

## Dependent functions

If one function calls another, they should be vertically close, and the caller should be above the callee, if at all 
possible. This gives the program a natural flow. Also, This creates a nice flow down the source code module from high 
level to low level.

```javascript

function main() {
    processInput();
    calculateResult();
    displayOutput();
}

function processInput() {
    // ...
}

function calculateResult() {
    // ...
}

function displayOutput() {
    // ...
}

```

## Width of a line

100-120 characters in a line is good.

## Breaking Indentation

We shouldn't break the indentation of the code even for short if statement or short functions etc. Its tempting but
to break the indentation but should be avoided.

## Team Rules

A team of developers should agree upon a single formatting style, and then every member of that team should use that 
style. We want the software to have a consistent style. We don’t want it to appear to have been written by a bunch of
disagreeing individuals.