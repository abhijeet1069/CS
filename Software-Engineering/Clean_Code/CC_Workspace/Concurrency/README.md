# Concurrency

Concurrency is a decoupling strategy, it helps us decouple what gets done from when it gets done.
In a single threaded application what and when are so strongly coupled that the state of entire
application can often be determined by looking at the stack backtrace.

A multi-threaded code if written badly can break under stress.


## Myths and Misconceptions

- Concurrency always improves performance.
	Concurrency can sometimes improve performance, but only when there is a lot of wait
time that can be shared between multiple threads or multiple processors. Neither situation
is trivial.

- Understanding concurrency is not important when working with a container such as Web or EJB container
	In fact, you’d better know just what your container is doing and how to guard against
the issues of concurrent update and deadlock

## Concurrency defense principles

- SRP (Single responsibility principle):
	Keep your concurrency related code separate from other code.

- Abstraction (Limit scope of data):
	Severely limit the access of any data that may be shared.

- Threads should be as independent as possible

- Use thread safe collections

- Avoid using more than one method on a shared object.

- Keep your synchronized sections as small as possible
	As synchronized introduces a lock, and allows only 1 thread to enter criticial section.
	Locking large section of code can slow the entire execution speed.

- Test threaded code
	Write tests that have the potential to expose problems and then
run them frequently, with different programmatic configurations and system configurations
and load. If tests ever fail, track down the failure. Don’t ignore a failure just because the
tests pass on a subsequent run.

	- Treat Spurious Failures as Candidate Threading Issues
	- Run your threaded code on all target platforms early and often.
	- Run with More Threads Than Processors
	- Get Your Nonthreaded Code Working First

## Java API for concurrency

- Basic Threading:

	- Thread class and Runnable interface

	- Thread life-cycle control (start(), join(), sleep())

- Synchronization Primitives:

	- synchronized blocks/methods

	- volatile keyword

	- wait(), notify(), notifyAll() on any object

- High-Level Locks:

	- ReentrantLock, ReentrantReadWriteLock

	- StampedLock

	- Condition variables (Condition interface)

- Atomic Variables:

	- AtomicInteger, AtomicLong, AtomicReference, etc.

	- Useful for lock-free thread-safe operations

- Concurrent Collections:

	- ConcurrentHashMap, CopyOnWriteArrayList, BlockingQueue (e.g., 	ArrayBlockingQueue, LinkedBlockingQueue)

	- Thread-safe variants of standard collections

- Executor Framework:

	- Thread pools (ExecutorService, ScheduledExecutorService)

	- Task submission (Callable, Future)

	- Work stealing pools, single-thread executors, fixed pools, cached 		pools

- Synchronizers:

	- CountDownLatch, CyclicBarrier, Semaphore, Exchanger

	- Powerful tools for complex coordination

- Fork/Join Framework:

	- Parallel task splitting and joining for divide-and-conquer 	algorithms

- CompletableFuture and Reactive APIs:

	- Asynchronous programming and chaining of tasks