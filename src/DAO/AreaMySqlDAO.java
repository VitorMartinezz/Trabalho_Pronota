package DAO;

import common.Runtime.SessionUtil;
import common.VO.Area;
import common.VO.Subject;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class AreaMySqlDAO {
    public static List<Area> getAreas() {
        try {
            EntityManager em = SessionUtil.getSession();

            Query query = em.createQuery("from tbAreas");
            List<Area> subjects = (List<Area>) query.getResultList();

            return subjects;
        } catch (Exception e) {
            return null;
        }
    }
}
