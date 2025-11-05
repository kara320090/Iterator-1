import java.util.Scanner;
/**
 * 사서가 도서관 어플리케이션 작업을 위해 접근하는 메인 클래스.
 *
 * @author (작성자 이름)
 * @version (2025.11.05)
 */
public class Library
{
    public void menu_on(){
        Scanner scan = new Scanner(System.in);
        
        BorrowerCollection userDB = new BorrowerCollection(scan);
        BookCollection bookDB = new BookCollection(scan);
        LoanCollection loanBook = new LoanCollection(scan,bookDB,userDB);
        
        boolean on_off = true;
        while(on_off){
            System.out.println("=== 도서관 메뉴 ===");
            System.out.println("1. 새로운 이용자 1명 등록");
            System.out.println("2. 새로운 책 1권 등록");
            System.out.println("3. 책 1권 대출");
            System.out.println("4. 책 1권 반납");
            System.out.println("5. 대출중 책 목록 출력");
            System.out.println("6. 대출가능 책 목록 출력");
            System.out.println("0. 종료");
            System.out.print("선택하세요: ");
            
            int choice = scan.nextInt();
            scan.nextLine();//버퍼 제거
            
            switch(choice){
                case 1:// 새로운 이용자 1명을 등록 //
                    userDB.register();
                    break;
                case 2:// 새로운 책 1권을 등록 //
                    bookDB.register();
                    break;
                case 3:// 책을 1권 대출 //
                    loanBook.loan();
                    break;
                case 4:// 책을 1권 반납 //
                    loanBook.returnBook();
                    break;
                case 5:// 대출중인 책을 화면에 표시 //
                    loanBook.showUnavailableBookList(bookDB.getBooks());
                    break;
                case 6:// 대출 가능한 책을 화면에 표시 //
                    loanBook.showAvailableBookList(bookDB.getBooks());
                    break;
                case 0:// 프로그램 종료 //
                    on_off = false;
                    System.out.println("프로그램을 종료합니다.");
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }
        }
    }
}