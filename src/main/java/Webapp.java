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
        em.merge(ghostnet);
        em.getTransaction().commit();
        em.close();
    }

    public List<User> getUserList() {
        EntityManager em = emf.createEntityManager();
        Query q = em.createQuery("select u from User u");
        List<User> userList = q.getResultList();
        return userList;
    }

    void addUser(User user) {
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();
        em.merge(user);
        em.getTransaction().commit();
        em.close();
    }
}