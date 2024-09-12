import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.checkerframework.checker.units.qual.s;

@Named
@ViewScoped
public class GhostnetController implements Serializable {

    @Inject
    private UserController userController;

    private GhostnetDAO ghostnetDao = new GhostnetDAO();

    private Ghostnet ghostnet = new Ghostnet();
    private List<Ghostnet> reportedGhostnets = ghostnetDao.ghostnetList();

    public GhostnetController()
    {

    }

    ////////////////////////////////////////////////////////////////////////////

    public String addGhostnet() {
        ghostnet.setCurrentState(GhostnetState.GEMELDET);
        ghostnetDao.addGhostnet(ghostnet);

        return "index?faces-redirect=true";
    }

    public void addGhostnetRetriever(Ghostnet ghostnet) {

        User retriever = userController.getUser();

        ghostnet.setRetriever(retriever);
        ghostnet.setCurrentState(GhostnetState.BERGUNG_BEVORSTEHEND);
        ghostnetDao.updateGhostnet(ghostnet);
    }

    public List<Ghostnet> getGhostnetsByState(String state) {

        List<Ghostnet> filteredGhostnets = new ArrayList<>();

        for (Ghostnet reportedGhostnet : reportedGhostnets) {
            if (reportedGhostnet.getCurrentState().toString().equals(state)) {
                filteredGhostnets.add(reportedGhostnet);
            }
        }

        return filteredGhostnets;
    }

    ////////////////////////////////////////////////////////////////////////////

    public Ghostnet getGhostnet() {
        return ghostnet;
    }

    public void setGhostnet(Ghostnet ghostnet) {
        this.ghostnet = ghostnet;
    }

    public List<Ghostnet> getReportedGhostnets() {
        return reportedGhostnets;
    }
}