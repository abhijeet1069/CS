# Semaphore

A semaphore maintains a set of permits. Threads acquire permits before accessing the resource and release permits when done.

## Use case

- Limit number of concurrent users (e.g., only 3 threads allowed in a section).

- Manage access to rate-limited services.

- Implement resource pools like DB connections, printer queues, etc.
