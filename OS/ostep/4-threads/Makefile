CC = gcc
CFLAGS = -Wall -Wextra -pthread
INCLUDE = ./include

SRC = src/semaphore/dining-philosopher-deadlock.c
OUT = bin/program

all : clean build run

build: clean $(SRC)
	mkdir -p bin
	$(CC) -I $(INCLUDES) $(CFLAGS) $(SRC) -o $(OUT)

run: $(OUT)
	./$(OUT)

asm:
	$(CC) -I $(INCLUDES) $(CFLAGS) -S $(SRC)

clean:
	rm -f $(OUT)