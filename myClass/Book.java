package myClass;

import DataBase.DB_Element;

/**
 * Book 클래스
 * 
 * 도서 정보를 저장하는 엔티티 클래스이다.
 * 상태값(status)을 통해 대출 가능 여부를 관리한다.
 */
public class Book extends DB_Element
{
    private String id;
    private String title;
    private String author;
    private String status; // "대출가능" / "대출중"

    /**
     * Book 생성자
     * @param id 고유번호
     * @param title 제목
     * @param author 저자
     */
    public Book(String id, String title, String author)
    {
        this.id = id;
        this.title = title;
        this.author = author;
        this.status = "대출가능";
    }

    public String getID() { return id; }
    public String getTitle() { return title; }
    public String getAuthor() { return author; }
    public String getStatus() { return status; }

    /**
     * 상태 변경 메소드
     * @param status "대출가능" 또는 "대출중"
     */
    public void setStatus(String status) {
        this.status = status;
    }
}
