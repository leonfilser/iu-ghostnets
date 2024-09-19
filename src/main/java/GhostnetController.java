import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import jakarta.enterprise.context.RequestScoped;

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
        reportedGhostnets = ghostnetDao.ghostnetList();

        return "index?faces-redirect=true";
    }

    ////////////////////////////////////////////////////////////////////////////

    public List<Ghostnet> getGhostnetsByLoggedinUser() {

        List<Ghostnet> filteredGhostnets = new ArrayList<>();
        User user = userController.getUser();

        for (Ghostnet reportedGhostnet : reportedGhostnets) {
            if (reportedGhostnet.getRetriever() != null && reportedGhostnet.getRetriever().getId().equals(user.getId())) {
                filteredGhostnets.add(reportedGhostnet);
            }
        }

        return filteredGhostnets;
    }

    ////////////////////////////////////////////////////////////////////////////

        public List<Ghostnet> getAllOtherGhostnets() {

            List<Ghostnet> filteredGhostnets = new ArrayList<>();
            User user = userController.getUser();
    
            for (Ghostnet reportedGhostnet : reportedGhostnets) {
                if (reportedGhostnet.getRetriever() == null || !reportedGhostnet.getRetriever().getId().equals(user.getId())) {
                    filteredGhostnets.add(reportedGhostnet);
                }
            }
    
            return filteredGhostnets;
        }

    ////////////////////////////////////////////////////////////////////////////

    public void startRetrievalOfGhostnet(Ghostnet ghostnet) {
        ghostnet.setRetriever(userController.getUser());
        ghostnet.setCurrentState(GhostnetState.BERGUNG_BEVORSTEHEND);

        ghostnetDao.updateGhostnet(ghostnet);
        reportedGhostnets = ghostnetDao.ghostnetList();
    }

    public void abortRetrievalOfGhostnet(Ghostnet ghostnet) {
        ghostnet.setRetriever(null);
        ghostnet.setCurrentState(GhostnetState.GEMELDET);

        ghostnetDao.updateGhostnet(ghostnet);
        reportedGhostnets = ghostnetDao.ghostnetList();
    }

    public void finishRetrievalOfGhostnet(Ghostnet ghostnet) {
        ghostnet.setCurrentState(GhostnetState.GEBORGEN);

        ghostnetDao.updateGhostnet(ghostnet);
        reportedGhostnets = ghostnetDao.ghostnetList();
    }

    public void markGhostnetAsLost(Ghostnet ghostnet) {
        ghostnet.setCurrentState(GhostnetState.VERSCHOLLEN);
        
        ghostnetDao.updateGhostnet(ghostnet);
        reportedGhostnets = ghostnetDao.ghostnetList();
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

    public GhostnetState[] getGhostnetStates() {
        return GhostnetState.values();
    }
}