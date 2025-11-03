package function;

import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;
import library.*;

/**
 * LoanBook 클래스 - 도서 대출 처리
 *
 * @author iteration#1 1팀
 * @version (2025.11.03)
 */
public class LoanBook {
    public static void run(ArrayList<Book> books, HashSet<Borrower> borrowerSet, HashSet<String> loanedBooks, Scanner sc) {
        System.out.print("도서 catalogueNumber: ");
        String catalogueNumber = sc.nextLine();
        System.out.print("이용자 ID: ");
        String borrowerId = sc.nextLine();

        boolean borrowerExists = false;
        for (Borrower b : borrowerSet) {
            if (b.getID().equals(borrowerId)) {
                borrowerExists = true;
                break;
            }
        }
        if (!borrowerExists) {
            System.out.println("[오류] 등록되지 않은 이용자입니다.");
            return;
        }

        boolean bookExists = false;
        for (Book b : books) {
            if (b.getCatalogueNumber().equals(catalogueNumber)) {
                bookExists = true;
                break;
            }
        }
        if (!bookExists) {
            System.out.println("[오류] 존재하지 않는 도서입니다.");
            return;
        }

        if (loanedBooks.contains(catalogueNumber)) {
            System.out.println("[대출 실패] 이미 대출 중입니다.");
        } else {
            loanedBooks.add(catalogueNumber);
            System.out.println("[대출 완료] " + catalogueNumber + " → " + borrowerId);
        }
    }
}