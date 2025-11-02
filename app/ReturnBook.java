package app;
import java.util.*;
import model.Book;
import model.Borrower;

public class ReturnBook {
    private final Map<Borrower, List<Book>> loanDB;
    public ReturnBook(Map<Borrower, List<Book>> loanDB) { this.loanDB = loanDB; }
    public void returnBook(Borrower user, Book book) {
        List<Book> list = loanDB.get(user);
        if (list == null || !list.remove(book)) {
            System.out.println("[오류] 반납 실패 (기록 없음) user=" + user + ", book=" + book);
            return;
        }
        System.out.println("[반납] " + user + " <- " + book);
        if (list.isEmpty()) loanDB.remove(user);
    }
}
