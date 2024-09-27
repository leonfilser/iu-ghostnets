import org.mindrot.jbcrypt.BCrypt;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import jakarta.enterprise.context.RequestScoped;

@Named
@RequestScoped
public class UserValidator implements Serializable {

    @Inject
    private UserController userController;

    public UserValidator()
    {

    }

    ////////////////////////////////////////////////////////////////////////////

    public void checkIfUserWithEmailAddressExists(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String emailAddress = (String) value;
    
        for (User existingUser : userController.getExistingUsers()) {
            if (existingUser.getEmailAddress().trim().equalsIgnoreCase(emailAddress.trim())) {
                return;
            }
        }
    
        throw new ValidatorException(
            new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Es konnte kein Nutzer mit dieser E-Mail-Adresse gefunden werden.", null));
    }

    ////////////////////////////////////////////////////////////////////////////

    public void checkIfPasswordIsCorrect(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String password = (String) value;
    
        for (User existingUser : userController.getExistingUsers()) {
            if (BCrypt.checkpw(password, existingUser.getPassword())) {
                return;
            }
        }

        throw new ValidatorException(
            new FacesMessage(FacesMessage.SEVERITY_ERROR,
            "Das eingegebene Kennwort ist falsch. Bitte versuchen Sie es erneut.", null));
    }

    ////////////////////////////////////////////////////////////////////////////
    
    public void checkIfPhoneNumberAlreadyExists(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String phoneNumber = (String) value;

        for (User existingUser : userController.getExistingUsers()) {
            if (existingUser.getPhoneNumber().equals(phoneNumber)) {
                throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Die eingegebene Telefonnummer wird bereits verwendet.", null));
            }
        }
    }

    ////////////////////////////////////////////////////////////////////////////

    public void checkIfEmailAddressAlreadyExists(FacesContext context, UIComponent component, Object value) throws ValidatorException {
        String emailAddress = (String) value;

        for (User existingUser : userController.getExistingUsers()) {
            if (existingUser.getEmailAddress().equals(emailAddress)) {
                throw new ValidatorException(
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, 
                    "Die eingegebene E-Mail-Adresse wird bereits verwendet.", null));
            }
        }
    }
}
