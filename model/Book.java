package model;
import java.util.Objects;

public class Book {
    private final String title;
    private final String author;
    private final int bookID;

    public Book(String title, String author, int bookID) {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
    }

    public int getBookID() { return bookID; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return "[Book] " + bookID + " / " + title + " / " + author;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        return bookID == ((Book)o).bookID;
    }

    @Override
    public int hashCode() { return Objects.hash(bookID); }
}
