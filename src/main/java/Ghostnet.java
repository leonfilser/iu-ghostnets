import jakarta.persistence.Entity;
import java.io.Serializable;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Temporal;

import java.util.Date;

@Entity
public class Ghostnet implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String currentState;
    private double latitude;
    private double longitude;
    private int volume;

    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date reportDate;
    @Temporal(jakarta.persistence.TemporalType.DATE)
    private Date stateUpdated;

    @ManyToOne
    @JoinColumn(name = "reporter_id")  // FK to the User who reported the Ghostnet
    private User reporter;

    @ManyToOne
    @JoinColumn(name = "retriever_id")  // FK to the User who retrieved the Ghostnet
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

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public Date getReportDate() {
        return reportDate;
    }

    public void setReportDate(Date reportDate) {
        this.reportDate = reportDate;
    }

    public Date getStateUpdated() {
        return stateUpdated;
    }

    public void setStateUpdated(Date stateUpdated) {
        this.stateUpdated = stateUpdated;
    }

    public User getReporter() {
        return reporter;
    }

    public void setReporter(User reporter) {
        this.reporter = reporter;
    }

    public User getRetriever() {
        return retriever;
    }

    public void setRetriever(User retriever) {
        this.retriever = retriever;
    }
}