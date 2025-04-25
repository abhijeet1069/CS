# Number system and circuit for addition

Typically a fixed number of bits is used to represent integers on a computer. One way to
do this is to select a particular bit, normally the left-most, to indicate the sign of the integer,
and to use the remaining bits for its absolute value in binary notation.

## Two's complement

The 8 bit two's complement for an integer a between -128 and 127 is the 8 bit binary representation for
        a, if a >= 0
        2^8-|a|, if a < 0 


Two’s complement partitions the number line into two halves:

1.	Negative Numbers (Left Half) – Represented by the most significant bit (MSB) being 1
2.	Non-Negative Numbers (Right Half) – Represented by the MSB being 0 

        Negative Side                         Positive Side
10000000 (-128)  ...  11111111 (-1) | 00000000 (0) ... 01111111 (127)

### Negative Integer to 8 bit 2's complement

- Write the 8-bit binary representation for |a|
- Flip all bits
- Add 1 in binary notation

### 2's complement to an integer

- If the left most digit is 1, the integer is negative
- Flip all bits
- Add 1 in binary notation
- Convert to decimal and add the -ve sign

## Hexadecimal notation

Hexadecimal notation is even more compact than decimal notation.

Decimal     Hexadecimal     4-Bit Binary Equivalent
0               0                   0000
1               1                   0001
2               2                   0010
3               3                   0011
4               4                   0100
5               5                   0101
6               6                   0110
7               7                   0111
8               8                   1000
9               9                   1001
10              A                   1010
11              B                   1011
12              C                   1100
13              D                   1101
14              E                   1110
15              F                   1111

## NAND and NOR gates

Any Boolean expression is equivalent to one written entirely with Sheffer strokes or entirely with Peirce arrows.

### NAND (Sheffer stroke)

P | Q = ~(P∧Q)

### NOR (Pierce arrow)

P↓Q = ~(P∨Q)