package function;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.HashSet;
import library.*;

/**
 * ShowAvailableBooks 클래스
 * 대출되지 않은 도서를 조회하여 출력합니다.
 *
 * @author iteration#1 1팀
 * @version 2025.11.03
 */
public class ShowAvailableBooks {

    /**
     * 대출 가능한 도서를 출력합니다.
     * books 목록에서 loanedBooks에 포함되지 않은 도서만 출력합니다.
     *
     * @param books        전체 도서 목록
     * @param loanedBooks  대출 중인 도서 목록(catalogueNumber 기반)
     * @return 없음 (콘솔에 출력)
     */
    public static void run(ArrayList<Book> books, HashSet<String> loanedBooks) {
        TreeSet<String> available = new TreeSet<String>();

        for (Book b : books) {
            if (!loanedBooks.contains(b.getCatalogueNumber())) {
                available.add(b.toString());
            }
        }

        System.out.println("[대출 가능한 도서 목록]");
        for (String s : available) {
            System.out.println(s);
        }
    }
}
