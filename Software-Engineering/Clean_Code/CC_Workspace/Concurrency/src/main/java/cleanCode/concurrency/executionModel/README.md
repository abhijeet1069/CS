# Know your execution models

## Definitions

- Bound Resource
	Resources of a fixed size or number used in a concurrent environment.
	Examples include database connections and fixed-size read/write buffers.
	
- Mutual Exclusion
	Only one thread can access shared data or a shared resource at a time.
	
- Starvation
	One thread or a group of threads is prohibited from proceeding for an excessively long time or forever.
For example, always letting fast-running threads through first could starve out longer running
threads if there is no end to the fast-running threads.

- Deadlock
	Two or more threads waiting for each other to finish. Each thread has a resource that the other thread
	requires and neither can finish until it gets the other resource.

- LiveLock
	Threads in lockstep, each trying to do work but finding another “in the way.” Due to resonance, threads continue trying to make progress but are unable to for an excessively long time—or forever.
	
## Deadlock vs Livelock

- Deadlock	
	- Threads blocked, waiting forever
	- No thread can proceed
	- Usually need external intervention

- Livelock
	- Threads actively running but stuck in retry loops
	- Threads keep changing states but no progress
	- Usually need better retry/backoff strategies
	
## Producer Consumer Problem

A classic concurrency problem where:

- Producer(s) create data/items and put them into a shared buffer.

- Consumer(s) take data/items from the buffer for processing.

The challenge: coordinate producers and consumers so that:

- Producer waits if the buffer is full.

- Consumer waits if the buffer is empty.

- No race conditions or data corruption happen.

## Reader Writer problem

Multiple threads may read data simultaneously without conflicts.

But when a thread writes data, it needs exclusive access (no other readers or writers).

The problem is to coordinate access so that:

- Multiple readers can read concurrently.

- Writers get exclusive access.

- No starvation (readers or writers are not indefinitely blocked).
	
	
	
	
	
	
	
	
	