import jakarta.persistence.Entity;
import java.io.Serializable;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import java.util.Date;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.EnumType;

// Entity class to construct Ghostnet objects

@Entity
public class Ghostnet implements Serializable {
    
    // Unique identifier for each Ghostnet. Automatically generated and incremented
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    // The current state of the Ghostnet (e.g., GEMELDET, BERGUNG_BEVORSTEHEND, GEBORGEN, VERSCHOLLEN)
    @Enumerated(EnumType.STRING)
    private GhostnetState currentState;

    // Date when the Ghostnet was sighted
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date sightingDate;

    // Coordinates of the Ghostnet location
    private Double latitude;  // Latitude of the Ghostnet
    private Double longitude; // Longitude of the Ghostnet

    // Estimated size of the Ghostnet in square meters
    private Integer size;

    // Phone number of the person who reported the Ghostnet (optional field)
    private String reporterPhoneNumber;

    // The User who is in charge of the retrieval of the Ghostnet. Either null or 1 User
    @ManyToOne(fetch = FetchType.EAGER)
    private User retriever;

    // Empty Constructor
    public Ghostnet() {

    }

    // Getters and Setters for all Attributes

    public Integer getId() {
        return id;
    }

    // No setter method for id, as it is automatically generated and shouldnt be changed

    public GhostnetState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(GhostnetState currentState) {
        this.currentState = currentState;
    }

    public Date getSightingDate() {
        return sightingDate;
    }

    public void setSightingDate(Date sightingDate) {
        this.sightingDate = sightingDate;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getReporterPhoneNumber() {
        return reporterPhoneNumber;
    }

    public void setReporterPhoneNumber(String reporterPhoneNumber) {
        this.reporterPhoneNumber = reporterPhoneNumber;
    }

    public User getRetriever() {
        return retriever;
    }

    public void setRetriever(User retriever) {
        this.retriever = retriever;
    }
}