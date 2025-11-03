package library;

/**
 * Borrower 클래스
 * 도서관 이용자의 ID와 이름 정보를 관리합니다.
 *
 * @author iteration#1 1팀
 * @version 2025.11.03
 */
public class Borrower {
    // 인스턴스 변수 - 이용자 ID와 이름
    private String id;
    private String name;

    /**
     * Borrower 객체 생성자
     * 이용자의 ID와 이름을 초기화합니다.
     *
     * @param id    이용자 ID
     * @param name  이용자 이름
     */
    public Borrower(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /**
     * 이용자 ID 반환
     *
     * @return 이용자 ID 값
     */
    public String getID() { return id; }

    /**
     * 이용자 이름 반환
     *
     * @return 이용자 이름 값
     */
    public String getName() { return name; }

    /**
     * 객체 정보를 문자열 형태로 반환합니다.
     * 형식: [id] name
     *
     * @return 이용자 정보를 문자열로 반환
     */
    @Override
    public String toString() {
        return "[" + id + "] " + name;
    }

    /**
     * hashCode 메소드
     * 이용자 ID를 기반으로 해시값을 생성합니다.
     *
     * @return ID 기반 해시코드 값
     */
    @Override
    public int hashCode() { return id.hashCode(); }

    /**
     * equals 메소드
     * 두 Borrower 객체의 ID가 동일한지 비교합니다.
     *
     * @param obj 비교할 객체
     * @return ID가 동일하면 true, 아니면 false
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Borrower other = (Borrower) obj;
        return id.equals(other.id);
    }
}
