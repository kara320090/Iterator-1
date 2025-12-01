
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
    private Borrower borrower;
    private BookDB bookDB;
    private Book book;
    
    public LibraryApplication(String name){
        libraryName = name;
        borrowerDB= new BorrowerDB();
        bookDB= new BookDB();
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
        
        return "대출가능한 책 목록을 Display하였습니다.";
    }
    
    // UC#4 : 대출중인 책 목록 Display
    public String displayBookOnLoan(){
        return "대출가능한 책 목록을 Display하였습니다.";
    }
    
    // UC#5 : 책 1권 대출
    public String loanOneBook(String name, String bookID){
        return "책(" + bookID + ")이 이용자(" + name + ")에게 대출되었습니다.";
    }
    
    // UC#6 : 책 1권 반납
    public String returnOneBook(String bookID){
       return "책(" + bookID +")이 반납되었습니다.";
    }
}