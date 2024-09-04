import java.util.List;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class GhostnetDAO {
        
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("iu-ghostnets");

    public List<Ghostnet> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            Query q = em.createQuery("select g from Ghostnet g");
            return q.getResultList();
        }
    }

    void addNew(Ghostnet ghostnet) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(ghostnet);
            em.getTransaction().commit();
        }
    }

    @PreDestroy
    public void close() {
        emf.close();
    }
}