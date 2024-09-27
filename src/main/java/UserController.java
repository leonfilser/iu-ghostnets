import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

@Named
@ViewScoped
public class UserController implements Serializable {

    @Inject
    private UserSession userSession;

    private UserDAO userDAO = new UserDAO();
    
    private User user = new User();
    private List<User> existingUsers = userDAO.userList();

    public UserController()
    {

    }

    @PostConstruct
    public void init() {
        if (userSession.isLoggedIn()) {
            for (User existingUser : existingUsers) {
                if (existingUser.getId().equals(userSession.getUserId())) {
                    this.user = existingUser;
                }
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    public String registerUser() {

        user.setEmailAddress(user.getEmailAddress().trim().toLowerCase());
        user.setPassword(BCrypt.hashpw(user.getPassword(), BCrypt.gensalt()));
        userDAO.addUser(user);

        return "index?faces-redirect=true";

    }

    ////////////////////////////////////////////////////////////////////////////

    public String loginUser() {

        for (User existingUser : existingUsers) {
            if (existingUser.getEmailAddress().trim().equalsIgnoreCase(user.getEmailAddress().trim()) 
                && BCrypt.checkpw(user.getPassword(), existingUser.getPassword())) {
    
                this.user = existingUser;
                userSession.setLoggedIn(true);
                userSession.setUserId(user.getId());
    
                System.out.println("User " + user.getId() + " logged in.");
    
                return "userdash?faces-redirect=true";
            }
        }
    
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////

    public String logoutUser() {

        userSession.setUserId(null);
        userSession.setLoggedIn(false);

        user = new User();

        return "index?faces-redirect=true";
    }

    ////////////////////////////////////////////////////////////////////////////

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<User> getExistingUsers() {
        return existingUsers;
    }
}