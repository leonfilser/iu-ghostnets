import jakarta.persistence.Entity;
import java.io.Serializable;
import jakarta.persistence.Id;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAddress;
    private String password;

    @OneToMany(mappedBy = "retriever", fetch = FetchType.EAGER)
    private List<Ghostnet> linkedGhostnets;

    public User()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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