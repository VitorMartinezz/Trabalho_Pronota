package DAO;

import common.Runtime.SessionUtil;
import common.VO.Subject;
import common.VO.UserSubject;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserSubjectMySQLDAO {
    public static boolean insert(UserSubject newUserSubject) {
        try {
            EntityManager em = SessionUtil.getSession();

            em.getTransaction().begin();
            em.persist(newUserSubject);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<UserSubject> getUserSubject() {
        try {
            EntityManager em = SessionUtil.getSession();

            Query query = em.createQuery("from tbUserSubjects");
            List<UserSubject> subjects = (List<UserSubject>) query.getResultList();

            return subjects;
        } catch (Exception e) {
            return null;
        }
    }

    public static Subject getSubject(int id) {
        try {
            EntityManager em = SessionUtil.getSession();

            Query query = em.createQuery("from tbUserSubjects where id = :id")
                    .setParameter("id", id);
            Subject subject = (Subject) query.getResultList();

            return subject;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean editSubject(UserSubject userSubject) {
        try {
            EntityManager em = SessionUtil.getSession();
            Session session = em.unwrap(Session.class);
            em.getTransaction().begin();
            session.update(userSubject);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean deleteSubject(UserSubject userSubject) {
        try {
            EntityManager em = SessionUtil.getSession();
            Session session = em.unwrap(Session.class);

            em.getTransaction().begin();
            session.delete(userSubject);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
