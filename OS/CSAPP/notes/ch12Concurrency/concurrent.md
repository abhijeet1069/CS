# Concurrent Programming

Applications that use application level concurrrency are known as concurrrent programs. Modern OS provide 3 ways for 
building concurrent programs:

- Processes : With this approach, each logical control flow is a process that is scheduled and maintained by the kernel. 
Since processes have separate virtual address spaces, flows that want to communicate with each other must use some
kind of explicit interprocess communication (IPC) mechanism.

- I/O multiplexing : This is a form of concurrent programming where applications explicitly schedule their own logical 
flows in the context of a single process. Logical flows are modeled as state machines that the main program explicitly
transitions from state to state as a result of data arriving on file descriptors. Since the program is a single process, 
all flows share the same address space.

- Threads : Threads are logical flows that run in the context of a single process and are scheduled by the kernel. 
You can think of threads as a hybrid of the other two approaches, scheduled by the kernel like process flows and sharing
the same virtual address space like I/O multiplexing flows.