# Object Orientation Abusers

## Temporary Field

A Temporary Field is a field (usually an instance variable) that is only set or used in a few specific situations — 
often only during one method. This can clutter your class and make it harder to maintain. 
It’s better to keep such data local (e.g., as a method variable) or extract it into a helper class if multiple temporary fields are used together.

```java
// bad : header and footer are only used once in printSummaryReport(), why are we unnecessarily creating state? 
public class ReportPrinter {
    private String header;
    private String footer;

    public void printSummaryReport() {
        header = "Summary Report";
        footer = "End of Summary";

        System.out.println(header);
        System.out.println("Summary content here...");
        System.out.println(footer);
    }

    public void printDetailedReport() {
        System.out.println("Detailed Report");
        System.out.println("Lots of detailed content...");
    }
}

//good : making it local to printSummaryReport()
public class ReportPrinter {

    public void printSummaryReport() {
        String header = "Summary Report";
        String footer = "End of Summary";

        System.out.println(header);
        System.out.println("Summary content here...");
        System.out.println(footer);
    }

    public void printDetailedReport() {
        System.out.println("Detailed Report");
        System.out.println("Lots of detailed content...");
    }
}
```
