import java.util.TreeSet;

/**
 * HisDb 클래스의 설명을 작성하세요.
 *
 * @author (작성자 이름)
 * @version (버전 번호 또는 작성한 날짜)
 */
public class HisDB
{
    private TreeSet<History> historys;
    public HisDB(){
        this.historys = new TreeSet<>();

    }
    public void RegisterOneHis(History history){
        historys.add(history);
    }
    public History findHistory(int number){
        for(History tempHis : historys){
            if(tempHis.getLoan().getBorrower().getNumber() == number){
                return tempHis;
            }
        }
        return null;
    }
}