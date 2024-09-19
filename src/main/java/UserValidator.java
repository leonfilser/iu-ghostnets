import org.mindrot.jbcrypt.BCrypt;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.component.UIComponent;
import jakarta.faces.context.FacesContext;
import jakarta.faces.validator.ValidatorException;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import java.io.Serializable;
import java.util.List;
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

    public void loginValidateEmail(FacesContext context, UIComponent component, Object value) throws ValidatorException {
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

    public void loginValidatePassword(FacesContext context, UIComponent component, Object value) throws ValidatorException {
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
    
    public void registerValidatePhoneNumber(FacesContext context, UIComponent component, Object value) throws ValidatorException {
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

    public void registerValidateEmailAddress(FacesContext context, UIComponent component, Object value) throws ValidatorException {
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
