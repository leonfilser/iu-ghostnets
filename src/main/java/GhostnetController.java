import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import jakarta.inject.Inject;
import java.util.Date;

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
        newGhostnet.setId(webapp.getGhostnetList().size() + 1);
        newGhostnet.setStateUpdated(new Date());
        newGhostnet.setCurrentState("Gemeldet");

        webapp.addGhostnet(newGhostnet);
        newGhostnet = new Ghostnet(); // Reset for the next entry
    }
}