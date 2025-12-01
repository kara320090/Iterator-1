import java.util.Iterator;
/**
 * LibraryApplication 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class LibraryApplication 
{
    private String libraryName;
    private BorrowerDB borrowerDB;
    private BookDB bookDB;

    private LoanDB loanDB;
    private HisDB hisDB;
    
    public LibraryApplication(String name){
        this.libraryName = name;
        this.borrowerDB = new BorrowerDB();
        this.bookDB = new BookDB();
        this.loanDB = new LoanDB();
        this.hisDB = new HisDB();
    }
    
    // UC#1 : 이용자 등록
    public String registerOneBorrower(String name, int number){
        Borrower user = new Borrower(name, number);
        borrowerDB.add(user);
        return "이용자(" + name + ") 등록작업을 완료하였습니다.";
    }
    
    // UC#2 : 책 등록
    public String registerOneBook(String title, String author, int catalogueNumber){
        Book book = new Book(title, author, catalogueNumber);
        bookDB.add(book);
        return "책(" + title + ", " + author + ", " + catalogueNumber + ") 등록작업을 완료하였습니다.";
    }
    
    // UC#3 : 대출가능한 책 목록 Display
    public String displayBookForLoan(){
        String result = "=== 대출 가능한 책 목록 ===\n";

        Iterator<Book> it = bookDB.iterator();

        while(it.hasNext()){
            Book book = it.next();
            if (Boolean.TRUE.equals(book.getState())) {
                result = result + book.toString() + "\n";
            }
        }

        // 제목 줄만 있다면 → 아무것도 출력된 것이 없음
        if(result.equals("=== 대출 가능한 책 목록 ===\n")){
            result = result + "현재 대출 가능한 책이 없습니다.\n";
        }

        return result + "대출가능한 책 목록을 Display하였습니다.";
    }
    
    // UC#4 : 대출중인 책 목록 Display
    public String displayBookOnLoan(){
        String result = "=== 대출 중인 책 목록 ===\n";

        Iterator<Book> it = bookDB.iterator();

        while(it.hasNext()){
            Book book = it.next();
            if (Boolean.FALSE.equals(book.getState())) {
                result = result + book.toString() + "\n";
            }
        }

        if(result.equals("=== 대출 중인 책 목록 ===\n")){
            result = result + "현재 대출 중인 책이 없습니다.\n";
        }

        return result;
    }
    
    // UC#5 : 책 1권 대출
    public String loanOneBook(int number, int catalogueNumber){

        Borrower borrower = borrowerDB.findBorrower(number);
        if(borrower == null){
            return "[오류] 이용자 " + number + " 없음.";
        }

        Book book = bookDB.findBook(catalogueNumber);
        if(book == null){
            return "[오류] 책 " + catalogueNumber + " 없음.";
        }

        if(!borrower.countCheck()){
            return "[오류] 이용자 대출 가능 권수 초과.";
        }

        if(Boolean.FALSE.equals(book.getState())){
            return "[오류] 이미 대출 중인 책: " + book.toString();
        }

        Loan loan = new Loan(book, borrower);
        loanDB.registerOneLoan(loan);
        borrower.bookLoanCount();

        return "대출 완료: " + borrower.toString() + " → " + book.toString();
    }

    
        // ------------------------------------------------------
    // UC#6 : 책 반납 (iterator)
    // ------------------------------------------------------
    public String returnOneBook(int catalogueNumber){

        Loan loan = null;
        Iterator<Loan> it = loanDB.iterator();

        while(it.hasNext()){
            Loan temp = it.next();
            if(temp.getBook().getCatalogueNumber() == catalogueNumber){
                loan = temp;
                break;
            }
        }

        if(loan == null){
            return "[오류] 책 " + catalogueNumber + " 은(는) 대출 중이 아님.";
        }

        Borrower borrower = loan.getBorrower();
        Book book = loan.getBook();

        History history = new History(loan);
        hisDB.RegisterOneHis(history);

        borrower.returnCount();
        book.changeStatus(true);
        loanDB.removeLoan(loan);

        return "반납 완료: " + borrower.toString() + " → " + book.toString();
    }
    public String displayReturnHistory(int number){

        Iterator<History> it = hisDB.iterator();

        while(it.hasNext()){
            History h = it.next();
            if(h.getLoan().getBorrower().getNumber() == number){
                return "최근 반납 이력: " + h.toString();
            }
        }

        return "이용자(" + number + ")의 반납 이력이 없습니다.";
    }
}