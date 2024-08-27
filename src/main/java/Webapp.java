import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Collection;
import java.util.ArrayList;
import java.util.Date;

@Named
@ApplicationScoped
public class Webapp{
    
    private Collection<Geisternetz> geisternetze = new ArrayList<Geisternetz>();

    public Webapp()
    {
        geisternetze.add(new Geisternetz(1, new Date(), new Date(), new Date(), "LEER", 53.551086, 9.993682));
        geisternetze.add(new Geisternetz(2, new Date(), new Date(), new Date(), "LEER", 53.551086, 9.993682));
        geisternetze.add(new Geisternetz(3, new Date(), new Date(), new Date(), "LEER", 53.551086, 9.993682));
    }

    public Collection<Geisternetz> getGeisternetze() {
        return geisternetze;
    }
}