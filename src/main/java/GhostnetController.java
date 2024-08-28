import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Named
@ApplicationScoped
public class GhostnetController {

    private int id;
    private Date reportDate;
    private Date stateUpdated;
    private String currentState;
    private double latitude;
    private double longtitude;
    private int volume;
    
    private Collection<Ghostnet> ghostnetCollection = new ArrayList<Ghostnet>();

    public void addGhostnet() {
        ghostnetCollection.add(new Ghostnet(this.id, new Date(), new Date(), this.currentState, this.latitude, this.longtitude, this.volume));
    }

    public Collection<Ghostnet> getGhostnetCollection() {
        return ghostnetCollection;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public double getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(double longtitude) {
        this.longtitude = longtitude;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }
}
