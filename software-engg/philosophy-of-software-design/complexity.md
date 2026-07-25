# Philosophy of software design

## Pull complexity downwards

It is more important for a module to have a simple interface than a simple implementation.
The goal is to minimize overall system complexity.

## Better together or better apart?

One of the most fundamental questions in software design is this: given two pieces of functionality, 
should they be implemented together in the same place, or should their implementations be separated?


### Bring together if information is shared

### Bring together if it will simplify the interface

### Bring together to eliminate duplication

## Design it twice

## Why write comments

* Code explains how; comments explain why.
* Comments should add information that code cannot express.
* Don’t write comments that merely restate the code.
* Write interface comments for public APIs.
* Write implementation comments only where the reasoning isn’t obvious.
* Good comments reduce the mental effort needed to understand the code.
* Treat comments as part of the software’s design documentation, not an afterthought.

