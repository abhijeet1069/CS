# Object Orientation Abusers

## Switch statements

The main symptom is you have a complex switch operator or a sequence of if statements.

## Solution

### Replace Type Code with State/Strategy

```java

//problem : switch will fan out
class Program {
    int mode; // 0 = Normal, 1 = Debug

    void run() {
        switch(mode) {
            case 0: runNormal(); break;
            case 1: runDebug(); break;
        }
    }
}

//better : The NormalMode and DebugMode mode can indvidually fan out, instead of only Program fanning out.
interface RuntimeMode {
    void run();
}

class NormalMode implements RuntimeMode {
    public void run() { /* normal behavior */ }
}

class DebugMode implements RuntimeMode {
    public void run() { /* debug behavior */ }
}

class Program {
    RuntimeMode mode;

    void run() {
        mode.run();
    }

    void setMode(RuntimeMode newMode) {
        this.mode = newMode;
    }
}

```

### Replace Parameter with Explicit methods

```java
// bad : The client needs to pass code of format
class Printer {
    void print(int format) {
        switch (format) {
            case 0: printReport("PDF"); break;
            case 1: printReport("DOCX"); break;
            case 2: printReport("TXT"); break;
        }
    }

    private void printReport(String type) {
        System.out.println("Printing in format: " + type);
    }
}

//good : client can call the method directly. No need for wierd codes.
class Printer {
    void printPDF() {
        printReport("PDF");
    }

    void printDOCX() {
        printReport("DOCX");
    }

    void printTXT() {
        printReport("TXT");
    }

    private void printReport(String type) {
        System.out.println("Printing in format: " + type);
    }
}

```

## When to ignore

When a switch operator performs simple actions, there is no reason to make code changes
