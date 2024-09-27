import java.util.List;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

public class GhostnetDAO {

    private static EntityManagerFactory emf;

    private EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("iu-ghostnets");
        }
        return emf;
    }

    public List<Ghostnet> ghostnetList() {
        EntityManager em = null;
        try {
            em = getEntityManagerFactory().createEntityManager();
            TypedQuery<Ghostnet> q = em.createQuery("select g from Ghostnet g", Ghostnet.class);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void addGhostnet(Ghostnet ghostnet) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = getEntityManagerFactory().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(ghostnet);
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e; // Exception weiterleiten oder behandeln
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void updateGhostnet(Ghostnet ghostnet) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = getEntityManagerFactory().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(ghostnet);
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void deleteGhostnet(Integer ghostnetId) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = getEntityManagerFactory().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            Ghostnet ghostnet = em.find(Ghostnet.class, ghostnetId);
            if (ghostnet != null) {
                em.remove(ghostnet);
            }
            transaction.commit();
        } catch (PersistenceException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @PreDestroy
    public void close() {
        if (emf != null && emf.isOpen()) {
            emf.close();
        }
    }
}