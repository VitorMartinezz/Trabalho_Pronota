package business;

import DAO.ContentMySQLDAO;
import DAO.EventMySQLDAO;
import common.VO.Content;
import common.VO.Event;
import common.VO.User;

import java.util.List;

public class EventBusiness {

    public boolean createEvent(Event event) {
        return EventMySQLDAO.insert(event);
    }

}
