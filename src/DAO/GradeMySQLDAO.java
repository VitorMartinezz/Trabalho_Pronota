package DAO;

import common.Runtime.SessionUtil;
import common.VO.GradesUserSubject;
import common.VO.Subject;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class GradeMySQLDAO {
    public static boolean insert(GradesUserSubject newGradesUserSubject) {
        try {
            EntityManager em = SessionUtil.getSession();

            em.getTransaction().begin();
            em.persist(newGradesUserSubject);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<Subject> getSubjects() {
        try {
            EntityManager em = SessionUtil.getSession();

            Query query = em.createQuery("from tbSubjects");
            List<Subject> subjects = (List<Subject>) query.getResultList();

            return subjects;
        } catch (Exception e) {
            return null;
        }
    }

    public static Subject getSubject(int id) {
        try {
            EntityManager em = SessionUtil.getSession();

            Query query = em.createQuery("from tbSubjects where id = :id")
                    .setParameter("id", id);
            Subject subject = (Subject) query.getResultList();

            return subject;
        } catch (Exception e) {
            return null;
        }
    }

    public static boolean editSubject(Subject subject) {
        try {
            EntityManager em = SessionUtil.getSession();
            Session session = em.unwrap(Session.class);
            em.getTransaction().begin();
            session.update(subject);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static boolean deleteSubject(Subject subject) {
        try {
            EntityManager em = SessionUtil.getSession();
            Session session = em.unwrap(Session.class);

            em.getTransaction().begin();
            session.delete(subject);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
