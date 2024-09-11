import java.util.List;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.NoResultException;
import jakarta.persistence.EntityManager;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;

public class UserDAO {
        
    private EntityManagerFactory emf = Persistence.createEntityManagerFactory("iu-ghostnets");

    // Check whether a user with the given email address already exists
    public boolean emailExists(String emailAddress) {
        try (EntityManager em = emf.createEntityManager()) {
            Query q = em.createQuery("select u from User u where u.emailAddress = :emailAddress");
            q.setParameter("emailAddress", emailAddress);
            
            try {
                q.getSingleResult();
                return true;
            }
            catch (NoResultException e) {
                return false;
            }
        }
    }

    // Check whether a user with the given phone number already exists
    public boolean phoneNumberExists(String phoneNumber) {
        try (EntityManager em = emf.createEntityManager()) {
            Query q = em.createQuery("select u from User u where u.phoneNumber = :phoneNumber");
            q.setParameter("phoneNumber", phoneNumber);
            
            try {
                q.getSingleResult();
                return true;
            }
            catch (NoResultException e) {
                return false;
            }
        }
    }

    // Registers a new user
    void register(User user) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
    }

    // Finds a user by email adress. Used for login 
    public User findByEmail(String emailAddress) {
        try (EntityManager em = emf.createEntityManager()) {
            Query q = em.createQuery("select u from User u where u.emailAddress = :emailAddress");
            q.setParameter("emailAddress", emailAddress);
            return (User) q.getSingleResult();
        }
    }
    
    @PreDestroy
    public void close() {
        emf.close();
    }
}