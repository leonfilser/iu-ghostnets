import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Date;

@Named
@ApplicationScoped
public class Webapp {
    
    private Collection<Ghostnet> ghostnetCollection = new ArrayList<Ghostnet>();

    public Webapp()
    {
        ghostnetCollection.add(new Ghostnet(1, new Date(), new Date(), "active", 53.5511, 9.9937, 100));
        ghostnetCollection.add(new Ghostnet(2, new Date(), new Date(), "active", 53.5511, 9.9937, 100));
        ghostnetCollection.add(new Ghostnet(3, new Date(), new Date(), "active", 53.5511, 9.9937, 100));
        ghostnetCollection.add(new Ghostnet(4, new Date(), new Date(), "active", 53.5511, 9.9937, 100));
        ghostnetCollection.add(new Ghostnet(5, new Date(), new Date(), "active", 53.5511, 9.9937, 100));
        ghostnetCollection.add(new Ghostnet(6, new Date(), new Date(), "active", 53.5511, 9.9937, 100));
        ghostnetCollection.add(new Ghostnet(7, new Date(), new Date(), "active", 53.5511, 9.9937, 100));
        ghostnetCollection.add(new Ghostnet(8, new Date(), new Date(), "active", 53.5511, 9.9937, 100));
        ghostnetCollection.add(new Ghostnet(9, new Date(), new Date(), "active", 53.5511, 9.9937, 100));
        ghostnetCollection.add(new Ghostnet(10, new Date(), new Date(), "active", 53.5511, 9.9937, 100));
    }

    public Collection<Ghostnet> getGhostnetCollection() {
        return ghostnetCollection;
    }

    public void setGhostnetCollection(Collection<Ghostnet> ghostnetCollection) {
        this.ghostnetCollection = ghostnetCollection;
    }
}