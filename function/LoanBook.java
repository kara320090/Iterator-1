package function;

import java.util.Scanner;
import java.util.ArrayList;
import model.*;
import database.*;

/**
 * LoanBook 클래스
 * 
 * 도서 대출 기능을 담당한다.
 */
public class LoanBook {
    public static void run(ArrayList<Book> books, LibDB<Borrower> borrowerDB, LoanMap loanMap, Scanner sc) {
        System.out.print("도서 catalogueNumber: ");
        String catalogueNumber = sc.nextLine();
        System.out.print("이용자 ID: ");
        String borrowerId = sc.nextLine();

        if (loanMap.isLoaned(catalogueNumber)) {
            System.out.println("[대출 실패] 이미 대출 중입니다.");
            return;
        }

        loanMap.loan(catalogueNumber, borrowerId);
        System.out.println("[대출 완료] " + catalogueNumber + " → " + borrowerId);
    }
}