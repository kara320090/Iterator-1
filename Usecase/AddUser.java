package Usecase;

import java.util.Scanner;
import DataBase.LibDB;
import myClass.Borrower;
import utillity.BorrowerIdGenerator;

/**
 * AddUser 클래스
 * 
 * 새로운 이용자 1명을 등록한다.
 * 이름을 입력받고 ID를 자동 발급하여 DB에 저장한다.
 */
public class AddUser
{
    private LibDB<Borrower> borrowerDB; // 이용자 DB

    /**
     * 생성자
     * @param db 이용자 DB
     */
    public AddUser(LibDB<Borrower> db)
    {
        this.borrowerDB = db;
    }

    /**
     * 이용자 등록 절차 수행
     * - 이름 입력
     * - ID 자동 생성 (U001 형식)
     * - DB에 추가
     */
    public void addUser()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("이용자 이름을 입력하세요: ");
        String name = sc.nextLine().trim();

        String newUserId = BorrowerIdGenerator.generateId(borrowerDB);
        Borrower user = new Borrower(newUserId, name);

        // DB에 추가 시도
        if (borrowerDB.add(user)) {
            System.out.println("[이용자 등록 성공] " + newUserId + " / " + name);
        } else {
            System.out.println("[이용자 등록 실패] 중복 ID 또는 기타 오류");
        }
    }
}
