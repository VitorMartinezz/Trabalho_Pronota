package front.controllers;

import business.GradesBusiness;
import business.UserSubjectBusiness;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import common.Runtime.BuildScreenUtil;
import common.Runtime.UserLoggedUtil;
import common.VO.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.util.List;

public class RegisterGradesController {
    public JFXButton btnClose;
    public JFXButton btnSave;
    public JFXButton btnClearFields;
    public JFXTextField txtN1;
    public JFXTextField txtN2;
    public JFXTextField txtN12;
    public JFXTextField txtN22;
    public JFXTextField txtAF;
    public JFXComboBox cbSubjects;
    public List<GradesUserSubject> LastGrades;

    @FXML
    protected void initialize() {
        UserSubjectBusiness usb = new UserSubjectBusiness();
        User user = UserLoggedUtil.getSession();
        List<UserSubject> us = usb.getAll(user);
        txtN1.setText("0");
        txtN2.setText("0");
        txtN12.setText("0");
        txtN22.setText("0");
        txtAF.setText("0");

        ObservableList<UserSubject> options = FXCollections.observableArrayList(us);
        cbSubjects.setItems(options);

        if(options.size() > 0) {
            cbSubjects.getSelectionModel().selectFirst();
        }
    }

    @FXML
    private void cbSubjects_Changed(){
        ClearAllFields();
        UpdateLastGrades();
    }

    private void UpdateLastGrades() {
        UserSubject userSubject = (UserSubject) cbSubjects.getSelectionModel().getSelectedItem();
        GradesBusiness gradesBusiness = new GradesBusiness();
        List<GradesUserSubject> grades = gradesBusiness.getAll(userSubject);
        LastGrades = grades;
        for (GradesUserSubject x : grades){
            if(x.getGradeTypes().getId() == 1 && x.getSequence() == 1){
                txtN1.setText(String.valueOf(x.getGrade()));
            }
            else if(x.getGradeTypes().getId() == 2 && x.getSequence() == 1){
                txtN2.setText(String.valueOf(x.getGrade()));
            }
            else if(x.getGradeTypes().getId() == 1 && x.getSequence() == 2){
                txtN12.setText(String.valueOf(x.getGrade()));
            }
            else if(x.getGradeTypes().getId() == 2 && x.getSequence() == 2){
                txtN22.setText(String.valueOf(x.getGrade()));
            }
            else {
                txtAF.setText(String.valueOf(x.getGrade()));
            }
        }
    }

    public void btnSave_Click(){
        UserSubject userSubject = (UserSubject) cbSubjects.getSelectionModel().getSelectedItem();
        if(userSubject == null){
            return;
        }
        Boolean isN1ok = false;
        Boolean isN2ok = false;
        Boolean isN12ok = false;
        Boolean isN22ok = false;
        Boolean isAFok = false;

        if(LastGrades != null) {
            for (GradesUserSubject grades : LastGrades) {
                if(grades.getGradeTypes().getId() == 1 && grades.getSequence() == 1){
                    GradesUserSubject gradesUserSubject = new GradesUserSubject();
                    gradesUserSubject.setId(grades.getId());
                    SaveGrades(userSubject,txtN1.getText().isEmpty() ? "0" : txtN1.getText(),1,1,gradesUserSubject);
                    isN1ok = true;
                }
                else if(grades.getGradeTypes().getId() == 2 && grades.getSequence() == 1){
                    GradesUserSubject gradesUserSubject = new GradesUserSubject();
                    gradesUserSubject.setId(grades.getId());
                    SaveGrades(userSubject,txtN2.getText().isEmpty() ? "0" : txtN2.getText(),2,1,gradesUserSubject);
                    isN2ok = true;
                }
                else if(grades.getGradeTypes().getId() == 1 && grades.getSequence() == 2){
                    GradesUserSubject gradesUserSubject = new GradesUserSubject();
                    gradesUserSubject.setId(grades.getId());
                    SaveGrades(userSubject,txtN12.getText().isEmpty() ? "0" : txtN12.getText(),1,2,gradesUserSubject);
                    isN12ok = true;
                }
                else if(grades.getGradeTypes().getId() == 2 && grades.getSequence() == 2){
                    GradesUserSubject gradesUserSubject = new GradesUserSubject();
                    gradesUserSubject.setId(grades.getId());
                    SaveGrades(userSubject,txtN22.getText().isEmpty() ? "0" : txtN22.getText(),2,2,gradesUserSubject);
                    isN22ok = true;
                }
                else {
                    for (UserSubject user : (List<UserSubject>)cbSubjects.getItems()){
                        GradesUserSubject gradesUserSubject = new GradesUserSubject();
                        GradesBusiness business = new GradesBusiness();
                        gradesUserSubject.setId(business.getAf(user).getId());
                        SaveGrades(user,txtAF.getText().isEmpty() ? "0" : txtAF.getText(),3,2, gradesUserSubject);
                    }
                    isAFok = true;
                }
            }
        }

        if(txtN1.getSelectedText() != null && isN1ok == false){
            GradesUserSubject gradesUserSubject = new GradesUserSubject();
            SaveGrades(userSubject,txtN1.getText().isEmpty() ? "0" : txtN1.getText(),1,1, gradesUserSubject);
        }
        if(txtN2.getSelectedText() != null && isN2ok == false){
            GradesUserSubject gradesUserSubject = new GradesUserSubject();
            SaveGrades(userSubject,txtN2.getText().isEmpty() ? "0" : txtN2.getText(),2,1, gradesUserSubject);
        }
        if(txtN12.getSelectedText() != null && isN12ok == false){
            GradesUserSubject gradesUserSubject = new GradesUserSubject();
            SaveGrades(userSubject,txtN12.getText().isEmpty() ? "0" : txtN12.getText(),1,2, gradesUserSubject);
        }
        if(txtN22.getSelectedText() != null && isN22ok == false){
            GradesUserSubject gradesUserSubject = new GradesUserSubject();
            SaveGrades(userSubject,txtN22.getText().isEmpty() ? "0" : txtN22.getText(),2,2, gradesUserSubject);
        }
        if(txtAF.getSelectedText() != null && isAFok == false){
            for (UserSubject user : (List<UserSubject>)cbSubjects.getItems()){
                GradesUserSubject gradesUserSubject = new GradesUserSubject();
                GradesBusiness business = new GradesBusiness();
                if(business.getAf(user) != null)
                    gradesUserSubject.setId(business.getAf(user).getId());
                SaveGrades(user,txtAF.getText().isEmpty() ? "0" : txtAF.getText(),3,2, gradesUserSubject);
            }
        }
        ClearAllFields();
        UpdateLastGrades();
    }



    private void SaveGrades(UserSubject user, String grade, int gradeType, int sequence, GradesUserSubject gradesUserSubject) {
        gradesUserSubject.setUserSubject(user);
        gradesUserSubject.setGradeTypes(populateGradeType(gradeType));
        gradesUserSubject.setGrade(Float.parseFloat(grade));
        gradesUserSubject.setSequence(sequence);
        gradesUserSubject.setPeriode(1);
        gradesUserSubject.setStructure(populateStructure(1));
        GradesBusiness gradesBusiness = new GradesBusiness();
        gradesBusiness.create(gradesUserSubject);
    }

    private Structure populateStructure(int type){
        Structure structure = new Structure();
        structure.setId(type);
        return structure;
    }

    private GradeTypes populateGradeType(int type){
        GradeTypes gradeType = new GradeTypes();
        gradeType.setId(type);
        return gradeType;
    }

    public void btnClearFields_Click(){
        ClearAllFields();
    }

    private void ClearAllFields(){
        txtN1.setText("");
        txtN2.setText("");
        txtN12.setText("");
        txtN22.setText("");
        txtAF.setText("");
    }

    public void btnClose_Click(){
        GradesViewController test = (GradesViewController) BuildScreenUtil.getGradesView();
        test.cbSubjects_Changed();
        test.table.setItems(test.gradeList());
        Stage stage = (Stage)btnClose.getScene().getWindow();
        stage.close();
    }
}
