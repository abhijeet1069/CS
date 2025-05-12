# Learn ARM assembly

r0 -> General purpose register
r7 ->  Special purpose register for OS, 1 is for closing the program
swi -> software interrupt, interrupt your program to let OS do its job

```asm

.global _start
_start:
	mov r0,#13
	mov r7,#1
	swi 0 
	
```