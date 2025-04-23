CC = gcc
CFLAGS = -Wall -g -Iinclude
SRC_DIR = src
BIN_DIR = bin
OBJ_DIR = obj

SRCS = $(wildcard $(SRC_DIR)/*.c)
OBJS = $(SRCS:$(SRC_DIR)/%.c=$(OBJ_DIR)/%.o)
TARGET = $(BIN_DIR)/hello

.PHONY: all clean

all: $(TARGET) run

run : $(TARGET)
	./bin/hello

$(OBJ_DIR)/%.o: $(SRC_DIR)/%.c
	mkdir -p $(OBJ_DIR)
	$(CC) $(CFLAGS) -c $< -o $@

$(TARGET): $(OBJS)
	mkdir -p $(BIN_DIR)
	$(CC) $(CFLAGS) $^ -o $@

asm : $(SRC_DIR)/example.c
	gcc -S -O0 $(SRC_DIR)/example.c -o example.s

clean:
	rm -rf $(BIN_DIR) $(OBJ_DIR)