CC = gcc
CFLAGS = -Wall -Wextra

SRC = src/fork/separate-address-space.c
OUT = bin/app

$(OUT): $(SRC)
	mkdir -p bin
	$(CC) $(CFLAGS) $(SRC) -o $(OUT)

all : clean $(OUT)
	./$(OUT)

clean:
	rm -f $(OUT) file1.txt file2.txt