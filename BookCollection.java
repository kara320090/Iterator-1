import java.util.Scanner;
import java.util.ArrayList;

/**
 * 책 관리(등록, 삭제 등)를 위한 동작을 가지고 있는 클래스이다
 * 책을 객체 단위로 생성하며 이를 ArrayList 형태로 저장하여 DataBase를 구축한다.
 * 
 * @author (작성자 이름)
 * @version (2025.11.05)
 */
public class BookCollection
{
    private Scanner scan;
    private ArrayList<Book> books;
    
    /** 책 관리를 위한 객체 생성자이다.
     * 공용 스캐너 사용으로 값을 받고 이후 다른 메소드에서 사용할 수 있도록 한다.
     * 책을 저장, 검색, 등록, 삭제 등 관리하기 위해서 리스트 형태로 객체의 속성을 지정해준다.
     */
    public BookCollection(Scanner scan){
        this.scan = scan;
        this.books = new ArrayList<>();
    }
    
    /** 책 등록 메소드이다.
     * 메소드가 실행되면 Scanner로 제목, 저자, 고유번호의 값을 받아서 객체를 생성하고 ArrayList에 저장하여 관리할 수 있도록 한다.
     */
    public void register(){
        System.out.println("추가할 책의 제목, 저자, 목록번호를 입력해주세요.");
        
        System.out.print("제목: ");
        String title = scan.nextLine();
        System.out.print("저자: ");
        String author = scan.nextLine();
        System.out.print("고유번호: ");
        String catalogueNumber = scan.nextLine();
        
        Book book = new Book(title, author, catalogueNumber);
        this.books.add(book);
        
        System.out.println("제목: "+title+", 저자: "+author+", 목록번호: "+catalogueNumber+" 를 등록완료 했습니다.");
    }
    /** 목록번호를 사용해서 책을 찾는 메소드이다.
     * 메소드가 실행되면 받아온 책 리스트에서 책 객체를 하나씩 꺼내고 
     * 받아온 목록번호와 저장된 책의 목록 번호를 비교하여 같으면 해당 책을 반환하고 다르면 NULL을 반환한다.
     * 책의 저장유무 확인, 대출, 반납 등의 기능에서 사용할 수 있다.
     */
    public Book findBookCatalogueNumber(String catalogueNumber){
        for(Book tempbookCN:this.books){
            if(tempbookCN.getCatalogueNumber().equals(catalogueNumber)){
                return tempbookCN;}
        }return null;
    }
    /**책 리스트를 반환하는 메소드이다.
     * 
     */
    public ArrayList<Book> getBooks() {
        return this.books;
    }
}