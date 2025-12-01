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
        Iterator<Loan> it = loanDB.iterator();
        while(it.hasNext()){
            Loan l = it.next();
            if(l.getBook().getCatalogueNumber() == catalogueNumber){
                return l;
            }
        }
        return null;
    }

    // ★ LibraryApplication에서 iterator로 대출목록 순회
    public Iterator<Loan> iterator(){
        return loanDB.iterator();
    }

    // ★ 반납 후 해당 Loan 제거
    public void removeLoan(Loan loan){
        loanDB.remove(loan);
    }
    
}