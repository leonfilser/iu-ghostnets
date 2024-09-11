import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.time.LocalDate;

 /**
  * Gets the current date on initialization (on request) and provides it to the
  * report.xhtml file to make sure the sightingDate of a Ghostnet is not in the future
  */

@Named  
@RequestScoped
public class DateBean {

    private final LocalDate currentDate = LocalDate.now();

    public LocalDate getCurrentDate() {
        return currentDate;
    }

    // No setter because the currentDate should not be changed
}