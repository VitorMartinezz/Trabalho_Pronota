package common.Runtime;

import common.VO.Role;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBUtil {

    public static void createBasicDB() {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("pronotaDB");
        EntityManager createEntityManager = emf.createEntityManager();

        try {
            Role studentRole = new Role();
            studentRole.setId(1);
            studentRole.setDescription("Student");

            Role teacherRole = new Role();
            teacherRole.setId(2);
            teacherRole.setDescription("Teacher");

            createEntityManager.getTransaction().begin();
            createEntityManager.persist(studentRole);
            createEntityManager.persist(teacherRole);
            createEntityManager.getTransaction().commit();
        } catch (Exception e) {}
    }
}
