# Threads

Threads are like multiple execution paths inside same process.
    While processes are completely separate virtual memory worlds.

Threads INSIDE same process share:

* heap
* globals
* virtual memory
* file descriptors

But each thread has:

* its own stack
* registers
* program counter

## Registers on ARM

* w0-w30 : 32-bit registers
* x0-x30 : 64-bit versions
* sp : stack pointer

## Disassembly on ARM

```C
int main(){
    int a = 2;
    int b = 3;
    int c = a+b;
    return c;
}
```

```shell
(lldb) disassemble -n main 
app`main:
app[0x100000328] <+0>:  sub    sp, sp, #0x10        -- reserve 16 bytes
app[0x10000032c] <+4>:  str    wzr, [sp, #0xc]      -- store 0 into memory at sp+12 (for debugger)
app[0x100000330] <+8>:  mov    w8, #0x2 ; =2 
app[0x100000334] <+12>: str    w8, [sp, #0x8]       -- *(sp + 8) = 2
app[0x100000338] <+16>: mov    w8, #0x3 ; =3 
app[0x10000033c] <+20>: str    w8, [sp, #0x4]       -- *(sp + 4) = 3
app[0x100000340] <+24>: ldr    w8, [sp, #0x8]       -- load from memory into register
app[0x100000344] <+28>: ldr    w9, [sp, #0x4]
app[0x100000348] <+32>: add    w8, w8, w9           -- w8 = w8 + w9
app[0x10000034c] <+36>: str    w8, [sp]
app[0x100000350] <+40>: ldr    w0, [sp]
app[0x100000354] <+44>: add    sp, sp, #0x10
app[0x100000358] <+48>: ret  
```

## Process memory layout

High Addresses
│
├── Stack
│      ↓ grows downward
│
│
├── free area
│
├── Heap
│      ↑ grows upward
│
├── Globals
├── Code
│
Low Addresses

## Lock

A lock is about mutual exclusion.
In POSIX library, a lock is also called a mutex.
Only one thread can own the lock at a time. (much like bathroom)

* Thread A ---- acquires lock ----> enters critical section
* Thread B ---- waits
* Thread A ---- releases lock
* Thread B ---- acquires lock