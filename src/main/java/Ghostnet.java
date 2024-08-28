import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Date;

@Named
@ApplicationScoped
public class Ghostnet {
    
    private int id;
    private Date reportDate;
    private Date stateUpdated;
    private String currentState;
    private double latitude;
    private double longtitude;
    private int volume;

    public Ghostnet(int id, Date reportDate, Date stateUpdated, String currentState, double latitude, double longtitude, int volume)
    {
        this.id = id;
        this.reportDate = reportDate;
        this.stateUpdated = stateUpdated;
        this.currentState = currentState;
        this.latitude = latitude;
        this.longtitude = longtitude;
        this.volume = volume;
    }

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