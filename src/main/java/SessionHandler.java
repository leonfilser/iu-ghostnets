import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named
@SessionScoped
public class SessionHandler implements Serializable {

    private String emailAdress;
    private String password;
    private boolean loggedIn = false;

    private UserDAO userDAO = new UserDAO();
    private User sessionUser;

    public SessionHandler() {

    }

    ////////////////////////////////////////////////////////////////////////////

    
    public String login() {
        User sessionUser = userDAO.findByEmail(emailAdress);

        if (sessionUser != null && sessionUser.getPassword().equals(password)) {
            loggedIn = true;
            return "userdash.xhtml?faces-redirect=true";
        } else {
            FacesContext.getCurrentInstance().addMessage(null, 
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Fehler", "Ungültige Anmeldeinformationen"));
            return "login.xhtml";
        }
    }

    public String logout() {
        loggedIn = false;
        return "index.xhtml?faces-redirect=true";
    }

    ////////////////////////////////////////////////////////////////////////////

    public String getEmailAdress() {
        return emailAdress;
    }

    public void setEmailAdress(String emailAdress) {
        this.emailAdress = emailAdress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public User getSessionUser() {
        return sessionUser;
    }

    public void setSessionUser(User sessionUser) {
        this.sessionUser = sessionUser;
    }
}