package library;

public class Book {
    private String catalogueNumber;
    private String title;
    private String author;

    public Book(String catalogueNumber, String title, String author) {
        this.catalogueNumber = catalogueNumber;
        this.title = title;
        this.author = author;
    }

    public String getCatalogueNumber() { return catalogueNumber; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }

    @Override
    public String toString() {
        return "[" + catalogueNumber + "] " + title + " - " + author;
    }
}