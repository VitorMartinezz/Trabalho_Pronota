package business;

import DAO.EventTypeMySqlDAO;
import common.VO.EventTypes;

import java.util.List;

public class EventTypeBusiness {
    public List<EventTypes> getEventType()
    {
        return EventTypeMySqlDAO.getEventType();
    }
}
