package library;

import java.util.ArrayList;

/**
 * Library 클래스 - 도서관 이름 및 보유 도서 관리
 *
 * @author iteration#1 1팀
 * @version (2025.11.03)
 */
public class Library {
    private String name;
    private ArrayList<Book> books = new ArrayList<Book>();

    public Library(String name) {
        this.name = name;
        initializeBooks();
    }

    // 기본 도서 목록 초기화
    private void initializeBooks() {
        books.add(new Book("B01", "Java Programming", "홍길동"));
        books.add(new Book("B02", "Software Analysis and Design", "profsHwang"));
        books.add(new Book("B03", "명품 자바프로그래밍", "황기태"));
        books.add(new Book("B04", "소프트웨어테스트", "profsHwang"));
    }

    public ArrayList<Book> getBooks() { return books; }
    public String getName() { return name; }
}