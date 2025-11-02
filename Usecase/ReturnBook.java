package Usecase;

import java.util.Scanner;
import java.util.Iterator;
import DataBase.LibDB;
import myClass.Book;
import Loan.LoanMap;

/**
 * ReturnBook 클래스
 * 
 * 책 1권을 반납 처리한다.
 * 입력: 도서 ID(Bxxx)
 * 처리: LoanMap에서 삭제 → 책 상태 "대출가능"
 */
public class ReturnBook
{
    private LibDB<Book> bookDB;
    private LoanMap loanMap;

    /**
     * 생성자
     */
    public ReturnBook(LibDB<Book> bookDB, LoanMap loanMap)
    {
        this.bookDB = bookDB;
        this.loanMap = loanMap;
    }

    /**
     * 반납 절차 수행
     */
    public void returnBook()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("반납할 도서 ID(Bxxx): ");
        String bookId = sc.nextLine().trim();

        // 도서 존재 확인
        Book targetBook = null;
        Iterator<Book> it = bookDB.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (b.getID().equals(bookId)) { targetBook = b; break; }
        }
        if (targetBook == null) {
            System.out.println("[오류] 해당 도서를 찾을 수 없습니다.");
            return;
        }

        // 대출중인지 확인
        if (!loanMap.isLoaned(bookId)) {
            System.out.println("[거절] 대출중이 아닌 도서입니다.");
            return;
        }

        // 반납 처리 (LoanMap에서 key 삭제)
        if (loanMap.returnBook(bookId)) {
            targetBook.setStatus("대출가능");
            System.out.println("[반납 완료] " + bookId);
        } else {
            System.out.println("[오류] 반납 처리 실패");
        }
    }
}
