import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class GhostnetController implements Serializable {

    private Ghostnet newGhostnet = new Ghostnet();
    private GhostnetDAO ghostnetDao = new GhostnetDAO();

    public GhostnetController() {

    }

    public Ghostnet getNewGhostnet() {
        return newGhostnet;
    }

    public void setNewGhostnet(Ghostnet newGhostnet) {
        this.newGhostnet = newGhostnet;
    }

    public List<Ghostnet> getGhostnetList() {
        return ghostnetDao.findAll();
    }

    public String addNew() {
        newGhostnet.setCurrentState("Gemeldet");
        ghostnetDao.addNew(newGhostnet);
        return "index?faces-redirect=true";
    }
}