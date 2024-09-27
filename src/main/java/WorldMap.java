import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import java.io.Serializable;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;


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
            if(!reportedGhostnet.getCurrentState().equals(GhostnetState.GEBORGEN))
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