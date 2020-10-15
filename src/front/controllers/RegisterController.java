package front.controllers;

import business.UserBusiness;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import common.VO.User;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class RegisterController {
    public JFXButton btnClose;
    public JFXButton btnCreate;
    public JFXTextField txtEmail;
    public JFXTextField txtUsername;
    public JFXTextField txtPassword;

    private void ReturnToLogin() throws IOException {
        Stage mainStage = (Stage)btnClose.getScene().getWindow();
        mainStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("../views/LoginWindow.fxml"));
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
        User newUser = new User();
        newUser.setEmail(txtEmail.getText());
        newUser.setUsername(txtUsername.getText());
        newUser.setPassword(txtPassword.getText());

        UserBusiness UB = new UserBusiness();
        UB.createUser(newUser);

        ReturnToLogin();
    }

}
