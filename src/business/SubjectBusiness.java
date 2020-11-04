package business;

import DAO.SubjectMySQLDAO;
import common.VO.Subject;

public class SubjectBusiness {
    public boolean createSubject(Subject subject) {
        return SubjectMySQLDAO.insert(subject);
    }
}
