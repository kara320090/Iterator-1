package function;

import java.util.ArrayList;
import model.*;
import database.*;

/**
 * ShowAvailableBooks 클래스
 * 
 * 대출 가능한 도서를 화면에 출력한다.
 */
public class ShowAvailableBooks {
    public static void run(ArrayList<Book> books, LoanMap loanMap) {
        System.out.println("[대출 가능한 도서 목록]");
        for (Book b : books) {
            if (!loanMap.isLoaned(b.getCatalogueNumber())) {
                System.out.println(b);
            }
        }
    }
}