package library;

import java.util.ArrayList;

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