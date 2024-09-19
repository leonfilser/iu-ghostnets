import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.event.SystemEvent;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

@Named
@ViewScoped
public class UserController implements Serializable {

    @Inject
    private SessionHandler sessionHandler;

    private UserDAO userDAO = new UserDAO();
    
    private User user = new User();
    private List<User> existingUsers = userDAO.userList();

    public UserController()
    {

    }

    @PostConstruct
    public void init() {
        if (sessionHandler.isLoggedIn()) {
            for (User existingUser : existingUsers) {
                if (existingUser.getId().equals(sessionHandler.getUserId())) {
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
                sessionHandler.setLoggedIn(true);
                sessionHandler.setUserId(user.getId());
    
                System.out.println("User " + user.getId() + " logged in.");
    
                return "userdash?faces-redirect=true";
            }
        }
    
        return null;
    }

    ////////////////////////////////////////////////////////////////////////////

    public String logoutUser() {

        sessionHandler.setUserId(null);
        sessionHandler.setLoggedIn(false);

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