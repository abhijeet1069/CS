# Virtual Memory

Virtual memory is an abstraction where each process gets its own private memory space.

## Page Table

In general, a page table
stores virtual-to-physical address translations, thus letting the system
know where each page of an address space actually resides in physical
memory. Because each address space requires such translations, in general 
there is one page table per process in the system. 
    The exact structure of the page table is either determined by the hardware 
    (older systems) or can be more flexibly managed by the OS (modern systems).

Virtual Address = Virtual Page number + Offset

Virtual page -> Physical Frame

## TLB

TLB is effectively a specialized cache inside the CPU.
But unlike normal caches:
* it stores address translations
    NOT:
* normal program data.

TLB behaves like HashMap<VirtualPage, PhysicalFrame>

 Even though this
is the first time the program accesses the array, the TLB improves performance 
due to spatial locality. The elements of the array are packed
tightly into pages (i.e., they are close to one another in space), and thus
only the first access to an element on a page yields a TLB miss.