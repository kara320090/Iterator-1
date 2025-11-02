package Print;
import java.util.*;
import model.Book;
import model.Borrower;

public class UnborrowAble implements BookListPrint {
    private final Map<Borrower, List<Book>> loanDB;

    public UnborrowAble(Map<Borrower, List<Book>> loanDB) {
        this.loanDB = loanDB;
    }
    @Override
    public void print() {
        System.out.println("== UnborrowAble (대출 중 목록) ==");
        Set<Book> printed = new HashSet<>();
        for (Map.Entry<Borrower, List<Book>> e : loanDB.entrySet())
            for (Book b : e.getValue())
                if (printed.add(b)) System.out.println(b);
        System.out.println();
    }
}
