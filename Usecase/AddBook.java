package Usecase;

import java.util.Scanner;
import DataBase.LibDB;
import myClass.Book;
import utillity.BookIdGenerator;

/**
 * AddBook 클래스
 * 
 * 도서를 등록하는 기능을 수행한다.
 * 사용자에게 제목과 저자를 입력받고
 * 자동으로 발급된 책 ID와 함께 DB에 저장한다.
 */
public class AddBook
{
    private LibDB<Book> bookDB; // 도서 데이터베이스

    /**
     * 생성자
     * @param db 도서 DB
     */
    public AddBook(LibDB<Book> db)
    {
        this.bookDB = db;
    }

    /**
     * 도서 등록 메소드
     * 사용자 입력 → Book 객체 생성 → DB 저장
     */
    public void addBook()
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("도서 제목을 입력하세요: ");
        String title = sc.nextLine().trim();

        System.out.print("도서 저자를 입력하세요: ");
        String author = sc.nextLine().trim();

        // 책 ID 자동 생성
        String newBookId = BookIdGenerator.nextId(bookDB);

        // Book 객체 생성
        Book newBook = new Book(newBookId, title, author);

        // DB에 추가 시도
        boolean isAdded = bookDB.add(newBook);

        if (isAdded) {
            System.out.println("[도서 등록 성공] " 
                               + newBookId + " / " + title + " / " + author);
        } else {
            System.out.println("[도서 등록 실패] 이미 존재하는 ID이거나 오류가 발생했습니다.");
        }
    }
}
