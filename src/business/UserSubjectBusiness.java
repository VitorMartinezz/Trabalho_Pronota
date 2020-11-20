package business;

import DAO.UserSubjectMySQLDAO;
import common.VO.User;
import common.VO.UserSubject;

import java.util.List;

public class UserSubjectBusiness {
    public boolean create(UserSubject userSubject) {
        return UserSubjectMySQLDAO.insert(userSubject);
    }

    public List<UserSubject> getAll(User user) {
        return UserSubjectMySQLDAO.getUserSubject(user);
    }
}
