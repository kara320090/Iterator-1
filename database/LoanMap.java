package database;

import java.util.HashMap;

/**
 * LoanMap 클래스
 * 
 * 도서 대출 상태를 관리한다.
 * 각 도서의 catalogueNumber와 대출자 ID를 매핑하여 저장한다.
 */
public class LoanMap {
    private HashMap<String, String> map = new HashMap<String, String>();

    public boolean isLoaned(String catalogueNumber) {
        return map.containsKey(catalogueNumber);
    }

    public boolean loan(String catalogueNumber, String borrowerId) {
        if (map.containsKey(catalogueNumber)) return false;
        map.put(catalogueNumber, borrowerId);
        return true;
    }
}