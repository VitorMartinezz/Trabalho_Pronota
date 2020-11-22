package DAO;

import common.Runtime.SessionUtil;
import common.VO.Content;
import common.VO.GradesUserSubject;

import javax.persistence.EntityManager;

public class ContentMySQLDAO {
    public static boolean insert(Content content) {
        EntityManager em = SessionUtil.getSession();
        try {
            em.getTransaction().begin();
            em.merge(content);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }
}
