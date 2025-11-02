package Add;
import java.util.List;
import model.Borrower;

public class AddUser implements Add {
    private final List<Borrower> userList;
    private final Borrower user;

    public AddUser(List<Borrower> userList, Borrower user) {
        this.userList = userList;
        this.user = user;
    }

    @Override
    public void register() {
        userList.add(user);
        System.out.println("[등록] 사용자 추가: " + user);
    }
}
