import java.util.Scanner;
import java.util.HashSet;
import library.*;
import function.*;

/**
 * 도서관 시스템 실행 및 메뉴 처리를 담당합니다.
 *
 * @author iteration#1 1팀
 * @version 2025.11.03
 */
public class Main {
    public static void main(String[] args) {
        // 도서관 객체 생성
        Library library = new Library("도서관");

        // 이용자 목록 및 대출 내역 관리
        HashSet<Borrower> borrowerSet = new HashSet<Borrower>();
        HashSet<String> loanedBooks = new HashSet<String>();

        // 사용자 입력
        Scanner sc = new Scanner(System.in);

        // 메인 메뉴 루프
        while (true) {
            System.out.println("\n===== " + library.getName() + " 시스템 =====");
            System.out.println("1. 새로운 이용자 등록");
            System.out.println("2. 책 대출");
            System.out.println("3. 대출 가능한 책 목록");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            String sel = sc.nextLine();

            if (sel.equals("0")) break;

            switch (sel) {
                case "1": AddUser.run(borrowerSet, sc); break;
                case "2": LoanBook.run(library.getBooks(), borrowerSet, loanedBooks, sc); break;
                case "3": ShowAvailableBooks.run(library.getBooks(), loanedBooks); break;
                default : System.out.println("잘못된 입력입니다.");
            }
        }

        System.out.println("프로그램 종료");
    }
}
