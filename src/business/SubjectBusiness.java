package business;

import DAO.SubjectMySQLDAO;
import common.VO.Subject;

import java.util.List;

public class SubjectBusiness {
    public boolean createSubject(Subject subject) {
        return SubjectMySQLDAO.insert(subject);
    }

    public List<Subject> getSubjects() {
        return SubjectMySQLDAO.getSubjects();
    }
}
