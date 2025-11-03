package model;

import java.util.ArrayList;

/**
 * Library 클래스
 * 
 * 도서관의 이름(name)과 여러 도서(Book) 객체를 관리한다.
 * 도서관은 ArrayList<Book>을 통해 여러 도서를 집약(aggregation) 관계로 보유한다.
 * 도서관이 사라져도 Book 객체는 독립적으로 존재할 수 있다.
 */
public class Library {
    private String name;
    private ArrayList<Book> books = new ArrayList<Book>();

    public Library(String name) {
        this.name = name;
        initializeBooks();
    }

    private void initializeBooks() {
        books.add(new Book("B01", "Java Programming", "홍길동"));
        books.add(new Book("B02", "Software Analysis and Design", "profsHwang"));
        books.add(new Book("B03", "명품 자바프로그래밍", "황기태"));
        books.add(new Book("B04", "소프트웨어테스트", "profsHwang"));
    }

    public ArrayList<Book> getBooks() { return books; }
    public String getName() { return name; }

    public void printAllBooks() {
        System.out.println("📚 " + name + "의 도서 목록");
        for (Book b : books) {
            System.out.println(b);
        }
    }
}