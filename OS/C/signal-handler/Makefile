CC = gcc
CFLAGS = -Wall -Wextra

SRC = src/signal-handler.c
OUT = bin/demo-app

build: clean $(SRC)
	mkdir -p bin
	$(CC) -I $(CFLAGS) $(SRC) -o $(OUT)

all : clean build
	./$(OUT)

clean:
	rm -f $(OUT)