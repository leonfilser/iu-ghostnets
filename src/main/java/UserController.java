import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.annotation.PostConstruct;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;
import org.mindrot.jbcrypt.BCrypt;

@Named
@ViewScoped
public class UserController implements Serializable {

    private User user = new User();
    private UserDAO userDAO = new UserDAO();

    @Inject
    private SessionHandler sessionHandler;

    public UserController()
    {

    }

    @PostConstruct
    public void init() {
        if (sessionHandler.isLoggedIn()) {
            user = userDAO.getUser(sessionHandler.getUserId());
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    public String register() {
        if (userDAO.emailExists(user.getEmailAddress()) == false && userDAO.phoneNumberExists(user.getPhoneNumber()) == false) {
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(hashedPassword);
            userDAO.setUser(user);
            return "index?faces-redirect=true";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Email or phone number already exists!"));
            return null;
        }
    }

    public String login() {

        Integer userId = userDAO.getIdByEmail(this.user.getEmailAddress());
        User user = userDAO.getUser(userId);

        if (user != null && BCrypt.checkpw(this.user.getPassword(), user.getPassword())) {
            this.user = user;  // Assign the user object to the current session user
            sessionHandler.setLoggedIn(true);
            sessionHandler.setUserId(this.user.getId());  // Set the user's ID in the session
            return "userdash?faces-redirect=true";  // Redirect to user dashboard
        } else {
            // Add an error message if login fails
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Invalid email or password!"));
            return null;  // Stay on the current page
        }
    }

    public String logout() {
        System.out.println("Logged out");
        sessionHandler.setLoggedIn(false);
        sessionHandler.setUserId(null);
        return "index?faces-redirect=true";
    }

    ////////////////////////////////////////////////////////////////////////////

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}