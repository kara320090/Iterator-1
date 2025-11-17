package collection;

import object.Book;
import object.Borrower;
import object.Loan;

import java.util.Scanner;
import java.util.ArrayList;


/**
 * 책 관리(등록, 삭제 등)를 위한 동작을 가지고 있는 클래스이다
 * 책을 객체 단위로 생성하며 이를 ArrayList 형태로 저장하여 책 객체들을 관리한다.
 * 
 * @author (작성자 이름)
 * @version (2025.11.08)
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
     * 등록 시(객체 생성 전) findBookCatalogueNumber 메소드를 이용하여 입력 받은 catalogueNumber가 DB에 이미 저장되어있는지 확인하고 중복 등록을 방지한다.
     */
    public void register(){
        System.out.println("추가할 책의 제목, 저자, 목록번호를 입력해주세요.");
        
        System.out.print("제목: ");
        String title = scan.nextLine();
        System.out.print("저자: ");
        String author = scan.nextLine();
        System.out.print("고유번호: ");
        String catalogueNumber = scan.nextLine();
        
        if(findBookCatalogueNumber(catalogueNumber)==null){
            Book book = new Book(title, author, catalogueNumber);
            this.books.add(book);
            
            System.out.println("제목: "+title+", 저자: "+author+", 목록번호: "+catalogueNumber+" 를 등록완료 했습니다.");
        }else{
            System.out.println("해당 고유번호은 이미 등록되어 있습니다. 다른 고유번호를 사용해주세요.");
        }
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
    
    /**
     * 임시 데이터셋
     */
    public void addSampleBooks() {
        books.add(new Book("자바의 정석", "남궁성", "B001"));
        books.add(new Book("파이썬 완벽 가이드", "이강성", "B002"));
        books.add(new Book("자바의 정석", "남궁성", "B003")); // 동일 제목 테스트용
        books.add(new Book("C언어 기초", "김철수", "B004"));
        books.add(new Book("자료구조", "박지민", "B005"));
        
        books.add(new Book("Java Programming", "홍길동", "B01"));
        books.add(new Book("Software Analysis and Design", "profsHwang", "B02"));
        books.add(new Book("명품 자바프로그래밍", "황기태", "B03"));
        books.add(new Book("소프트웨어테스트", "profsHwang", "B04"));
        
    }
}