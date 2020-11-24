package business;

import DAO.EventMySQLDAO;
import common.VO.Event;

public class EventBusiness {

    public boolean createEvent(Event event) {
        return EventMySQLDAO.insert(event);
    }

}
