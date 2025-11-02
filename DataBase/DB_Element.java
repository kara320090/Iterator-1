package DataBase;

/**
 * DB_Element 클래스
 * 
 * 도서와 이용자 객체가 공통으로 가져야 하는 getID() 메소드를
 * 강제하기 위한 추상 부모 클래스이다.
 * 모든 데이터 엔티티(Book, Borrower)는 이 클래스를 상속받는다.
 *
 * @author (PBL#1)
 * @version (2025.11.02)
 */
public abstract class DB_Element
{
    /**
     * 각 요소의 고유 ID를 반환하는 메소드
     * @return 고유번호(String)
     */
    public abstract String getID();
}
