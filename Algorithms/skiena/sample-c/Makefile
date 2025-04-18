CC = gcc
CFLAGS = -Wall -Wextra -Iinclude
SRC = $(wildcard src/*.c)
OBJ = $(patsubst src/%.c, bin/%.o, $(SRC))  # Move object files to bin/
EXEC = bin/dsa_app

# Default target
all: clean $(EXEC)

# Build the executable
$(EXEC): $(OBJ)
	$(CC) $(CFLAGS) $(OBJ) -o $(EXEC)

# Compile C files into object files in bin/
bin/%.o: src/%.c
	@mkdir -p bin  # Ensure bin exists
	$(CC) $(CFLAGS) -c $< -o $@

# Run the application
run: all
	./$(EXEC)

# Clean up compiled files
clean:
	rm -rf bin/