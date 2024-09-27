import jakarta.persistence.Entity;
import java.io.Serializable;
import jakarta.persistence.Id;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.util.List;

// Entity class to construct User objects

@Entity
public class User implements Serializable {

    // Unique identifier for each User. Automatically generated and incremented
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // First name of the user
    private String firstName;

    // Last name of the user
    private String lastName;

    // Contact phone number of the user. Uniqueness is checked in the UserController class
    private String phoneNumber;

    // Email address of the user. Uniqueness is checked in the UserController class
    private String emailAddress;

    // Password for the user. Is encrypted in the UserController class before being stored
    private String password;

    // List of Ghostnets linked to the user as the retriever. Set to EAGER to avoid some troubles with the database. Should be changed to save resources
    @OneToMany(mappedBy = "retriever", fetch = FetchType.EAGER)
    private List<Ghostnet> linkedGhostnets;

    // Empty Constructor
    public User() {

    }

    // Getters and Setters for all Attributes

    public Integer getId() {
        return id;
    }

    // No setter method for id, as it is automatically generated and shouldnt be changed

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Ghostnet> getLinkedGhostnets() {
        return linkedGhostnets;
    }

    public void setLinkedGhostnets(List<Ghostnet> linkedGhostnets) {
        this.linkedGhostnets = linkedGhostnets;
    }
}