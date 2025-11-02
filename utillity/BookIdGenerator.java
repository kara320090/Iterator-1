package utillity;

import DataBase.LibDB;
import myClass.Book;

/**
 * BookIdGenerator 클래스
 * 
 * 이 클래스는 도서 ID를 자동으로 생성하는 역할을 수행한다.
 * ID 형식은 "B001", "B002"와 같이 숫자가 증가하는 구조이다.
 * 도서 데이터베이스에 이미 존재하는 ID가 있는지 검사하며,
 * 중복되지 않는 고유번호를 생성한다.
 *
 * @author (PBL#1)
 * @version (2025.11.02)
 */
public class BookIdGenerator
{
    // 정적 시퀀스 변수: 다음에 생성될 도서 ID 번호
    private static int seq = 1;

    /**
     * BookIdGenerator 생성자
     * 
     * ID 생성기 클래스이므로 객체를 생성하지 않고
     * 정적 메소드로 사용한다. (생성자는 기본 형태 유지)
     */
    public BookIdGenerator()
    {
        // 생성자 내부 로직 없음
    }

    /**
     * 다음 도서 ID를 생성하는 메소드
     * 
     * DB에 존재하는 ID를 확인한 후, 중복되지 않는
     * 다음 고유번호를 "BXXX" 형식으로 반환한다.
     *
     * @param  bookDB  도서 DB 참조 객체
     * @return         새롭게 생성된 도서 ID 문자열
     */
    public static String nextId(LibDB<Book> bookDB)
    {
        while (true) {
            String id = String.format("B%03d", seq);
            if (!bookDB.exists(id)) {
                seq++;
                return id;
            }
            seq++;
        }
    }

    /**
     * 기존 도서 ID 중 가장 큰 번호 뒤로 시퀀스를 맞추는 메소드
     * 
     * 초기 데이터(하드코딩 시드)가 존재할 경우,
     * 가장 큰 ID 값 이후부터 자동생성이 되도록 조정한다.
     *
     * @param lastId   DB에 가장 마지막으로 존재하는 도서 ID
     */
    public static void alignAfter(String lastId)
    {
        try {
            if (lastId != null && lastId.startsWith("B") && lastId.length() >= 2) {
                int n = Integer.parseInt(lastId.substring(1));
                if (n + 1 > seq) seq = n + 1;
            }
        } catch (Exception e) {
            // 문법 오류 또는 변환 실패 시 기본 seq 유지
        }
    }
}
