package front.controllers;

import business.UserBusiness;
import com.jfoenix.validation.RequiredFieldValidator;
import common.VO.Role;
import common.VO.User;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import front.Main;
import front.services.validators.ConfirmPWValidator;
import front.services.validators.EmailValidator;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.time.LocalDateTime;

public class RegisterController {
    public JFXButton btnClose;
    public JFXButton btnCreate;
    public JFXTextField txtEmail;
    public JFXTextField txtUsername;
    public JFXPasswordField txtPassword;
    public JFXPasswordField txtConfirmPW;
    public JFXRadioButton rbStudent;
    public JFXRadioButton rbTeacher;

    public RegisterController() {
    }

    private void updateConfirmPWValidator() {
        txtConfirmPW.getValidators().remove(0);

        ConfirmPWValidator requiredFieldValidatorConfirmPW = new ConfirmPWValidator(txtPassword.getText(),"Senha não corresponde!");
        requiredFieldValidatorConfirmPW.setIcon(GlyphsDude.createIcon(FontAwesomeIcons.WARNING));

        txtConfirmPW.getValidators().add(requiredFieldValidatorConfirmPW);
    }

    private void validateAllFields() {
        txtEmail.validate();
        txtPassword.validate();
        txtUsername.validate();
        txtConfirmPW.validate();
    }

    private void createValidatorsForFields() {
        EmailValidator emailValidator = new EmailValidator("E-mail inválido!");
        emailValidator.setIcon(GlyphsDude.createIcon(FontAwesomeIcons.WARNING));

        txtEmail.getValidators().add(emailValidator);
        txtEmail.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                txtEmail.validate();
            }
        });

        RequiredFieldValidator requiredFieldValidatorUsername = new RequiredFieldValidator("Usuário inválido!");
        requiredFieldValidatorUsername.setIcon(GlyphsDude.createIcon(FontAwesomeIcons.WARNING));

        txtUsername.getValidators().add(requiredFieldValidatorUsername);
        txtUsername.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                txtUsername.validate();
            }
        });

        RequiredFieldValidator requiredFieldValidatorPassword = new RequiredFieldValidator("Senha inválida!");
        requiredFieldValidatorPassword.setIcon(GlyphsDude.createIcon(FontAwesomeIcons.WARNING));

        txtPassword.getValidators().add(requiredFieldValidatorPassword);
        txtPassword.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                txtPassword.validate();
            }
        });

        ConfirmPWValidator requiredFieldValidatorConfirmPW = new ConfirmPWValidator("","Senha não corresponde!");
        requiredFieldValidatorConfirmPW.setIcon(GlyphsDude.createIcon(FontAwesomeIcons.WARNING));

        txtConfirmPW.getValidators().add(requiredFieldValidatorConfirmPW);
        txtConfirmPW.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                updateConfirmPWValidator();
                txtConfirmPW.validate();
            }
        });
    }

    @FXML
    protected void initialize() {
        //Add Validators for textfields
        createValidatorsForFields();
    }

    private void ReturnToLogin() throws IOException {
        Stage mainStage = (Stage)btnClose.getScene().getWindow();
        mainStage.close();
        Parent root = FXMLLoader.load(Main.class.getResource("views/LoginWindow.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Inicio");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }

    public void btnBack_Click() throws IOException {
        ReturnToLogin();
    }

    public void btnClose_Click() throws IOException {
        System.exit(0);
    }

    public void btnCreate_Click() throws IOException {
        updateConfirmPWValidator();
        validateAllFields();

        if(!txtEmail.validate() || !txtPassword.validate() || !txtUsername.validate() || !txtConfirmPW.validate()) {
            return;
        } else {
            User newUser = new User();

            newUser.setEmail(txtEmail.getText());
            newUser.setUsername(txtUsername.getText());
            newUser.setPassword(txtPassword.getText());
            newUser.setCreatedAt(LocalDateTime.now());
            newUser.setRole(new Role());

            int id = 1;
            if(rbTeacher.isSelected()) {
                id = 2;
            }

            newUser.getRole().setId(id);

            UserBusiness UB = new UserBusiness();
            boolean wasCreated = UB.createUser(newUser);

            if(!wasCreated) {
                //TODO - Add error screen
            } else {
                ReturnToLogin();
            }
        }
    }

}
