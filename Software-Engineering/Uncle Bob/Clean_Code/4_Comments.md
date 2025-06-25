# Comments

Truth can only be found in one place: the code. Only the code can truly tell you what it does. 
It is the only source of truly accurate information. Therefore, though comments are sometimes necessary, 
we will expend significant energy to minimize them.

```java

//bad
// Check to see if the employee is eligible for full benefits
if ((employee.flags & HOURLY_FLAG) && (employee.age > 65))

//better
if (employee.isEligibleForFullBenefits())

```

## Inappropriate Information

It is inappropriate for a comment to hold information better held in a different kind of system
such as your source code control system, your issue tracking system, or any other
record-keeping system. Change histories, for example, just clutter up source files with
volumes of historical and uninteresting text. In general, meta-data such as authors, lastmodified-
date, SPR number, and so on should not appear in comments. Comments should
be reserved for technical notes about the code and design.

### Legal comments

Instead of using comments like below in every source code, use an external document for license.

```java

// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
```

## Obsolete Comments

A comment that has gotten old, irrelevant, and incorrect is obsolete. Comments get old
quickly. It is best not to write a comment that will become obsolete. If you find an obsolete
comment, it is best to update it or get rid of it as quickly as possible. Obsolete comments
tend to migrate away from the code they once described. They become floating islands of
irrelevance and misdirection in the code.

## Redundant Comment

A comment is redundant if it describes something that adequately describes itself. For
example:

```java
i++; // increment i
```

Another example is a Javadoc that says nothing more than (or even less than) the function
signature:

```java

/**
@param SellRequest
@return
@throws ManagedComponentException
**/
public SellResponse beginSellItem(SellRequest sellRequest)
throws ManagedComponentException
```

Comments should say things that the code cannot say for itself.

## Bad comments

Below comment is less precise than the code and entices the reader to accept that lack of
precision in lieu of true understanding. It is rather like a gladhanding used-car salesman
assuring you that you don’t need to look under the hood.

```java
// Utility method that returns when this.closed is true. Throws an exception
// if the timeout is reached.
public synchronized void waitForClose(final long timeoutMillis) throws Exception{
	if(!closed){
		wait(timeoutMillis);
		if(!closed)
			throw new Exception("MockResponseSender could not be closed");
	}
```

## Poorly written comment

A comment worth writing is worth writing well. If you are going to write a comment,
take the time to make sure it is the best comment you can write. Choose your words
carefully. Use correct grammar and punctuation. Don’t ramble. Don’t state the obvious.
Be brief.

## Commented out code

When you see commented-out code, delete it! Don’t worry, the source code control
system still remembers it. If anyone really needs it, he or she can go back and check out a
previous version. Don’t suffer commented-out code to survive.