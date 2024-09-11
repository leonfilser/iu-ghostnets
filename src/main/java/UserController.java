import jakarta.inject.Inject;
import jakarta.inject.Named;
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

    ////////////////////////////////////////////////////////////////////////////

    public String register() {
        if (userDAO.emailExists(user.getEmailAddress()) == false && userDAO.phoneNumberExists(user.getPhoneNumber()) == false) {
            String hashedPassword = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
            user.setPassword(hashedPassword);
            userDAO.register(user);
            return "userdash.xhtml";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Email or phone number already exists!"));
            return null;
        }
    }

    public String login() {
        User temp = userDAO.findByEmail(user.getEmailAddress());

        if (temp != null && BCrypt.checkpw(user.getPassword(), temp.getPassword())) {
            sessionHandler.setLoggedIn(true);
            sessionHandler.setUser(temp);
            return "userdash.xhtml";
        }
        else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Invalid email or password!"));
            return null;
        }
    }

    public String logout() {
        sessionHandler.setLoggedIn(false);
        sessionHandler.setUser(null);
        return "index.xhtml";
    }

    ////////////////////////////////////////////////////////////////////////////

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}