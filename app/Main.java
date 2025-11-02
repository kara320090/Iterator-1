package app;
import java.util.*;
import model.*;
import add.*;
import print.*;

public class Main {
    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        List<Borrower> users = new ArrayList<>();
        Map<Borrower, List<Book>> loanDB = new HashMap<>();

        new AddUser(users, new Borrower("Kim", 20250001)).register();
        new AddUser(users, new Borrower("Lee", 20250002)).register();
        new AddBook(books, new Book("Effective Java", "Joshua Bloch", 101)).register();
        new AddBook(books, new Book("Clean Code", "Robert C. Martin", 102)).register();
        new AddBook(books, new Book("Algorithms", "CLRS", 103)).register();

        System.out.println("\n== 사용자 목록 ==");
        users.forEach(System.out::println);
        System.out.println("\n== 도서 목록 ==");
        books.forEach(System.out::println);

        BookListPrint loanAble = new LoanAble(books, loanDB);
        BookListPrint unborrowAble = new UnborrowAble(loanDB);
        LoanBook loan = new LoanBook(loanDB);
        ReturnBook ret = new ReturnBook(loanDB);

        Borrower kim = users.get(0);
        Borrower lee = users.get(1);
        Book b1 = books.get(0);
        Book b2 = books.get(1);

        loanAble.print();
        loan.borrow(kim, b1);
        loan.borrow(lee, b2);
        loan.borrow(kim, b1);
        unborrowAble.print();
        loanAble.print();
        ret.returnBook(kim, b1);
        ret.returnBook(kim, b1);
        unborrowAble.print();
        loanAble.print();
    }
}
