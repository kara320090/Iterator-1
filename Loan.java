import java.util.Calendar;
/**
 * 대출을 위한 클래스이다. 
 * 대출 작업을 수행하며 대출 기록을 저장한다.
 *
 * @author (작성자 이름)
 * @version (2025.11.02)
 */
public class Loan
{
    private Book book;
    private Borrower borrower;
    private int loanRule = 15; // 대출 기간을 저장해두는 변수이다. 초기값 = 15일
    private Calendar nowDay;
    private Calendar returnDay;
    
    /** 책의 대출 객체를 생성하는 메소드이다.
     * 객체를 생성하면서 반납일자를 계산하는 메소드를 같이 실행하여 저장한다.
     * 반납일자를 계산하는 메소드 속에는 책의 대출 상태를 대출중으로 바꾸는 메소드가 추가되어있어서 같이 실행된다.
     */
    public Loan(Book book, Borrower borrower){
        this.book = book;
        this.borrower = borrower;
        setReturnDay();
    }
    /** 대출 객체를 생성할 때 현재 날짜에 15일 뒤인 대출날짜를 계산하여 저장하고 책의 상태를 대출중으로 바꾸는 동작을 수행한다.
     * 
     */
    public void setReturnDay(){
        this.nowDay = Calendar.getInstance();
        this.returnDay = (Calendar) nowDay.clone();
        returnDay.add(Calendar.DAY_OF_MONTH, loanRule);
        this.book.changeStatus(false);
    }
    /** 책 반납 일자를 반환하는 메소드이다.
     * 
     */
    public Calendar getReturnDate() {
        return returnDay;
    }
    /**책 객체를 반환하는 메소드이다.
     * 
     */
    public Book getBook() {
        return this.book;
    }
    public Borrower getBorrower(){
        return this.borrower;
    }
}