package DAO;

import common.Runtime.LogUtil;
import common.Runtime.SessionUtil;
import common.VO.Subject;
import common.VO.User;

import javax.persistence.EntityManager;

public class SubjectMySQLDAO {
    public static boolean insert(Subject newSubject) {
        try {
            EntityManager em = SessionUtil.getSession();

            em.getTransaction().begin();
            em.persist(newSubject);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
