package Usecase;

import java.util.ArrayList;
import java.util.Iterator;
import DataBase.LibDB;
import Loan.LoanMap;
import myClass.Book;

/**
 * ShowAvailableBooks 클래스
 * 
 * 현재 대출 가능한 도서 목록을 ID 오름차순으로 출력한다.
 * LoanMap에 없는 책(= 대출중이 아닌 책)을 대상으로 한다.
 */
public class ShowAvailableBooks
{
    private LibDB<Book> bookDB;
    private LoanMap loanMap;

    public ShowAvailableBooks(LibDB<Book> bookDB, LoanMap loanMap)
    {
        this.bookDB = bookDB;
        this.loanMap = loanMap;
    }

    /**
     * 대출 가능한 도서 목록 출력(오름차순)
     */
    public void showSortedList()
    {
        ArrayList<Book> list = new ArrayList<Book>();

        // 대출가능(LoanMap에 없는) 책만 수집
        Iterator<Book> it = bookDB.iterator();
        while (it.hasNext()) {
            Book b = it.next();
            if (!loanMap.isLoaned(b.getID())) list.add(b);
        }

        // 버블 정렬 (ID 오름차순)
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i).getID().compareTo(list.get(j).getID()) > 0) {
                    Book tmp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, tmp);
                }
            }
        }

        // 출력
        System.out.println("[대출 가능 도서 목록]");
        if (list.size() == 0) {
            System.out.println("(없음)");
            return;
        }
        for (int k = 0; k < list.size(); k++) {
            Book b = list.get(k);
            System.out.println(b.getID() + " / " + b.getTitle() + " / " + b.getAuthor());
        }
    }
}
