
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
}