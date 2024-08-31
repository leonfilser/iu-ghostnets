import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import java.util.List;

@Named
@ApplicationScoped
public class Webapp {

    private final static EntityManagerFactory emf = Persistence.createEntityManagerFactory("iu-ghostnets");

    public Webapp() {

    }

    public List<Ghostnet> getGhostnetList() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select g from Ghostnet g");
        List<Ghostnet> ghostnetList = q.getResultList();
        return ghostnetList;
    }

    void addGhostnet(Ghostnet ghostnet) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(ghostnet);
        em.getTransaction().commit();
        em.close();
    }

    public List<Reporter> getReporterList() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select r from Reporter r");
        List<Reporter> reporterList = q.getResultList();
        return reporterList;
    }

    void addReporter(Reporter reporter) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(reporter);
        em.getTransaction().commit();
        em.close();
    }

    public List<Salvager> getSalvagerList() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select s from Salvager s");
        List<Salvager> salvagerList = q.getResultList();
        return salvagerList;
    }

    void addSalvager(Salvager salvager) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.persist(salvager);
        em.getTransaction().commit();
        em.close();
    }
}