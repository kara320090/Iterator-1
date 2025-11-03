package function;

import java.util.Scanner;
import java.util.HashSet;
import library.*;

/**
 * AddUser 클래스
 * 이용자 정보를 입력받아 시스템에 등록합니다.
 *
 * @author iteration#1 1팀
 * @version 2025.11.03
 */
public class AddUser {

    /**
     * 이용자를 등록합니다.
     * 사용자로부터 ID와 이름을 입력받아 Borrower 객체를 생성합니다.
     * 이미 존재하는 이용자인 경우 오류 메시지를 출력합니다.
     *
     * @param borrowerSet  등록된 이용자 저장 Set
     * @param sc           사용자 입력 Scanner
     * @return 
     */
    public static void run(HashSet<Borrower> borrowerSet, Scanner sc) {
        System.out.print("이용자 ID: ");
        String id = sc.nextLine();
        System.out.print("이용자 이름: ");
        String name = sc.nextLine();

        Borrower newBorrower = new Borrower(id, name);

        // 중복 이용자 확인
        if (borrowerSet.contains(newBorrower)) {
            System.out.println("[오류] 이미 등록된 이용자입니다.");
        } else {
            // 신규 이용자 등록
            borrowerSet.add(newBorrower);
            System.out.println("[등록 완료] " + id + " / " + name);
        }
    }
}
