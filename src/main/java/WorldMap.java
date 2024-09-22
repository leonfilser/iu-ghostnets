import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import java.io.Serializable;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;
import org.primefaces.model.map.Symbol;


@Named
@RequestScoped
public class WorldMap implements Serializable {

    private String googleMapsApiKey;
    private MapModel<Long> markerModel;

    @Inject
    private GhostnetController ghostnetController;

    public WorldMap()
    {

    }

    @PostConstruct
    public void init() {

        googleMapsApiKey = System.getenv("GOOGLE_MAPS_API_KEY");
        markerModel = new DefaultMapModel<>();

        for(Ghostnet reportedGhostnet : ghostnetController.getReportedGhostnets()) {
            if(reportedGhostnet.getCurrentState().equals(GhostnetState.GEMELDET))
            {
                markerModel.addOverlay(new Marker<>(new LatLng(reportedGhostnet.getLatitude(), reportedGhostnet.getLongitude()), reportedGhostnet.getCurrentState().toString()));
            }
        }
    }

    public String getGoogleMapsApiKey() {
        return googleMapsApiKey;
    }

    public MapModel<Long> getMarkerModel() {
        return markerModel;
    }
}