package front.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class LoginController {
    public JFXButton btnClose;
    public JFXButton btnLogin;
    public JFXButton btnRegister;
    public AnchorPane apLogin;
    public void btnClose_Click(){
        System.exit(0);
    }
    public void btnLogin_Click() throws IOException {
        Stage LoginStage = (Stage)btnLogin.getScene().getWindow();
        LoginStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("../views/MainWindow.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Inicio");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }
    public void btnRegister_Click() throws IOException {
        Stage LoginStage = (Stage)btnLogin.getScene().getWindow();
        LoginStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("../views/RegisterWindow.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Cadastro");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }
}
