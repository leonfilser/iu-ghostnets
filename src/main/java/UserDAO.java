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

    // Gets the User ID by searchring for the Emailadress
    public Integer getIdByEmail(String emailAddress) {
        try (EntityManager em = emf.createEntityManager()) {
            Query q = em.createQuery("SELECT u.id FROM User u WHERE u.emailAddress = :emailAddress");
            q.setParameter("emailAddress", emailAddress);
            return (Integer) q.getSingleResult();
        }
    }

    // Gets a single user by its ID
    public User getUser(int id) {
        try (EntityManager em = emf.createEntityManager()) {
            Query q = em.createQuery("select u from User u where u.id = :id");
            q.setParameter("id", id);
            return (User) q.getSingleResult();
        }
    }

    // Sets a new user in the database
    public void setUser(User user) {
        try (EntityManager em = emf.createEntityManager()) {
            em.getTransaction().begin();
            em.merge(user);
            em.getTransaction().commit();
        }
    }
    
    @PreDestroy
    public void close() {
        emf.close();
    }
}