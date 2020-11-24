package DAO;

import common.Runtime.SessionUtil;
import common.VO.Event;

import javax.persistence.EntityManager;
public class EventMySQLDAO {

    public static boolean insert(Event newEvent) {
        EntityManager em = SessionUtil.getSession();
        try {
            em.getTransaction().begin();
            em.persist(newEvent);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }


}
