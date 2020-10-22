package common.Runtime;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class SessionUtil {
    private static EntityManager entityManager = null;

    public static EntityManager getSession() {
        if(entityManager == null) {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");
            entityManager = emf.createEntityManager();
        }

        return entityManager;
    }
}