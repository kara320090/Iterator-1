package Add;
import java.util.List;
import model.Book;

public class AddBook implements Add {
    private final List<Book> bookList;
    private final Book book;

    public AddBook(List<Book> bookList, Book book) {
        this.bookList = bookList;
        this.book = book;
    }

    @Override
    public void register() {
        bookList.add(book);
        System.out.println("[등록] 도서 추가: " + book);
    }
}
