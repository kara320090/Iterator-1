import java.util.TreeSet;
import java.util.Iterator;
/**
 * HisDb 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class HisDB
{
    private TreeSet<History> histories;
    public HisDB(){
        this.histories = new TreeSet<>();

    }
    public void RegisterOneHis(History history){
        histories.add(history);
    }
    public History findHistory(int number){
        Iterator<History> it = histories.iterator();
        while(it.hasNext()){
            History h = it.next();
            if(h.getLoan().getBorrower().getNumber() == number){
                return h;
            }
        }
        return null;
    }

    // ★ LibraryApplication에서 iterator로 이력 순회
    public Iterator<History> iterator(){
        return histories.iterator();
    }
}