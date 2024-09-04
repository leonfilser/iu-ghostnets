import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class UserController implements Serializable {

    private User newUser = new User();
    private UserDAO userDAO = new UserDAO();

    public UserController() {

    }

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public List<User> getUserList() {
        return userDAO.findAll();
    }

    public void addNew() {
        System.out.println("Adding new user");
        userDAO.addNew(newUser);
    }
}