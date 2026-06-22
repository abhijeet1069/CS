CC = gcc
CFLAGS = -Wall -Wextra

SRC = src/selecting-fn-at-runtime.c
OUT = bin/app

build: clean $(SRC)
	mkdir -p bin
	$(CC) -I $(CFLAGS) $(SRC) -o $(OUT)

all : clean build
	./$(OUT)

clean:
	rm -f $(OUT)