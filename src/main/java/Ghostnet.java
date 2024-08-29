import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;

import java.io.Serializable;
import java.util.Date;

@Named
@ViewScoped
public class Ghostnet implements Serializable {
    
    private int id;
    private Date reportDate;
    private Date stateUpdated;
    private String currentState;
    private double latitude;
    private double longitude;
    private int volume;

    public Ghostnet()
    {

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
}