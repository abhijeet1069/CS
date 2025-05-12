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
## Legal comments

Instead of using comments like below in every source code, use an external document for license.

```java

// Copyright (C) 2003,2004,2005 by Object Mentor, Inc. All rights reserved.
// Released under the terms of the GNU General Public License version 2 or later.
```

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