import java.util.List;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UserDAO {
        
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("iu-ghostnets");

    public List<User> findAll() {
        try (EntityManager em = emf.createEntityManager()) {
            Query q = em.createQuery("select u from User u");
            return q.getResultList();
       }
    }

    void addNew(User user) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
    }

    public User findByEmail(String emailAdress) {
        try (EntityManager em = emf.createEntityManager()) {
            Query q = em.createQuery("select u from User u where u.emailAdress = :emailAdress");
            q.setParameter("emailAdress", emailAdress);
            return (User) q.getSingleResult();
        }
    }

    @PreDestroy
    public void close() {
        emf.close();
    }
}