import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import jakarta.inject.Inject;
import java.util.Date;
import java.util.List;

@Named
@ViewScoped
public class GhostnetController implements Serializable {

    private Ghostnet newGhostnet = new Ghostnet();

    @Inject
    private Webapp webapp;

    public Ghostnet getNewGhostnet() {
        return newGhostnet;
    }

    public void setNewGhostnet(Ghostnet newGhostnet) {
        this.newGhostnet = newGhostnet;
    }

    public void addNewGhostnet() {
        System.out.println("Latitude: " + newGhostnet.getLatitude());
        System.out.println("Longitude: " + newGhostnet.getLongitude());
        System.out.println("Volume: " + newGhostnet.getVolume());
    
        newGhostnet.setId(webapp.getGhostnetList().size() + 1);
        newGhostnet.setStateUpdated(new Date());
        newGhostnet.setCurrentState("Gemeldet");
    
        webapp.getGhostnetList().add(newGhostnet); // Add the actual newGhostnet
        newGhostnet = new Ghostnet(); // Reset for the next entry
    }
}