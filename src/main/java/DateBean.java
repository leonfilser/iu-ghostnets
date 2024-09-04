import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import java.util.Date;

@Named
@RequestScoped
public class DateBean {

    private Date currentDate = new Date();

    public DateBean() {

    }

    public Date getCurrentDate() {
        return currentDate;
    }

    public void setCurrentDate(Date currentDate) {
        this.currentDate = currentDate;
    }
}