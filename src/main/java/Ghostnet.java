import jakarta.persistence.Entity;
import java.io.Serializable;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;
import java.util.List;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Ghostnet implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String currentState;
    private double latitude;
    private double longitude;
    private int size;
    private String reporterPhoneNr;

    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date sightingDate;

    @ManyToOne
    private User retriever;
    
    public Ghostnet()
    {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getReporterPhoneNr() {
        return reporterPhoneNr;
    }

    public void setReporterPhoneNr(String reporterPhoneNr) {
        this.reporterPhoneNr = reporterPhoneNr;
    }

    public Date getSightingDate() {
        return sightingDate;
    }

    public void setSightingDate(Date sightingDate) {
        this.sightingDate = sightingDate;
    }

    public User getRetriever() {
        return retriever;
    }

    public void setRetriever(User retriever) {
        this.retriever = retriever;
    }
    
}