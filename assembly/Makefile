# Usage: make run CFILE=your_file.c

CC     := clang
CFLAGS := -Wall -Wextra -O2
CFILE  ?= main.c
EXE    := a.out
LOG    := run.log

.PHONY: run build clean

run: build
	@echo "=========================================" >> $(LOG)
	@echo "Program: $(CFILE)"                       >> $(LOG)
	@echo "Start:   $$(date '+%Y-%m-%d %H:%M:%S')" >> $(LOG)
	@echo "----------------------------------------" >> $(LOG)
	@./$(EXE) >> $(LOG) 2>&1
	@echo >> $(LOG)

build:
	$(CC) $(CFLAGS) $(CFILE) -o $(EXE)

clean:
	rm -f $(EXE) $(LOG)

asm:
	$(CC) -arch arm64 -S -O0 $(CFILE) -o asm_file.s 