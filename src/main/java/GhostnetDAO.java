import java.util.List;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.annotation.PreDestroy;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.inject.Named;

public class GhostnetDAO {
        
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("iu-ghostnets");

    public List<Ghostnet> ghostnetList() {
        try (EntityManager em = emf.createEntityManager()) {
            Query q = em.createQuery("select g from Ghostnet g");
            return q.getResultList();
        }
    }

    public void addGhostnet(Ghostnet ghostnet) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(ghostnet);
            em.getTransaction().commit();
        }
    }
    
    public void updateGhostnet(Ghostnet ghostnet) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(ghostnet);
            em.getTransaction().commit();
        }
    }
    
    public void deleteGhostnet(Integer ghostnetId) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            Ghostnet ghostnet = em.find(Ghostnet.class, ghostnetId);
            if (ghostnet != null) {
                em.remove(ghostnet);
            }
            em.getTransaction().commit();
        }
    }

    @PreDestroy
    public void close() {
        emf.close();
    }
}