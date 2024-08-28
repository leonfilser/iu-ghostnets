import jakarta.inject.Named;
import jakarta.enterprise.context.SessionScoped;
import java.util.Date;

@Named
@SessionScoped
public class Geisternetz {
    
    // Variablen
    private int id = 0;
    private Date registriert = new Date(); // Wann wurde das Geisternetz im System registriert
    private Date geaendert = new Date(); // Wann wurde der Status des Geisternetzes zuletz aktualisiert
    private Date gesichtet = new Date(); // Wann wurde das Geisternetz vom Melder gesichtet
    private String status = "LEER"; // Aktueller Status des Geisternetzes: Gemeldet, Bergung bevorstehend, Geborgen, Verschollen
    private double breitengrad = 0.0; // Position Breitengrad des Geisternetzes
    private double laengengrad = 0.0; // Position Längengrad des Geisternetzes
    private int groesse = 0; // Größe des Geisternetzes: Anzugeben in Kubikmeter

    public Geisternetz(int id, Date registriert, Date geaendert, Date gesichtet, String status, double breitengrad, double laengengrad, int groesse)
    {
        this.id = id;
        this.registriert = registriert;
        this.geaendert = geaendert;
        this.gesichtet = gesichtet;
        this.status = status;
        this.breitengrad = breitengrad;
        this.laengengrad = laengengrad;
        this.groesse = groesse;
    }

    // Getter und Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    public Date getRegistriert() {
        return registriert;
    }

    public void setRegistriert(Date registriert) {
        this.registriert = registriert;
    }

    public Date getGeaendert() {
        return geaendert;
    }

    public void setGeaendert(Date geaendert) {
        this.geaendert = geaendert;
    }

    public Date getGesichtet() {
        return gesichtet;
    }

    public void setGesichtet(Date gesichtet) {
        this.gesichtet = gesichtet;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public double getBreitengrad() {
        return breitengrad;
    }

    public void setBreitengrad(double breitengrad) {
        this.breitengrad = breitengrad;
    }

    public double getLaengengrad() {
        return laengengrad;
    }

    public void setLaengengrad(double laengengrad) {
        this.laengengrad = laengengrad;
    }

    public int getGroesse() {
        return groesse;
    }

    public void setGroesse(int groesse) {
        this.groesse = groesse;
    }
}