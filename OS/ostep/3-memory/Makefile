CC = gcc
CFLAGS = -Wall -Wextra

SRC = src/tlb.c
OUT = bin/app

$(OUT): $(SRC)
	mkdir -p bin
	$(CC) $(CFLAGS) $(SRC) -o $(OUT)

all : clean $(OUT)
	./$(OUT)

clean:
	rm -f $(OUT)