package business;

import DAO.AreaMySqlDAO;
import common.VO.Area;

import java.util.List;

public class AreaBusiness {
    public List<Area> getAreas() {
        return AreaMySqlDAO.getAreas();
    }
}
