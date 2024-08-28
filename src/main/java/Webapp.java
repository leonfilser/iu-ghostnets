import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Date;

@Named
@ApplicationScoped
public class Webapp{
    
    private Collection<Geisternetz> geisternetze = new ArrayList<Geisternetz>();
    private boolean toggleState = false;

    public Webapp()
    {
        geisternetze.add(new Geisternetz(0, new Date(), new Date(), new Date(), "Gemeldet", 43.551086, 9.993682, 100));
        geisternetze.add(new Geisternetz(1, new Date(), new Date(), new Date(), "Geborgen", 23.551086, 10.993682, 200));
        geisternetze.add(new Geisternetz(2, new Date(), new Date(), new Date(), "Verschollen", 13.551086, 8.993682, 300));
        geisternetze.add(new Geisternetz(3, new Date(), new Date(), new Date(), "Bergung bevorstehen", 8.551086, 9.993682, 345));
        geisternetze.add(new Geisternetz(4, new Date(), new Date(), new Date(), "Gemeldet", 56.551086, 15.993682, 38));
        geisternetze.add(new Geisternetz(5, new Date(), new Date(), new Date(), "Gemeldet", 58.551086, 1.993682, 99));
        geisternetze.add(new Geisternetz(6, new Date(), new Date(), new Date(), "Bergung bevorstehend", 3.551086, 9.993682, 84));
        geisternetze.add(new Geisternetz(7, new Date(), new Date(), new Date(), "Verschollen", 53.551086, 5.993682, 456));
        geisternetze.add(new Geisternetz(8, new Date(), new Date(), new Date(), "Geborgen", 3.551086, 49.993682, 435456));
    }

    public Collection<Geisternetz> getGeisternetze() {
        return geisternetze;
    }

    public boolean isToggleState() {
        return toggleState;
    }

    public void setToggleState(boolean toggleState) {
        this.toggleState = toggleState;
    }

}