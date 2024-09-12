import java.util.List;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import jakarta.inject.Named;
import jakarta.enterprise.context.ApplicationScoped;

public class UserDAO {
        
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("iu-ghostnets");

    public List<User> userList() {
        try (EntityManager em = emf.createEntityManager()) {
            Query q = em.createQuery("select u from User u");
            return q.getResultList();
        }
    }

    public void addUser(User user) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.persist(user);
            em.getTransaction().commit();
        }
    }
    
    public void updateUser(User user) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
    }
    
    public void deleteUser(Integer userId) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            User user = em.find(User.class, userId);
            if (user != null) {
                em.remove(user);
            }
            em.getTransaction().commit();
        }
    }

    @PreDestroy
    public void close() {
        emf.close();
    }
}