package front.controllers;

import com.jfoenix.controls.JFXButton;
import common.Runtime.BuildScreenUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class GradesViewController {
    public JFXButton btnRegisterGrades;
    public JFXButton btnRegisterSubjects;

    public void btnRegisterGrades_Click() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/RegisterGrades.fxml"));
        BuildScreenUtil.createScreen(root, "Cadastro de notas");
    }
    public void btnRegisterSubjects_Click() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../views/RegisterSubjects.fxml"));
        BuildScreenUtil.createScreen(root, "Cadastro de materias");
    }
}

