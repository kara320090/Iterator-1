
/**
 * Book 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class Book {
    private String title;
    private String author;
    private int bookID;

    public Book(String title, String author, int bookID) {
        this.title = title;
        this.author = author;
        this.bookID = bookID;
    }

    public int getBookID() {
        return bookID;
    }

    @Override
    public String toString() {
        return "[Book] " + bookID + " / " + title + " / " + author;
    }
}