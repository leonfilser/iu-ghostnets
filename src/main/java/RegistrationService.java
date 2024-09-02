import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@RequestScoped 
public class RegistrationService {

    @Inject
    private UserController userController;

    @Inject
    private GhostnetController ghostnetController;

    public void addNewUserAndGhostnet() {
        userController.addNewUser();
        ghostnetController.addNewGhostnet();
    }
}