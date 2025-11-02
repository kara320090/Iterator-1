package DataBase;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * LibDB 클래스
 * 
 * 도서(Book) 혹은 이용자(Borrower) 객체를 저장하는
 * 제네릭 데이터베이스 클래스이다.
 * ArrayList 기반으로 객체를 저장하며,
 * 중복 ID가 존재하는 경우 추가를 거부한다.
 *
 * @param <T> DB_Element를 상속하는 타입
 */
public class LibDB<T extends DB_Element> implements Iterable<T>
{
    // 내부 저장소: DB 역할을 수행
    private ArrayList<T> db = new ArrayList<T>();

    /**
     * DB가 비어있는지 확인
     * @return true면 비어있음
     */
    public boolean isEmpty() {
        return db.size() == 0;
    }

    /**
     * DB 전체 요소를 반환
     * @return 전체 리스트
     */
    public List<T> findAll() {
        return db;
    }

    /**
     * ID로 요소 검색
     * @param id 검색할 ID
     * @return 해당 객체 또는 null
     */
    public T findById(String id) {
        Iterator<T> it = db.iterator();
        while (it.hasNext()) {
            T cur = it.next();
            if (cur.getID().equals(id)) return cur;
        }
        return null;
    }

    /**
     * 특정 ID 존재 여부 확인
     * @param id 검색할 ID
     * @return true면 존재
     */
    public boolean exists(String id) {
        Iterator<T> it = db.iterator();
        while (it.hasNext()) {
            T cur = it.next();
            if (cur.getID().equals(id)) return true;
        }
        return false;
    }

    /**
     * DB에 요소 추가 (ID 중복 시 거부)
     * @param elem 추가할 객체
     * @return true면 성공
     */
    public boolean add(T elem)
    {
        if (elem == null || elem.getID() == null) {
            System.out.println("[오류] null 요소는 추가 불가");
            return false;
        }

        Iterator<T> it = db.iterator();
        while (it.hasNext()) {
            T cur = it.next();
            if (cur.getID().equals(elem.getID())) {
                System.out.println("[거부] 중복 ID: " + elem.getID());
                return false;
            }
        }
        db.add(elem);
        return true;
    }

    /**
     * iterator 지원
     */
    public Iterator<T> iterator() {
        return db.iterator();
    }
}