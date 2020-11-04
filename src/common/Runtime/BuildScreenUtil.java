package common.Runtime;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class BuildScreenUtil {
    public static String message = "";

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
