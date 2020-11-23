package DAO;

import common.Runtime.SessionUtil;
import common.VO.EventTypes;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class EventTypeMySqlDAO {
    public static List<EventTypes> getEventType() {
        try {
            EntityManager em = SessionUtil.getSession();

            Query query = em.createQuery("from tbEventTypes");
            List<EventTypes> event_type = (List<EventTypes>) query.getResultList();

            return event_type;
        } catch (Exception e) {
            return null;
        }
    }
}
