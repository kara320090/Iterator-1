package model;

/**
 * Book 클래스
 * 
 * 각 도서는 고유한 분류번호(catalogueNumber), 제목(title), 저자(author)를 가진다.
 * Library 클래스에 집약(aggregation) 관계로 포함된다.
 *
 * @author (PBL#1)
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