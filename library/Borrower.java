package library;

/**
 * Borrower 클래스 - 도서 이용자 정보 관리
 *
 * @author iteration#1 1팀
 * @version 2025.11.03
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

    @Override
    public int hashCode() { return id.hashCode(); }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Borrower other = (Borrower) obj;
        return id.equals(other.id);
    }
}