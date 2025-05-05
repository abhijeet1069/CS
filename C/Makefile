# Usage: make run FILE=src/chapterXX/your_file.c

CC := clang
CFLAGS := -Wall -Wextra -std=c11 -Iinclude

ifndef FILE
$(error Please specify a C file using FILE=src/chapterXX/your_file.c)
endif

REL_PATH := $(subst src/,,$(FILE:.c=))
OUT := build/$(REL_PATH)

# Extract chapter name for log
CHAPTER := $(word 1, $(subst /, ,$(REL_PATH)))
LOG := logs/$(CHAPTER).log

run: build_time $(OUT)
	@mkdir -p logs
	@{ \
		echo "========================================="; \
		echo "Program: $(FILE)"; \
		echo "Start:   $$(date '+%Y-%m-%d %H:%M:%S')"; \
		echo "----------------------------------------"; \
		T_START=$$(gdate +%s%3N); \
		$(OUT) >> $(LOG) 2>&1; \
		T_END=$$(gdate +%s%3N); \
		DIFF_MS=$$((T_END - T_START)); \
		echo "Execution time: $$DIFF_MS ms" >> $(LOG); \
		echo ""; \
	} >> $(LOG)

$(OUT): $(FILE)
	@mkdir -p $(dir $@)
	@echo "Compiling: $(FILE)"
	@$(CC) $(CFLAGS) -o $@ $<

build_time:
	@echo "---- Build at: $$(date '+%Y-%m-%d %H:%M:%S') ----"

clean:
	rm -rf build logs

.PHONY: run clean build_time