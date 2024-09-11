import jakarta.persistence.Entity;
import java.io.Serializable;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.util.Date;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.EnumType;

// Entity class for the Ghostnet object

@Entity
public class Ghostnet implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id; //Auto generated ID for each Ghostnet
    
    @Enumerated(EnumType.STRING)
    private GhostnetState currentState; //The current state of the Ghostnet (Gemeldet, Bergung Bevorstehend, Geborgen, Verschollen;)
    
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date sightingDate; //The date the Ghostnet was sighted

    private Double latitude;
    private Double longitude;
    private Integer size;
    private String reporterPhoneNumber;

    @ManyToOne(fetch = FetchType.EAGER)
    private User retriever;
    
    public Ghostnet()
    {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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