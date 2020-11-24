package DAO;

import common.Runtime.SessionUtil;
import common.VO.Content;
import common.VO.Subject;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

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

    public static List<Content> getContentBySubject(Subject subject) {
        try {
            EntityManager em = SessionUtil.getSession();

            Query query = em.createQuery("from tbContents where subject_id = :subject").setParameter("subject", subject.getId());;
            List<Content> content = (List<Content>) query.getResultList();

            return content;
        } catch (Exception e) {
            return null;
        }
    }

    public static Content getContentById(int id) {
        try {
            EntityManager em = SessionUtil.getSession();

            Query query = em.createQuery("from tbContents where id = :id").setParameter("id", id);
            Content content = (Content) query.getSingleResult();

            return content;
        } catch (Exception e) {
            return null;
        }
    }
}
