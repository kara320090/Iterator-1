package myClass;

import DataBase.DB_Element;

/**
 * Borrower 클래스
 * 
 * 도서관 이용자 정보를 저장하는 엔티티 클래스이다.
 */
public class Borrower extends DB_Element
{
    private String id;
    private String name;

    /**
     * Borrower 생성자
     * @param id 이용자 고유번호
     * @param name 이름
     */
    public Borrower(String id, String name)
    {
        this.id = id;
        this.name = name;
    }

    public String getID() { return id; }
    public String getName() { return name; }
}