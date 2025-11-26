import java.util.Calendar;
/**
 * History 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class History
{
    private Calendar returnDate;
    private Loan loan;

    /** 책의 대출 객체를 생성하는 메소드이다.
     * 객체를 생성하면서 반납일자를 계산하는 메소드를 같이 실행하여 저장한다.
     * 반납일자를 계산하는 메소드 속에는 책의 대출 상태를 대출중으로 바꾸는 메소드가 추가되어있어서 같이 실행된다.
     */
    public History(Loan loan){
        this.loan = loan;
    }

    /** 책 대출 일자를 반환하는 메소드이다.
     * 
     */
    public Calendar getReturnDate() {
        return returnDate;
    }
    
    /**
     * 화면에 책의 속성값(제목, 저자, 목록번호)을 문자열로 반환한다.
     */
    @Override
    public String toString() {
        return "대출일시: " + this.loan.getLoanDate() + "대출자: " + loan.getBorrower().toString() + "대출서적: " + loan.getBook().toString() ;
    }
}