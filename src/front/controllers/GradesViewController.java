package front.controllers;

import business.GradesBusiness;
import business.UserSubjectBusiness;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import common.Runtime.BuildScreenUtil;
import common.Runtime.UserLoggedUtil;
import common.VO.GradesUserSubject;
import common.VO.User;
import common.VO.UserSubject;
import front.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.List;

public class GradesViewController {
    public JFXButton btnRegisterGrades;
    public JFXButton btnRegisterSubjects;
    public JFXButton btnCreateSubject;
    public JFXComboBox cbSubjects;
    public Text lbLastGrade;
    public Text lbFinalAverage;
    public Text lbMinimumRequired;
    public Text lbNeedToPass;
    private float n1 = 0;
    private float n2 = 0;
    private float n12 = 0;
    private float n22 = 0;
    private float af = 0;

    @FXML
    protected void initialize() {
        UserSubjectBusiness usb = new UserSubjectBusiness();
        User user = UserLoggedUtil.getSession();
        List<UserSubject> us = usb.getAll(user);

        ObservableList<UserSubject> options = FXCollections.observableArrayList(us);
        cbSubjects.setItems(options);
        cbSubjects.getSelectionModel().selectFirst();
        cbSubjects_Changed();
    }

    @FXML
    private void cbSubjects_Changed(){
        ClearFields();
        UserSubject userSubject = (UserSubject) cbSubjects.getSelectionModel().getSelectedItem();
        GradesBusiness gradesBusiness = new GradesBusiness();
        List<GradesUserSubject> grades = gradesBusiness.getAll(userSubject);
        populateGrades(grades);
        setLastGrade();
        setLbFinalAverage();
    }

    private void ClearFields(){
        n1 = 0;
        n2 = 0;
        n12 = 0;
        n22 = 0;
        af = 0;
        lbNeedToPass.setText("0");
        lbFinalAverage.setText("0");
        lbLastGrade.setText("0");
    }

    private void setLbNeedToPass(float result){
        if (result < 5){
            result = 5 - result;
            lbNeedToPass.setText(new DecimalFormat("##.##").format(result));
        }
        else{
            lbNeedToPass.setText("OK");
        }
    }

    private void setLbFinalAverage(){
        float m1 = 0;
        float m2 = 0;
        m1 = (float) ((n1 * 0.4) + (n2 * 0.6));
        m2 = (float) ((n12 * 0.2) + (af * 0.2) + (n22 * 0.6));
        float result = (m1 + m2) / 2;
        lbFinalAverage.setText(new DecimalFormat("##.##").format(result));
        setLbNeedToPass(result);
    }

    private void setLastGrade(){
        if(n1 != 0 && n2 == 0 && n12 == 0 && n22 == 0 && af == 0)
            lbLastGrade.setText(new DecimalFormat("##.##").format(n1));
        if(n1 != 0 && n2 != 0 && n12 == 0 && n22 == 0 && af == 0)
            lbLastGrade.setText(new DecimalFormat("##.##").format(n2));
        if(n1 != 0 && n2 != 0 && n12 != 0 && n22 == 0 && af == 0)
            lbLastGrade.setText(new DecimalFormat("##.##").format(n12));
        if(n1 != 0 && n2 != 0 && n12 != 0 && af != 0 && n22 == 0)
            lbLastGrade.setText(new DecimalFormat("##.##").format(af));
        if(n1 != 0 && n2 != 0 && n12 != 0 && af != 0 && n22 != 0)
            lbLastGrade.setText(new DecimalFormat("##.##").format(n22));

    }

    private void populateGrades(List<GradesUserSubject> grades){
        for (GradesUserSubject grade : grades){
            if(grade.getGradeTypes().getId() == 1 && grade.getSequence() == 1){
                n1 = grade.getGrade();
            }
            if(grade.getGradeTypes().getId() == 2 && grade.getSequence() == 1){
                n2 = grade.getGrade();
            }
            if(grade.getGradeTypes().getId() == 1 && grade.getSequence() == 2){
                n12 = grade.getGrade();
            }
            if(grade.getGradeTypes().getId() == 2 && grade.getSequence() == 2){
                n22 = grade.getGrade();
            }
            if(grade.getGradeTypes().getId() == 3 && grade.getSequence() == 2){
                af = grade.getGrade();
            }
        }
    }

    public void btnRegisterGrades_Click() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("views/RegisterGrades.fxml"));
        BuildScreenUtil.createScreen(root, "Cadastro de notas");
    }
    public void btnRegisterSubjects_Click() throws IOException{
        Parent root = FXMLLoader.load(Main.class.getResource("views/RegisterSubjects.fxml"));
        BuildScreenUtil.createScreen(root, "Cadastro de materias");
    }
    public void btnCreateSubject_Click() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("views/CreateSubject.fxml"));
        BuildScreenUtil.createScreen(root, "Cria materia");
    }
}

