package sample;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class RegisterController {
    public JFXButton btnClose;
    public JFXButton btnCreate;

    private void ReturnToLogin() throws IOException {
        Stage mainStage = (Stage)btnClose.getScene().getWindow();
        mainStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("LoginWindow.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Inicio");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    public void btnClose_Click() throws IOException {
        ReturnToLogin();
    }
    public void btnCreate_Click() throws IOException {
        ReturnToLogin();
    }

}
