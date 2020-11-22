package DAO;

import common.Runtime.LogUtil;
import common.Runtime.SessionUtil;
import common.VO.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;

public class UserMySQLDAO {
    public static boolean insert(User newUser) {
        EntityManager em = SessionUtil.getSession();
        try {
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
            em.getTransaction().rollback();
            return false;
        }
    }

    public static User selectByEmail(String email) {
        try {
            EntityManager em = SessionUtil.getSession();

            Query query = em.createQuery("from tbUsers where email =:email ")
                    .setParameter("email", email);
            User user = (User) query.getSingleResult();
            return user;
        } catch (Exception e) {
            return null;
        }
    }
}
