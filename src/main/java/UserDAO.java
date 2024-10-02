import java.util.List;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityManager;
import jakarta.annotation.PreDestroy;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.PersistenceException;
import jakarta.persistence.TypedQuery;

/**
 * UserDAO
 * Provides methods to interact with User entities in the database
 */

public class UserDAO {

    private static EntityManagerFactory emf;

    private EntityManagerFactory getEntityManagerFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("iu-ghostnets");
        }
        return emf;
    }

    // Returns a list of all users in the database
    public List<User> userList() {
        EntityManager em = null;
        try {
            em = getEntityManagerFactory().createEntityManager();
            TypedQuery<User> q = em.createQuery("select u from User u", User.class);
            return q.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    // Adds an new user to the database
    public void addUser(User user) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = getEntityManagerFactory().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.persist(user);
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

    // Updates an existing user in the database
    public void updateUser(User user) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = getEntityManagerFactory().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            em.merge(user);
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

    // Deletes an user from the database
    public void deleteUser(Integer userId) {
        EntityManager em = null;
        EntityTransaction transaction = null;
        try {
            em = getEntityManagerFactory().createEntityManager();
            transaction = em.getTransaction();
            transaction.begin();
            User user = em.find(User.class, userId);
            if (user != null) {
                em.remove(user);
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