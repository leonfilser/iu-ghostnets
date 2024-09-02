import jakarta.persistence.Entity;
import java.io.Serializable;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.util.List;

@Entity
public class User implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String emailAdress;
    private String password;

    @OneToMany(mappedBy = "reporter")  // Mapped by the 'reporter' field in Ghostnet
    private List<Ghostnet> reportedGhostnets;

    @OneToMany(mappedBy = "retriever")  // Mapped by the 'retriever' field in Ghostnet
    private List<Ghostnet> retrievedGhostnets;

    public User() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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

    public List<Ghostnet> getReportedGhostnets() {
        return reportedGhostnets;
    }

    public void setReportedGhostnets(List<Ghostnet> reportedGhostnets) {
        this.reportedGhostnets = reportedGhostnets;
    }

    public List<Ghostnet> getRetrievedGhostnets() {
        return retrievedGhostnets;
    }

    public void setRetrievedGhostnets(List<Ghostnet> retrievedGhostnets) {
        this.retrievedGhostnets = retrievedGhostnets;
    }
}