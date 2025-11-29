import java.util.TreeSet;

/**
 * 대출/반납 등 작업에 사용하는 동작들이 들어있는 클래스.
 * 대출 기능을 수행하며 대출 기록을 저장한다.
 * 반납 기능을 가지고 있다.
 * 책의 상태(대출 가능 여부)에 따른 목록 출력 기능을 가지고 있다. 목록 번호 기준 오름차순 정렬로 출력한다.
 * 
 * @author (작성자 이름)
 * @version (2025.11.08)
 */
public class LoanDB {
    private TreeSet<Loan> loanDB;

    /** LoanCollection 클래스의 객체 생성자
     * 
     */
    public LoanDB() {
        this.loanDB = new TreeSet<>();
    }
    
    public void registerOneLoan(Loan loan){
        loanDB.add(loan);
    }
    
    public Loan findLoan(int catalogueNumber){
        for(Loan temploan:loanDB){
            if(temploan.getBook().getCatalogueNumber()==catalogueNumber){
                return temploan;
            }
        }
        return null;
    }
    
}