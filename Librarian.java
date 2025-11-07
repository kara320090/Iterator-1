
/**
 * Library Application 을 사용하는 클래스이다.
 * Library 클래스에서 정의된 메뉴 메소드를 사용하여 이용자, 책, 대출/반납 등 관리할 수 있다.
 * 차후 추가 확장기능을 추가할 수 있다.(ex: 로그인/가입 메뉴 추가와 로그인(사용자) 정보에 따른 도서관 메뉴 차별화 등)
 * 
 * @author (작성자 이름)
 * @version (2025.11.08)
 */
public class Librarian
{
    public static void main(String[] args){
        Library library = new Library();
        library.menu_on(); // 도서관 메뉴 실행

    }
}
