package collection;

import object.Book;
import object.Borrower;
import object.Loan;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * 대출/반납 등 작업에 사용하는 동작들이 들어있는 클래스.
 * 대출 기능을 수행하며 대출 기록을 저장한다.
 * 반납 기능을 가지고 있다.
 * 책의 상태(대출 가능 여부)에 따른 목록 출력 기능을 가지고 있다. 목록 번호 기준 오름차순 정렬로 출력한다.
 * 
 * @author (작성자 이름)
 * @version (2025.11.08)
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
        
        if(borrower.check()){
            Loan loan = new Loan(book, borrower);
            borrower.loanCount();
            loanDB.add(loan);
            System.out.println("대출이 완료되었습니다!");
            System.out.println("반납 예정일: " + loan.getReturnDate().getTime());
        }else if(!borrower.check()){
            System.out.println("대출 한도에 도달했습니다. 더는 대출할 수 없습니다.");
            System.out.println("책을 반납하신 이후 추가적으로 대출할 수 있습니다.");
        }
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
                temploan.getBorrower().returnCount();
                iterator.remove(); // 삭제
                System.out.println("반납이 완료되었습니다.");
                return;
            }
            else if(!iterator.hasNext()){
                System.out.println("해당 책은 대출중이 아닙니다.");
                return;
            }
        }
    }
    
    /** 대출 가능한 책 목록을 오름차순으로 출력하는 메소드이다.
     * 상태값 true로 대출 가능함을 의미한다.
     * 
     */
    public void showAvailableBookList(ArrayList<Book> books) {
        TreeSet<Book> sortedBooks = new TreeSet<>(books); // 재정의한 정렬기준 메소드로 자동 정렬된다. Book클래스의 compareTo(Book other) 메소드 확인하기.
    
        System.out.println("=== 대출 가능한 책 목록 ===");
        for (Book book : sortedBooks) {
            if (book.check()) {
                book.display();
            }
        }
        System.out.println("------------------------");
    }
    
    /** 대출 불가능한 책 목록을 오름차순으로 출력하는 메소드이다.
     * 상태값 false로 대출 불가능을 의미하며 대출 중임을 알 수 있도록 한다.
     * 예약이나 미소장 등 다양한 상황에 대한 맞춤이 아니므로 필요할 경우 이후 변경이 필요하다.
     */
    public void showUnavailableBookList(ArrayList<Book> books) {
        TreeSet<Book> sortedBooks = new TreeSet<>(books); // 재정의한 정렬기준 메소드로 자동 정렬된다. Book클래스의 compareTo(Book other) 메소드 확인하기.
    
        System.out.println("=== 대출 중인 책 목록 ===");
        for (Book book : sortedBooks) {
            if (!book.check()) {
                book.display();
            }
        }
        System.out.println("------------------------");
    }
    
    /** 책을 검색하는 메소드이다.
     * 기능 1. 책 목록을 대출가능, 불가능과 책 정보(제목,저자,고유번호)로 출력한다.
     * 기능 2. 검색할 책의 제목을 입력받고 bookDB에서 동일한 제목이 포함된 객체들을 가져온 후 책의 대출 여부와 정보(제목,저자,고유번호)를 출력한다.
     * 기능 3. 메인 메뉴로 돌아간다.
     */
    public void searchBook(){
        while(true){
        System.out.println("1. 전체 목록 출력");
        System.out.println("2. 바로 검색");
        System.out.println("3. 뒤로가기");
        System.out.print("선택하세요: ");
            
        int choice = scan.nextInt();
        scan.nextLine();//버퍼 제거
        switch(choice){
            case 1:
                System.out.println("-----도서관에서 보유중인 책 목록입니다.-----");
                for (Book book:bookDB.getBooks()){
                    System.out.print(book.check() ? "[대출 가능] " : "[대출 중] ");
                    book.display();
                }
                System.out.println("------------------------");
                break;
            case 2:
                System.out.print("검색할 책의 제목: ");
                String title = scan.nextLine();
                boolean find = false; //검색한 책을 찾으면 true, 못찾으면 false로 사용한다. 검색 완료 여부를 판단하기 위해 사용한다.
                System.out.println("-----검색 결과-----");
                for(Book book:bookDB.getBooks()){
                    if(book.getTitle().contains(title)){
                        System.out.print(book.check() ? "[대출 가능] " : "[대출 중] ");
                        book.display();
                        find=true;
                    }
                }
                if(!find){
                    System.out.println("해당 책은 없습니다.");
                }
                break;
            case 3:
                System.out.println("메인메뉴로 돌아갑니다.");
                return;
            default:
                System.out.println("잘못된 입력입니다.");
                break;
        }
        }
    }
}