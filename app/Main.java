package app;

import java.util.Scanner;
import DataBase.LibDB;
import myClass.Book;
import myClass.Borrower;
import Loan.LoanMap;
import Usecase.*;
 
/**
 * Main 클래스 (UI)
 *
 * 도서관 시스템의 시작점이다.
 * 초기 데이터(Seed)를 로딩하고 사용자 메뉴를 통해
 * 기능을 선택하여 유스케이스 클래스를 실행한다.
 */
public class Main
{
    private static LibDB<Book> bookDB = new LibDB<Book>();
    private static LibDB<Borrower> borrowerDB = new LibDB<Borrower>();
    private static LoanMap loanMap = new LoanMap();

    public static void main(String[] args)
    {
        seedData();
        Scanner sc = new Scanner(System.in);

        while (true) {
            printMenu();
            System.out.print("번호 입력: ");
            String input = sc.nextLine().trim();

            if (input.equals("0")) { System.out.println("종료"); break; }
            else if (input.equals("1")) new AddUser(borrowerDB).addUser();
            else if (input.equals("2")) new AddBook(bookDB).addBook();
            else if (input.equals("3")) new LoanBook(bookDB, borrowerDB, loanMap).loanBook();
            else if (input.equals("4")) new ReturnBook(bookDB, loanMap).returnBook();
            else if (input.equals("5")) new ShowLoanedBooks(bookDB, loanMap).showSortedList();
            else if (input.equals("6")) new ShowAvailableBooks(bookDB, loanMap).showSortedList();
            else System.out.println("잘못된 번호");
        }
    }

    private static void printMenu()
    {
        System.out.println("\n==== 도서관 시스템 ====");
        System.out.println("1. 이용자 등록");
        System.out.println("2. 도서 등록");
        System.out.println("3. 도서 대출");
        System.out.println("4. 도서 반납");
        System.out.println("5. 대출중 도서 보기");
        System.out.println("6. 대출가능 도서 보기");
        System.out.println("0. 종료");
    }

    /**
     * 초기 Seed 데이터 주입
     * 실제 파일 대신 테스트 객체 사용
     */
    private static void seedData()
    {
        bookDB.add(new Book("B001", "해리포터", "조앤롤링"));
        bookDB.add(new Book("B002", "데미안", "헤르만헤세"));
        borrowerDB.add(new Borrower("U001", "김철수"));
        borrowerDB.add(new Borrower("U002", "이영희"));
    }
}
