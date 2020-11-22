package common.Runtime;

import com.sun.org.apache.bcel.internal.util.ClassLoader;
import front.controllers.GradesViewController;
import front.controllers.RegisterGradesController;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BuildScreenUtil {
    public static String message = "";

    public static GradesViewController getGradesView() {
        return gradesView;
    }

    public static void setGradesView(GradesViewController currentView) {
        BuildScreenUtil.gradesView = currentView;
    }

    public static GradesViewController gradesView;


    public static void createScreen(Parent root, String title){
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage primaryStage = new Stage();
        primaryStage.setTitle(title);
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }
}
