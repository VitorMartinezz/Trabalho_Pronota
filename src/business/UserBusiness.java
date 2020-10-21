package business;

import common.Runtime.LogUtil;
import common.VO.User;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class UserBusiness {
    public boolean createUser(User newUser) {
        try{
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");
            EntityManager em = emf.createEntityManager();

            em.getTransaction().begin();
            em.persist(newUser);
            em.getTransaction().commit();

            Runnable createLogRunnable = () -> {
                LogUtil log = LogUtil.getLogsInstance();

                log.createLog(newUser, "Foi criado");
            };

            new Thread(createLogRunnable).start();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
