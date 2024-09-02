import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import jakarta.inject.Inject;
import java.util.Date;

@Named
@ViewScoped
public class UserController implements Serializable {

    private User newUser = new User();

    @Inject
    private Webapp webapp;

    public User getNewUser() {
        return newUser;
    }

    public void setNewUser(User newUser) {
        this.newUser = newUser;
    }

    public void addNewUser() {
        webapp.addUser(newUser);
        newUser = new User(); // Reset for the next entry
    }
}