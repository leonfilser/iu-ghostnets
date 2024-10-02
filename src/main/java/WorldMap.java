import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import java.io.Serializable;
import org.primefaces.model.map.DefaultMapModel;
import org.primefaces.model.map.LatLng;
import org.primefaces.model.map.MapModel;
import org.primefaces.model.map.Marker;

/**
 * WorldMap
 * Provides the Google Maps API Key and Map Markers for the world map in index.xhtml.
 */

@Named
@RequestScoped
public class WorldMap implements Serializable {

    // Google Maps API key 
    private String googleMapsApiKey;

    // MapModel to hold ghostnet coordinates
    private MapModel<Long> markerModel;

    // Controller to access the ghostnetlist
    @Inject
    private GhostnetController ghostnetController;


    public WorldMap()
    {
        // Empty Default constructor
    }

    @PostConstruct
    public void init() {
        // Retrieve Google Maps API key from environment variables
        googleMapsApiKey = System.getenv("GOOGLE_MAPS_API_KEY");
        
        // Create a new map model to hold markers
        markerModel = new DefaultMapModel<>();

        // Iterate through all reported ghostnets and add markers to the map
        for (Ghostnet reportedGhostnet : ghostnetController.getReportedGhostnets()) {
            // Only display markers for ghostnets that are not yet retrieved
            if (!reportedGhostnet.getCurrentState().equals(GhostnetState.GEBORGEN)) {
                markerModel.addOverlay(new Marker<>(
                    new LatLng(reportedGhostnet.getLatitude(), reportedGhostnet.getLongitude()), 
                    reportedGhostnet.getCurrentState().toString()
                ));
            }
        }
    }

    // Getter method for Google Maps API key
    public String getGoogleMapsApiKey() {
        return googleMapsApiKey;
    }

    // Getter method for the map model with markers
    public MapModel<Long> getMarkerModel() {
        return markerModel;
    }

    // No setter methods, as the Google Maps API key and map model should remain constant

}