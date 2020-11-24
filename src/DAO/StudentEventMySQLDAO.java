package DAO;

import common.Runtime.SessionUtil;
import common.VO.StudentEvent;
import common.VO.User;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class StudentEventMySQLDAO {

    public static boolean insert(StudentEvent newStudentEvent) {
        EntityManager em = SessionUtil.getSession();
        try {

            em.getTransaction().begin();
            em.persist(newStudentEvent);
            em.getTransaction().commit();

            return true;
        } catch (Exception e) {
            em.getTransaction().rollback();
            return false;
        }
    }

    public static List<StudentEvent> getAllByUser(User user) {
        try {
            EntityManager em = SessionUtil.getSession();

            Query query = em.createQuery("from tbStudentEvent where user_id = :user").setParameter("user", user.getId());;
            List<StudentEvent> events = (List<StudentEvent>) query.getResultList();

            return events;
        } catch (Exception e) {
            return null;
        }
    }
}
