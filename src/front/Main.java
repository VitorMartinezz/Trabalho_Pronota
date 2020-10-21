package front;

import common.VO.Role;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("views/LoginWindow.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        primaryStage.setTitle("Teste");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    private static void createRoles() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");
        EntityManager createEntityManager = emf.createEntityManager();

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
    }
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("teste");
        EntityManager createEntityManager = emf.createEntityManager();
        try{
            createRoles();
        } catch (Exception e){ }
        emf.close();
        launch(args);
    }
}
