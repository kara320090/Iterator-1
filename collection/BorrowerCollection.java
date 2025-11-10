package collection;

import object.Book;
import object.Borrower;
import object.Loan;

import java.util.Scanner;
import java.util.ArrayList;

/**
 * 이용자 관리(등록, 삭제 등)를 위한 동작을 가지고 있는 클래스이다
 * 이용자를 객체 단위로 생성하며 이를 ArrayList 형태로 저장하여 이용자 객체들을 관리한다.
 *
 * @author (작성자 이름)
 * @version (2025.11.08)
 */
public class BorrowerCollection
{
    private Scanner scan;
    private ArrayList<Borrower> borrowers;
    
    /** 이용자 관리를 위한 객체 생성자이다.
     * 공용 스캐너 사용으로 값을 받고 이후 다른 메소드에서 사용할 수 있도록 한다.
     * 이용자 객체들의 저장, 검색, 등록, 삭제 등을 관리하기 위해서 리스트 형태로 객체의 속성을 지정해준다.
     * 
     */
    public BorrowerCollection(Scanner scan){
        this.scan = scan;
        this.borrowers = new ArrayList<>();
    }
    
    /**이용자 등록 메소드이다.
     * 메소드가 실행되면 Scanner로 이름, 고유번호의 값을 받아서 객체를 생성하고 ArrayList에 저장하여 관리할 수 있도록 한다.
     * 등록 시(객체 생성 전) findBorrowerNumber 메소드를 이용하여 입력받은 number가 DB에 이미 저장되어있는지 확인하고 중복 등록을 방지한다.
     */
    public void register(){
        System.out.println("추가할 이용자의 이름과 번호를 입력해주세요.");
    
        System.out.print("이름: ");
        String name = scan.nextLine();
        
        System.out.print("고유번호: ");
        int number = scan.nextInt();
        scan.nextLine();//버퍼 제거
        
        if(!findBorrowerNumber(number).equals(number)){
            Borrower borrower = new Borrower(name, number);
            this.borrowers.add(borrower);
        
            System.out.println("이용자: "+name+", 고유번호: "+number+" 를 등록완료 했습니다.");
        }else{
            System.out.println("해당 고유번호은 이미 등록되어 있습니다. 다른 고유번호를 사용해주세요.");
        }
    }
    /** 고유번호를 사용해서 이용자를 찾는 메소드이다.
     * 메소드가 실행되면 받아온 이용자 리스트에서 이용자 객체를 하나씩 꺼내고 
     * 받아온 고유번호와 저장된 이용자의 고유 번호를 비교하여 같으면 해당 이용자를 반환하고 다르면 NULL을 반환한다.
     * 이용자의 등록유무 확인, 대출, 반납 등의 기능에서 사용할 수 있다.
     */
    public Borrower findBorrowerNumber(int number){
        for(Borrower tempBorrowerN:this.borrowers){
          if(tempBorrowerN.getNumber() == number ){
            return tempBorrowerN;}
        }return null;
    }
}