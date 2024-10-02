import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.io.Serializable;

/*
 * UserSession
 * Provides a session scoped bean to store the user's login status and ID.
 */

@Named
@SessionScoped
public class UserSession implements Serializable {

    private boolean loggedIn = false;
    private Integer userId;

    public UserSession() {

    }

    public boolean isLoggedIn() {
        return loggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        this.loggedIn = loggedIn;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}