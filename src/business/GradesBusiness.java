package business;

import DAO.GradeMySQLDAO;
import DAO.UserSubjectMySQLDAO;
import common.VO.GradesUserSubject;
import common.VO.Subject;
import common.VO.User;
import common.VO.UserSubject;

import java.util.List;

public class GradesBusiness {
    public boolean create(GradesUserSubject gradesSubject) {
        return GradeMySQLDAO.insert(gradesSubject);
    }

    public List<GradesUserSubject> getAll(UserSubject user) {
        return GradeMySQLDAO.getGrades(user);
    }
    public GradesUserSubject getAf(UserSubject user){
        return GradeMySQLDAO.getAfGrades(user);
    }

}
