package Print;
import java.util.*;
import model.Book;
import model.Borrower;

public class LoanAble implements BookListPrint {
    private final List<Book> allBooks;
    private final Map<Borrower, List<Book>> loanDB;

    public LoanAble(List<Book> allBooks, Map<Borrower, List<Book>> loanDB) {
        this.allBooks = allBooks;
        this.loanDB = loanDB;
    }
    private boolean isLoaned(Book b) {
        for (List<Book> list : loanDB.values())
            if (list.contains(b)) return true;
        return false;
    }
    @Override
    public void print() {
        System.out.println("== LoanAble (대출 가능 목록) ==");
        for (Book b : allBooks)
            if (!isLoaned(b)) System.out.println(b);
        System.out.println();
    }
}
