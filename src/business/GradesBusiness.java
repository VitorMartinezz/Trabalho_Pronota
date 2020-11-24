package business;

import DAO.GradeMySQLDAO;
import common.VO.GradesUserSubject;
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

    public void deleteByUserSubject(UserSubject gradesSubject) {
        List<GradesUserSubject> gUSList = this.getAll(gradesSubject);
        for(GradesUserSubject gus : gUSList) {
            GradeMySQLDAO.deleteSubject(gus);
        }
        
        return;
    }
}
