package front.controllers;

import business.UserBusiness;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import common.Runtime.BuildScreenUtil;
import common.Runtime.UserLoggedUtil;
import common.VO.User;
import front.Main;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginController {
    public JFXButton btnClose;
    public JFXButton btnLogin;
    public JFXButton btnRegister;
    public JFXPasswordField txtPassword;
    public JFXTextField txtEmail;
    public AnchorPane apLogin;

    public void btnClose_Click() {
        System.exit(0);
    }

    public void btnLogin_Click() throws IOException {

        UserBusiness Ub = new UserBusiness();
        User user = Ub.login(txtEmail.getText(), txtPassword.getText());

        if (user != null) {
            Stage LoginStage = (Stage) btnLogin.getScene().getWindow();
            LoginStage.close();

            UserLoggedUtil.setSession(user);

            FXMLLoader fxmlLoader = new FXMLLoader();
            Parent root = fxmlLoader.load(Main.class.getResource("views/MainWindow.fxml"));

            BuildScreenUtil.createScreen(root, "Inicio");
        } else {
            FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/dialogs/MessageDialogWindow.fxml"));
            Parent root = fxmlLoader.load();

            MessageDialogController controller = fxmlLoader.getController();
            controller.txtMessage.setText("E-mail ou senha inválidos");
            controller.txtHeader.setText("Erro no login");

            try{
                BuildScreenUtil.createScreen(root, "Error");
            } catch (Exception e) {
                System.out.println("");
            }
        }
    }

    public void btnRegister_Click() throws IOException {
        Stage LoginStage = (Stage) btnLogin.getScene().getWindow();
        LoginStage.close();
        Parent root = FXMLLoader.load(Main.class.getResource("views/RegisterWindow.fxml"));
        BuildScreenUtil.createScreen(root, "Cadastro");
    }
}
