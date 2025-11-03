package function;

import java.util.Scanner;
import model.*;
import database.*;

/**
 * AddUser 클래스
 * 
 * 새로운 이용자를 등록하는 기능을 담당한다.
 */
public class AddUser {
    public static void run(LibDB<Borrower> borrowerDB, Scanner sc) {
        System.out.print("이용자 ID: ");
        String id = sc.nextLine();
        System.out.print("이용자 이름: ");
        String name = sc.nextLine();

        borrowerDB.add(new Borrower(id, name));
        System.out.println("[등록 완료] " + id + " / " + name);
    }
}