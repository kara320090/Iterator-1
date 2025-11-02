package app;
import java.util.*;
import model.Book;
import model.Borrower;

public class LoanBook {
    private final Map<Borrower, List<Book>> loanDB;
    public LoanBook(Map<Borrower, List<Book>> loanDB) { this.loanDB = loanDB; }
    public void borrow(Borrower user, Book book) {
        for (List<Book> list : loanDB.values())
            if (list.contains(book)) { System.out.println("[불가] 이미 대출 중: " + book); return; }
        loanDB.computeIfAbsent(user, k -> new ArrayList<>()).add(book);
        System.out.println("[대출] " + user + " -> " + book);
    }
}
