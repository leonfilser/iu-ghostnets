import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.List;

import org.checkerframework.checker.units.qual.s;

@Named
@ViewScoped
public class GhostnetController implements Serializable {

    private Ghostnet ghostnet = new Ghostnet();
    private GhostnetDAO ghostnetDao = new GhostnetDAO();
    private UserDAO userDAO = new UserDAO();

    @Inject
    private SessionHandler sessionHandler;

    public GhostnetController()
    {

    }

    ////////////////////////////////////////////////////////////////////////////

    public List<Ghostnet> getGhostnetList() {
        return ghostnetDao.findAll();
    }

    public String addNew() {
        ghostnet.setCurrentState(GhostnetState.GEMELDET);
        ghostnetDao.addNew(ghostnet);
        return "index?faces-redirect=true";
    }

    public void addRetriever(Ghostnet ghostnet) {
        User user = userDAO.getUser(sessionHandler.getUserId());
        ghostnet.setRetriever(user);
        ghostnet.setCurrentState(GhostnetState.BERGUNG_BEVORSTEHEND);
        ghostnetDao.addNew(ghostnet);
    }


    ////////////////////////////////////////////////////////////////////////////

    public Ghostnet getGhostnet() {
        return ghostnet;
    }

    public void setGhostnet(Ghostnet ghostnet) {
        this.ghostnet = ghostnet;
    }
}