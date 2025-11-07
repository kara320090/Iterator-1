import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * 대출 작업에 사용하는 동작들이 들어있는 클래스.
 * 
 * @author (작성자 이름)
 * @version (2025.11.05)
 */
public class LoanCollection {
    
    private Scanner scan;
    private BookCollection bookDB;
    private BorrowerCollection userDB;
    private ArrayList<Loan> loanDB;

    /** LoanCollection 클래스의 객체 생성자
     * 
     */
    public LoanCollection(Scanner scan, BookCollection bookDB, BorrowerCollection userDB) {
        this.scan = scan;
        this.bookDB = bookDB;
        this.userDB = userDB;
        this.loanDB = new ArrayList<>();
    }

    /** 책 대출 기능을 수행하는 메소드이다.
     * 책의 고유번호와 이용자의 고유번호를 입력받아 대출 가능한 경우 Loan 객체를 생성하고 리스트에 저장한다.
     */
    public void loan() {
        System.out.print("대출할 책의 고유번호: ");
        String catalogueNumber = scan.nextLine();
        Book book = bookDB.findBookCatalogueNumber(catalogueNumber);

        if (book == null) {
            System.out.println("해당 책을 찾을 수 없습니다.");
            return;
        }

        if (!book.check()) {
            System.out.println("해당 책은 현재 대출 중입니다.");
            return;
        }

        System.out.print("이용자의 고유번호: ");
        int borrowerNumber = Integer.parseInt(scan.nextLine());
        Borrower borrower = userDB.findBorrowerNumber(borrowerNumber);

        if (borrower == null) {
            System.out.println("해당 이용자를 찾을 수 없습니다.");
            return;
        }

        Loan loan = new Loan(book, borrower);
        loanDB.add(loan);

        System.out.println("대출이 완료되었습니다!");
        System.out.println("반납 예정일: " + loan.getReturnDate().getTime());
    }
    
    /** 책 반납 기능을 수행하는 메소드
     * 
     */
    public void returnBook() {
        System.out.print("반납할 책의 고유번호: ");
        String catalogueNumber = scan.nextLine();
        Iterator<Loan> iterator = loanDB.iterator();
        while (iterator.hasNext()) {
            Loan temploan = iterator.next();
            if (temploan.getBook().getCatalogueNumber().equals(catalogueNumber)) {
                temploan.getBook().changeStatus(true);
                iterator.remove(); // 삭제
                System.out.println("반납이 완료되었습니다.");
                return;
            }
        }
        System.out.println("해당 책은 대출중이 아닙니다.");
    }
    
    /** 대출 가능한 책 목록을 오름차순으로 출력하는 메소드이다.
     * 상태값 true로 대출 가능함을 의미한다.
     * 
     */
    public void showAvailableBookList(ArrayList<Book> books) {
        TreeSet<Book> sortedBooks = new TreeSet<>(books); // 자동 정렬됨
    
        System.out.println("=== 대출 가능한 책 목록 ===");
        for (Book book : sortedBooks) {
            if (book.check()) {
                book.display();
                System.out.println("------------------------");
            }
        }
    }
    
    /** 대출 불가능한 책 목록을 오름차순으로 출력하는 메소드이다.
     * 상태값 false로 대출 불가능을 의미하며 대출 중임을 알 수 있도록 한다.
     * 예약이나 미소장 등 다양한 상황에 대한 맞춤이 아니므로 필요할 경우 이후 변경이 필요하다.
     */
    public void showUnavailableBookList(ArrayList<Book> books) {
        TreeSet<Book> sortedBooks = new TreeSet<>(books); // 자동 정렬됨
    
        System.out.println("=== 대출 중인 책 목록 ===");
        for (Book book : sortedBooks) {
            if (!book.check()) {
                book.display();
                System.out.println("------------------------");
            }
        }
    }
}