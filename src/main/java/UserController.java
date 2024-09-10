import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UserController implements Serializable {

    private User user = new User();
    private UserDAO userDAO = new UserDAO();

    public UserController() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getUserList() {
        return userDAO.findAll();
    }

    public void addNew() {
        System.out.println("Adding new user");
        userDAO.addNew(user);
    }
}