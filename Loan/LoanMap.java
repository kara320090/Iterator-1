package Loan;

import java.util.HashMap;

/**
 * LoanMap 클래스
 * 
 * 도서 대출 상태를 저장하는 HashMap이다.
 * key = BookID, value = BorrowerID
 * 반납 시 key 삭제로 처리한다.
 */
public class LoanMap
{
    private HashMap<String, String> map = new HashMap<String, String>();

    public boolean isLoaned(String bookId) {
        return map.containsKey(bookId);
    }

    public String getBorrower(String bookId) {
        return map.get(bookId);
    }

    public boolean loan(String bookId, String borrowerId)
    {
        if (map.containsKey(bookId)) return false;
        map.put(bookId, borrowerId);
        return true;
    }

    public boolean returnBook(String bookId)
    {
        if (!map.containsKey(bookId)) return false;
        map.remove(bookId);
        return true;
    }
}
