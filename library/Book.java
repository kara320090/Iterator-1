package library;

/**
 * Book 클래스
 * 도서의 고유 번호, 제목, 저자를 관리합니다.
 *
 * @author iteration#1 1팀
 * @version 2025.11.03
 */
public class Book {
    // 인스턴스 변수 - 도서 고유번호, 제목, 저자
    private String catalogueNumber;
    private String title;
    private String author;

    /**
     * Book 객체 생성자
     * 도서 정보를 초기화합니다.
     *
     * @param catalogueNumber  도서 고유번호
     * @param title            도서 제목
     * @param author           도서 저자
     */
    public Book(String catalogueNumber, String title, String author) {
        this.catalogueNumber = catalogueNumber;
        this.title = title;
        this.author = author;
    }

    /**
     * 도서 고유번호 반환
     *
     * @return catalogueNumber 문자열
     */
    public String getCatalogueNumber() { return catalogueNumber; }

    /**
     * 도서 제목 반환
     *
     * @return title 문자열
     */
    public String getTitle() { return title; }

    /**
     * 도서 저자명 반환
     *
     * @return author 문자열
     */
    public String getAuthor() { return author; }

    /**
     * 도서 정보를 문자열 형태로 반환합니다.
     * 형식: [번호] 제목 - 저자
     *
     * @return 도서 정보 문자열
     */
    @Override
    public String toString() {
        return "[" + catalogueNumber + "] " + title + " - " + author;
    }
}
