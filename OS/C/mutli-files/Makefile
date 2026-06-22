CC = gcc
CFLAGS = -Wall -Wextra -std=c11

TARGET = app

OBJS = main.o math.o

$(TARGET): $(OBJS)
	$(CC) $(OBJS) -o $(TARGET)

main.o: main.c math.h
	$(CC) $(CFLAGS) -c main.c

math.o: math.c math.h
	$(CC) $(CFLAGS) -c math.c

clean:
	rm -f $(OBJS) $(TARGET)