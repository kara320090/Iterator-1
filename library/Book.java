package library;

/**
 * Book 클래스 - 도서 정보 관리
 *
 * @author iteration#1 1팀
 * @version (2025.11.03)
 */
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
