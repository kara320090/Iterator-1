package function;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
import library.*;

public class ShowAvailableBooks {
    public static void run(ArrayList<Book> books, HashSet<String> loanedBooks) {
        TreeSet<String> available = new TreeSet<String>();

        for (Book b : books) {
            if (!loanedBooks.contains(b.getCatalogueNumber())) {
                available.add(b.toString());
            }
        }

        System.out.println("[대출 가능한 도서 목록]");
        for (String s : available) {
            System.out.println(s);
        }
    }
}