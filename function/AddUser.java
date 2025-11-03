package function;

import java.util.Scanner;
import java.util.HashSet;
import library.*;

/**
 * AddUser 클래스 - 이용자 등록 처리
 *
 * @author iteration#1 1팀
 * @version 2025.11.03
 */
public class AddUser {
    public static void run(HashSet<Borrower> borrowerSet, Scanner sc) {
        System.out.print("이용자 ID: ");
        String id = sc.nextLine();
        System.out.print("이용자 이름: ");
        String name = sc.nextLine();

        Borrower newBorrower = new Borrower(id, name);
        if (borrowerSet.contains(newBorrower)) {
            System.out.println("[오류] 이미 등록된 이용자입니다.");
        } else {
            borrowerSet.add(newBorrower);
            System.out.println("[등록 완료] " + id + " / " + name);
        }
    }
}