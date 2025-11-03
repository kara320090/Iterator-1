package database;

import java.util.ArrayList;

/**
 * LibDB 클래스
 * 
 * 제네릭 데이터베이스 클래스.
 * 이용자 정보를 ArrayList로 저장하고 관리한다.
 */
public class LibDB<T> {
    private ArrayList<T> db = new ArrayList<T>();

    public void add(T item) {
        db.add(item);
    }

    public ArrayList<T> getAll() {
        return db;
    }
}