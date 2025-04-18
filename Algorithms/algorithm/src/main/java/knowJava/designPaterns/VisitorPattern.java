package knowJava.designPaterns;

import java.util.Objects;

// 1️⃣ Element Interface (Accepts Visitors)
interface LibraryItem {
    void accept(LibraryVisitor visitor);
}

// 2️⃣ Concrete Elements (Objects we operate on)
class Book implements LibraryItem {
    private int pageCount;

    public Book(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void accept(LibraryVisitor visitor) {
        visitor.visit(this);
    }
}

class AudioBook implements LibraryItem {
    private int durationInMinutes;

    public AudioBook(int durationInMinutes) {
        this.durationInMinutes = durationInMinutes;
    }

    public int getDuration() {
        return durationInMinutes;
    }

    public void accept(LibraryVisitor visitor) {
        visitor.visit(this);
    }
}

// 3️⃣ Visitor Interface (Defines Operations)
interface LibraryVisitor {
    void visit(Book book);
    void visit(AudioBook audioBook);
}

// 4️⃣ Concrete Visitor (Performs Operation)
class TimeCalculator implements LibraryVisitor {
    public void visit(Book book) {
        int readingTime = book.getPageCount() * 2; // Assume 2 min per page
        System.out.println("Estimated reading time: " + readingTime + " minutes.");
    }

    public void visit(AudioBook audioBook) {
        System.out.println("Audiobook duration: " + audioBook.getDuration() + " minutes.");
    }
}

// 5️⃣ Using the Pattern
public class VisitorPattern {
    public static void main(String[] args) {
        LibraryItem book = new Book(100);
        LibraryItem audioBook = new AudioBook(200);

        LibraryVisitor visitor = new TimeCalculator();

        book.accept(visitor);        // Output: Estimated reading time: 200 minutes.
        audioBook.accept(visitor);   // Output: Audiobook duration: 200 minutes.

    }
}
