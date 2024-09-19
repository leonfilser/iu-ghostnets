import jakarta.inject.Named;
import jakarta.enterprise.context.RequestScoped;
import java.time.LocalDate;

/**
 * DateBean class
 * Provides the current date at the time of request and is used in report.xhtml
 * to ensure the sightingDate of a Ghostnet is not set in the future.
 */

@Named
@RequestScoped
public class DateBean {

    // The current date, initialized at the time of request
    private final LocalDate currentDate = LocalDate.now();

    // Getter method for the current date
    public LocalDate getCurrentDate() {
        return currentDate;
    }

    // No setter method, as currentDate should remain constant
}