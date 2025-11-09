package object;

/**
 * 이용자 객체를 생성하기 위한 클래스
 * 이름과 고유번호를 가진다.
 *
 * @author (작성자 이름)
 * @version (2025.11.08)
 */
public class Borrower
{   
    private String name;
    private int number;
    private int bookLoanCount = 0;
    private final int bookLoanCount_MAX = 10;
    /** Borrower 클래스의 객체 생성자이다.
     * 이름, 고유번호를 받아 이용자(객체)를 생성한다.
     */
    public Borrower(String name, int number){
        this.name = name;
        this.number = number;
    }
    /** 이용자의 이름을 반환하는 동작을 수행한다.
     * 
     */
    public String getName(){
        return this.name;
    }
    /** 이용자의 고유번호를 반환하는 동작을 수행한다.
     * 
     */
    public int getNumber(){
        return this.number;
    }
    /** 책 대출 권수를 카운트하기 위한 메소드이다.
     * 책을 대출할 때 실행되며 값을 1씩 더한다.
     */
    public void loanCount(){
        this.bookLoanCount++;
    }
    /** 책 대출 권수를 카운트하기 위한 메소드이다.
     * 책을 반납할 때 실행되며 값을 1씩 뺀다.
     * 오류를 방지하기 위해 음수값이 아닐 때 실행되도록한다. (최소 카운트 0권)
     */
    public void returnCount(){
        if(bookLoanCount>0){
            this.bookLoanCount--;
        }    
    }
    /** 카운트한 책 대출 권수를 통해서 추가 대출 가능 여부를 확인하기 위한 메소드이다.
     * 책을 대출할 때 사용된다.
     */
    public boolean check(){
        if(bookLoanCount<bookLoanCount_MAX){
            return true;
        }else{
            return false;
        }
    }
}