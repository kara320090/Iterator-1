package library;

import java.util.ArrayList;

/**
 * Library 클래스
 * 도서관 이름과 보유 도서 목록을 관리합니다.
 *
 * @author iteration#1 1팀
 * @version 2025.11.03
 */
public class Library {
    // 인스턴스 변수 - 도서관 이름 및 도서 목록
    private String name;
    private ArrayList<Book> books = new ArrayList<Book>();

    /**
     * Library 생성자
     * 도서관 이름을 설정하고 초기 도서 목록을 구성합니다.
     *
     * @param name  도서관 이름
     */
    public Library(String name) {
        this.name = name;
        initializeBooks();
    }

    /**
     * 초기 도서 목록을 생성합니다.
     * 내부적으로 Book 객체를 ArrayList에 추가합니다.
     *
     * @return 없음
     */
    private void initializeBooks() {
        books.add(new Book("B01", "Java Programming", "홍길동"));
        books.add(new Book("B02", "Software Analysis and Design", "profsHwang"));
        books.add(new Book("B03", "명품 자바프로그래밍", "황기태"));
        books.add(new Book("B04", "소프트웨어테스트", "profsHwang"));
    }

    /**
     * 도서 목록을 반환합니다.
     *
     * @return 보유 중인 도서 리스트 (ArrayList<Book>)
     */
    public ArrayList<Book> getBooks() { return books; }

    /**
     * 도서관 이름을 반환합니다.
     *
     * @return 도서관 이름 문자열
     */
    public String getName() { return name; }
}