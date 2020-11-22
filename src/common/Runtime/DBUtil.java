package common.Runtime;

import common.VO.Area;
import common.VO.GradeTypes;
import common.VO.Role;
import common.VO.Structure;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {
    private static void createRoles() {
        try {
            EntityManager em = SessionUtil.getSession();
            Role studentRole = new Role();
            studentRole.setId(1);
            studentRole.setDescription("Student");

            Role teacherRole = new Role();
            teacherRole.setId(2);
            teacherRole.setDescription("Teacher");

            em.getTransaction().begin();
            em.merge(studentRole);
            em.merge(teacherRole);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    private static void createArea() {
        try {
            EntityManager em = SessionUtil.getSession();

            Area areaEngComp = new Area();
            areaEngComp.setId(1);
            areaEngComp.setName("Eng. Computação");

            Area areaAdm = new Area();
            areaAdm.setId(2);
            areaAdm.setName("Administração");

            em.getTransaction().begin();
            em.merge(areaEngComp);
            em.merge(areaAdm);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    private static void createGradeTypes() {
        try {
            EntityManager em = SessionUtil.getSession();

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
            em.merge(n1);
            em.merge(n2);
            em.merge(af);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    private static void createStructure() {
        try {
            EntityManager em = SessionUtil.getSession();

            Structure structure = new Structure();
            structure.setActivityQnt(5);
            structure.setAverage(5);
            structure.setFormativa(true);
            structure.setId(1);
            structure.setPeriodQnt(2);
            structure.setStructure("FTT");
            structure.setSubjectQnt(12);

            em.getTransaction().begin();
            em.merge(structure);
            em.getTransaction().commit();
        } catch (Exception e) {
            System.out.print(e);
        }
    }

    public static void createBasicDB() {
        createArea();
        createGradeTypes();
        createRoles();
        createStructure();
    }
}
