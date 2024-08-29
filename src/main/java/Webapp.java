import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

@Named
@ApplicationScoped
public class Webapp {

    private List<Ghostnet> ghostnetList = new ArrayList<Ghostnet>();
    private List<User> userList = new ArrayList<User>();

    public Webapp() {
        Ghostnet newGhostnet = new Ghostnet();
        newGhostnet.setId(getGhostnetList().size() + 1);
        newGhostnet.setStateUpdated(new Date());
        newGhostnet.setCurrentState("Gemeldet");
        newGhostnet.setVolume(45567); // Set some default or example values
        newGhostnet.setReportDate(new Date());
        newGhostnet.setLatitude(4560.0);
        newGhostnet.setLongitude(789.0);
    
        getGhostnetList().add(newGhostnet);
    }

    public List<Ghostnet> getGhostnetList() {
        return ghostnetList;
    }

    public List<User> getUserList() {
        return userList;
    }

    public void testPrint() {
        for (Ghostnet ghostnet : getGhostnetList()) {
            System.out.println("Ghostnet ID: " + ghostnet.getId());
            System.out.println("Report Date: " + ghostnet.getReportDate());
            System.out.println("State Updated: " + ghostnet.getStateUpdated());
            System.out.println("Current State: " + ghostnet.getCurrentState());
            System.out.println("Latitude: " + ghostnet.getLatitude());
            System.out.println("Longitude: " + ghostnet.getLongitude());
            System.out.println("Volume: " + ghostnet.getVolume());
            System.out.println("----------------------"); // Separator for clarity
        }
    }
}