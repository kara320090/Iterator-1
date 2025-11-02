package utillity;

import DataBase.LibDB;
import myClass.Borrower;

/**
 * BorrowerIdGenerator 클래스
 * 
 * 이용자 ID를 "U001" 형식으로 자동 생성하는 함수 제공
 */
public class BorrowerIdGenerator
{
    private static int seq = 1;

    public BorrowerIdGenerator() {}

    public static String generateId(LibDB<Borrower> borrowerDB)
    {
        while (true) {
            String id = String.format("U%03d", seq);
            if (!borrowerDB.exists(id)) {
                seq++;
                return id;
            }
            seq++;
        }
    }
}
