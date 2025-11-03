package model;

/**
 * Borrower 클래스
 * 
 * 각 이용자는 고유한 이름(id)과 실제 이름(name)을 가진다.
 * 도서 대출 시 식별자로 사용된다.
 *
 * @author (PBL#1)
 * @version (2025.11.03)
 */
public class Borrower {
    private String id;
    private String name;

    public Borrower(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getID() { return id; }
    public String getName() { return name; }

    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }
}