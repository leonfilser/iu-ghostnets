import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
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
        newGhostnet.setStateUpdated(new Date());
        newGhostnet.setCurrentState("Gemeldet");

        webapp.addGhostnet(newGhostnet);
        newGhostnet = new Ghostnet(); // Reset for the next entry
    }
}