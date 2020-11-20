package common.Runtime;

import common.VO.Area;
import common.VO.GradeTypes;
import common.VO.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {

    public static void createBasicDB() {

        EntityManager em = SessionUtil.getSession();

        try {
            Role studentRole = new Role();
            studentRole.setId(1);
            studentRole.setDescription("Student");

            Role teacherRole = new Role();
            teacherRole.setId(2);
            teacherRole.setDescription("Teacher");

            Area areaEngComp = new Area();
            areaEngComp.setId(1);
            areaEngComp.setName("Eng. Computação");

            Area areaAdm = new Area();
            areaAdm.setId(2);
            areaAdm.setName("Administração");

            GradeTypes n1 = new GradeTypes();
            n1.setId(1);
            n1.setName("N1");

            GradeTypes n2 = new GradeTypes();
            n2.setId(2);
            n2.setName("N2");

            GradeTypes af = new GradeTypes();
            af.setId(3);
            af.setName("AF");

            em.getTransaction().begin();
            em.merge(areaEngComp);
            em.merge(areaAdm);
            em.merge(studentRole);
            em.merge(teacherRole);
            em.merge(n1);
            em.merge(n2);
            em.merge(af);
            em.getTransaction().commit();

        } catch (Exception e) {
            System.out.print(e);
        }
    }
}
