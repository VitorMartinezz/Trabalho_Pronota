package front.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import common.Runtime.BuildScreenUtil;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;

public class GradesViewController {
    public JFXButton btnRegisterGrades;
    public JFXButton btnRegisterSubjects;
    public JFXButton btnCreateSubject;
    public JFXComboBox cbSubjects;
    public Text lbLastGrade;
    public Text lbFinalAverage;
    public Text lbMinimumRequired;
    public Text lbNeedToPass;

    public void btnRegisterGrades_Click() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/RegisterGrades.fxml"));
        BuildScreenUtil.createScreen(root, "Cadastro de notas");
    }
    public void btnRegisterSubjects_Click() throws IOException{
        Parent root = FXMLLoader.load(getClass().getResource("../views/RegisterSubjects.fxml"));
        BuildScreenUtil.createScreen(root, "Cadastro de materias");
    }
    public void btnCreateSubject_Click() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/CreateSubject.fxml"));
        BuildScreenUtil.createScreen(root, "Cria materia");
    }
}

