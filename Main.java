import java.util.Scanner;
import model.*;
import database.*;
import function.*;

/**
 * Main 클래스
 * 
 * 프로그램의 진입점. 메뉴를 통해 이용자 등록, 도서 대출, 대출 가능 도서 조회 기능을 제공한다.
 */
public class Main {
    public static void main(String[] args) {
        Library library = new Library("성균관도서관");
        LibDB<Borrower> borrowerDB = new LibDB<Borrower>();
        LoanMap loanMap = new LoanMap();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n===== " + library.getName() + " 시스템 =====");
            System.out.println("1. 새로운 이용자 등록");
            System.out.println("2. 책 대출");
            System.out.println("3. 대출 가능한 책 목록");
            System.out.println("4. 전체 도서 목록 보기");
            System.out.println("0. 종료");
            System.out.print("선택: ");
            String sel = sc.nextLine();

            if (sel.equals("0")) break;
            switch (sel) {
                case "1": AddUser.run(borrowerDB, sc); break;
                case "2": LoanBook.run(library.getBooks(), borrowerDB, loanMap, sc); break;
                case "3": ShowAvailableBooks.run(library.getBooks(), loanMap); break;
                case "4": library.printAllBooks(); break;
                default : System.out.println("잘못된 입력입니다.");
            }
        }

        System.out.println("프로그램 종료");
    }
}