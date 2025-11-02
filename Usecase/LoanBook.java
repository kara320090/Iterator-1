package Usecase;

import java.util.Scanner;
import java.util.Iterator;
import DataBase.LibDB;
import myClass.Book;
import myClass.Borrower;
import Loan.LoanMap;

/**
 * LoanBook 클래스
 * 
 * 책 1권을 이용자에게 대출한다.
 * 입력: 도서 ID(Bxxx), 이용자 ID(Uxxx)
 * 처리: 대출중 여부 확인 → LoanMap에 기록 → 책 상태 "대출중"
 */
public class LoanBook
{
    private LibDB<Book> bookDB;
    private LibDB<Borrower> borrowerDB;
    private LoanMap loanMap;

    /**
     * 생성자
     */
    public LoanBook(LibDB<Book> bookDB, LibDB<Borrower> borrowerDB, LoanMap loanMap)
    {
        this.bookDB = bookDB;
        this.borrowerDB = borrowerDB;
        this.loanMap = loanMap;
    }

    /**
     * 대출 절차 수행
     */
    public void loanBook()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("대출할 도서 ID(Bxxx): ");
        String bookId = sc.nextLine().trim();

        System.out.print("대출자 ID(Uxxx): ");
        String borrowerId = sc.nextLine().trim();

        // 도서/이용자 존재 확인 (iterator + while)
        Book targetBook = null;
        Iterator<Book> bit = bookDB.iterator();
        while (bit.hasNext()) {
            Book b = bit.next();
            if (b.getID().equals(bookId)) { targetBook = b; break; }
        }
        if (targetBook == null) {
            System.out.println("[오류] 해당 도서를 찾을 수 없습니다.");
            return;
        }

        Borrower targetUser = null;
        Iterator<Borrower> uit = borrowerDB.iterator();
        while (uit.hasNext()) {
            Borrower u = uit.next();
            if (u.getID().equals(borrowerId)) { targetUser = u; break; }
        }
        if (targetUser == null) {
            System.out.println("[오류] 해당 이용자를 찾을 수 없습니다.");
            return;
        }

        // 이미 대출중인지 확인 (LoanMap 기준)
        if (loanMap.isLoaned(bookId)) {
            System.out.println("[거절] 이미 대출 중인 도서입니다.");
            return;
        }

        // 대출 처리
        if (loanMap.loan(bookId, borrowerId)) {
            targetBook.setStatus("대출중");
            System.out.println("[대출 완료] " + bookId + " → " + borrowerId);
        } else {
            System.out.println("[오류] 대출 처리 실패");
        }
    }
}