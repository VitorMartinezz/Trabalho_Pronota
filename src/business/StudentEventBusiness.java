package business;

import DAO.StudentEventMySQLDAO;
import common.VO.StudentEvent;
import common.VO.User;

import java.util.List;

public class StudentEventBusiness {
    public boolean createStudentEvent(StudentEvent se) {
        return StudentEventMySQLDAO.insert(se);
    }

    public List<StudentEvent> getAllByUser(User user)
    {
        return StudentEventMySQLDAO.getAllByUser(user);
    }
}
