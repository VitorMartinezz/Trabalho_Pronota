package common.Runtime;

import common.VO.Area;
import common.VO.EventTypes;
import common.VO.GradeTypes;
import common.VO.Role;
import common.VO.Structure;
import common.VO.Subject;
import common.VO.User;

import javax.persistence.EntityManager;

public class DBUtil {
    private static void createRoles() {
        EntityManager em = SessionUtil.getSession();
        try {
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
            em.getTransaction().rollback();
        }
    }

    private static void createArea() {
        EntityManager em = SessionUtil.getSession();
        try {

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
            em.getTransaction().rollback();
        }
    }

    private static void createGradeTypes() {
        EntityManager em = SessionUtil.getSession();
        try {

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
            em.getTransaction().rollback();
        }
    }

    private static void createStructure() {
        EntityManager em = SessionUtil.getSession();
        try {

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
            em.getTransaction().rollback();
        }
    }

    private static void createEventsType() {
        EntityManager em = SessionUtil.getSession();
        try {
            EventTypes eventTypeStudyTime = new EventTypes();
            eventTypeStudyTime.setId(1);
            eventTypeStudyTime.setName("Horário de estudo");

            EventTypes eventTypeTest = new EventTypes();
            eventTypeTest.setId(2);
            eventTypeTest.setName("Provas");

            em.getTransaction().begin();
            em.merge(eventTypeStudyTime);
            em.merge(eventTypeTest);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    private static void createSubjects() {
        EntityManager em = SessionUtil.getSession();
        try {
            Area area = new Area();
            area.setId(1);

            Subject compiladores = new Subject();
            compiladores.setId(1); 
            compiladores.setDescription("COMPILADORES"); 
            compiladores.setName("COMPILADORES"); 
            compiladores.setArea(area);

            Subject cec = new Subject();
            cec.setId(2); 
            cec.setDescription("CONTABILIDADE E CUSTOS"); 
            cec.setName("CONTABILIDADE E CUSTOS"); 
            cec.setArea(area);

            Subject cea = new Subject();
            cea.setId(3); 
            cea.setDescription("CONTROLE E AUTOMAÇÃO"); 
            cea.setName("CONTROLE E AUTOMAÇÃO"); 
            cea.setArea(area);

            Subject ec = new Subject();
            ec.setId(4); 
            ec.setDescription("ECONOMIA"); 
            ec.setName("ECONOMIA"); 
            ec.setArea(area);

            Subject egsof = new Subject();
            egsof.setId(5); 
            egsof.setDescription("ENGENHARIA DE SOFTWARE"); 
            egsof.setName("ENGENHARIA DE SOFTWARE"); 
            egsof.setArea(area);

            em.getTransaction().begin();
            em.merge(compiladores);
            em.merge(cec);
            em.merge(cea);
            em.merge(ec);
            em.merge(egsof);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    private static void createUser() {
        EntityManager em = SessionUtil.getSession();
        try {
            Role roleStudent = new Role();
            roleStudent.setId(1);
            Role roleTeacher = new Role();
            roleTeacher.setId(2);

            User userStudent = new User();
            userStudent.setId(1);
            userStudent.setEmail("estudante@teste.com");
            userStudent.setUsername("O Melhor Estudante");
            userStudent.setPassword("$2a$10$kfiTaMf.gACACiE.xCXzZeWxv2GslldQPlXH/K.7s.o9MjQvXCVkG");
            userStudent.setRole(roleStudent);

            User userTeacher = new User();
            userTeacher.setId(2);
            userTeacher.setEmail("professor@teste.com");
            userTeacher.setUsername("O Melhor Professor");
            userTeacher.setPassword("$2a$10$kfiTaMf.gACACiE.xCXzZeWxv2GslldQPlXH/K.7s.o9MjQvXCVkG");
            userTeacher.setRole(roleTeacher);

            User userStudentTest = new User();
            userStudentTest.setId(3);
            userStudentTest.setEmail("ts@ts.com");
            userStudentTest.setUsername("Estudante Teste");
            userStudentTest.setPassword("$2a$10$kfiTaMf.gACACiE.xCXzZeWxv2GslldQPlXH/K.7s.o9MjQvXCVkG");
            userStudentTest.setRole(roleStudent);

            User userTeacherTest = new User();
            userTeacherTest.setId(4);
            userTeacherTest.setEmail("tt@tt.com");
            userTeacherTest.setUsername("Professor Teste");
            userTeacherTest.setPassword("$2a$10$kfiTaMf.gACACiE.xCXzZeWxv2GslldQPlXH/K.7s.o9MjQvXCVkG");
            userTeacherTest.setRole(roleTeacher);

            em.getTransaction().begin();
            em.merge(userStudent);
            em.merge(userTeacher);
            em.merge(userStudentTest);
            em.merge(userTeacherTest);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
        }
    }

    public static void createBasicDB() {
        createArea();
        createGradeTypes();
        createRoles();
        createStructure();
        createEventsType();
        createSubjects();
        createUser();
    }
}
