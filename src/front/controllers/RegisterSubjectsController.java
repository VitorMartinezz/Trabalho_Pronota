package front.controllers;

import business.SubjectBusiness;
import business.UserBusiness;
import business.UserSubjectBusiness;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import common.Runtime.BuildScreenUtil;
import common.Runtime.UserLoggedUtil;
import common.VO.Area;
import common.VO.Subject;
import common.VO.UserSubject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.util.List;

public class RegisterSubjectsController {
    public JFXButton btnClose;
    public JFXButton btnSaveSubjects;
    public JFXComboBox cbSubject1;
    public JFXComboBox cbSubject2;
    public JFXComboBox cbSubject3;
    public JFXComboBox cbSubject4;
    public JFXComboBox cbSubject5;
    public JFXComboBox cbSubject6;

    @FXML
    protected void initialize() {
        SubjectBusiness sb = new SubjectBusiness();

        List<Subject> subjects = sb.getSubjects();

        ObservableList<Subject> options = FXCollections.observableArrayList(subjects);
        cbSubject1.setItems(options);
        cbSubject2.setItems(options);
        cbSubject3.setItems(options);
        cbSubject4.setItems(options);
        cbSubject5.setItems(options);
        cbSubject6.setItems(options);
    }

    public void btnClose_Click(){
        Stage LoginStage = (Stage) btnClose.getScene().getWindow();
        LoginStage.close();
    }

    public void btnSaveSubjects_Click(){
        Subject subject1 = (Subject) cbSubject1.getSelectionModel().getSelectedItem();
        Subject subject2 = (Subject) cbSubject2.getSelectionModel().getSelectedItem();
        Subject subject3 = (Subject) cbSubject3.getSelectionModel().getSelectedItem();
        Subject subject4 = (Subject) cbSubject4.getSelectionModel().getSelectedItem();
        Subject subject5 = (Subject) cbSubject5.getSelectionModel().getSelectedItem();
        Subject subject6 = (Subject) cbSubject6.getSelectionModel().getSelectedItem();

        // boolean isRepeated1 = subject1 != null && subject1.getId() == subject3.getId() || (subject2 != null && subject1.getId() == subject2.getId()) || subject1.getId() == subject4.getId() || subject1.getId() == subject5.getId() || subject1.getId() == subject6.getId();
        // boolean isRepeated2 = subject2 != null && (subject1 != null && subject1.getId() == subject2.getId()) || subject2.getId() == subject3.getId() || subject2.getId() == subject4.getId()|| subject2.getId() == subject5.getId()|| subject2.getId() == subject6.getId();
        // boolean isRepeated3 = subject3 != null && (subject2 != null && subject3.getId() == subject2.getId()) || subject1.getId() == subject3.getId() || subject3.getId() == subject4.getId()|| subject3.getId() == subject5.getId()|| subject3.getId() == subject6.getId();
        // boolean isRepeated4 = subject4 != null && (subject2 != null && subject4.getId() == subject2.getId()) || subject4.getId() == subject3.getId() || subject3.getId() == subject4.getId()|| subject4.getId() == subject5.getId()|| subject4.getId() == subject6.getId();
        // boolean isRepeated5 = subject5 != null && (subject2 != null && subject5.getId() == subject2.getId() || subject5.getId()) == subject3.getId() || subject5.getId() == subject4.getId()|| subject4.getId() == subject5.getId()|| subject5.getId() == subject6.getId();
        // boolean isRepeated6 = subject6 != null && (subject2 != null && subject6.getId() == subject2.getId()) || subject6.getId() == subject3.getId() || subject6.getId() == subject4.getId()|| subject4.getId() == subject6.getId()|| subject6.getId() == subject6.getId();

        // if(isRepeated1) {
        //     return;
        // }

        // if(isRepeated2) {
        //     return;
        // }

        // if(isRepeated3) {
        //     return;
        // }

        // if(isRepeated4) {
        //     return;
        // }

        // if(isRepeated5) {
        //     return;
        // }

        // if(isRepeated6) {
        //     return;
        // }

        UserSubjectBusiness ub = new UserSubjectBusiness();

        if(subject1 != null) {
            UserSubject us = new UserSubject();
            us.setUser(UserLoggedUtil.getSession());
            us.setSubject(subject1);

            ub.create(us);
        }

        if(subject2 != null) {
            UserSubject us = new UserSubject();
            us.setUser(UserLoggedUtil.getSession());
            us.setSubject(subject2);

            ub.create(us);
        }

        if(subject3 != null) {
            UserSubject us = new UserSubject();
            us.setUser(UserLoggedUtil.getSession());
            us.setSubject(subject3);

            ub.create(us);
        }

        if(subject4 != null) {
            UserSubject us = new UserSubject();
            us.setUser(UserLoggedUtil.getSession());
            us.setSubject(subject4);

            ub.create(us);
        }

        if(subject5 != null) {
            UserSubject us = new UserSubject();
            us.setUser(UserLoggedUtil.getSession());
            us.setSubject(subject5);

            ub.create(us);
        }

        if(subject6 != null) {
            UserSubject us = new UserSubject();
            us.setUser(UserLoggedUtil.getSession());
            us.setSubject(subject6);

            ub.create(us);
        }

        Stage LoginStage = (Stage) btnClose.getScene().getWindow();
        LoginStage.close();
    }
}
