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
import common.VO.User;
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

        UserSubjectBusiness USB = new UserSubjectBusiness();
        User user = UserLoggedUtil.getSession();
        List<UserSubject> US = USB.getAll(user);

        if(US.size() > 0) {
            int count = 0;
            
            for(UserSubject userBusiness: US) {
                Subject subject = userBusiness.getSubject();

                switch(count) {
                    case 0:
                        cbSubject1.getSelectionModel().select(options.indexOf(subject));
                        cbSubject1.setDisable(true);
                        break;
                    case 1:
                        cbSubject2.getSelectionModel().select(options.indexOf(subject));
                        cbSubject2.setDisable(true);
                        break;
                    case 2:
                        cbSubject3.getSelectionModel().select(options.indexOf(subject));
                        cbSubject3.setDisable(true);
                        break;
                    case 3:
                        cbSubject4.getSelectionModel().select(options.indexOf(subject));
                        cbSubject4.setDisable(true);
                        break;
                    case 4:
                        cbSubject5.getSelectionModel().select(options.indexOf(subject));
                        cbSubject5.setDisable(true);
                        break;
                    case 5:
                        cbSubject6.getSelectionModel().select(options.indexOf(subject));
                        cbSubject6.setDisable(true);
                        break;
                }
                count++;
            }
        }
    }

    public void btnClose_Click(){
        Stage LoginStage = (Stage) btnClose.getScene().getWindow();
        LoginStage.close();
    }

    public void btnLimpar_Click(){
        ClearAllFields();
    }

    private void ClearAllFields(){

        cbSubject1.getSelectionModel().select(-1);
        cbSubject2.getSelectionModel().select(-1);
        cbSubject3.getSelectionModel().select(-1);
        cbSubject4.getSelectionModel().select(-1);
        cbSubject5.getSelectionModel().select(-1);
        cbSubject6.getSelectionModel().select(-1);

    }

    public void btnSaveSubjects_Click(){
        Subject subject1 = (Subject) cbSubject1.getSelectionModel().getSelectedItem();
        Subject subject2 = (Subject) cbSubject2.getSelectionModel().getSelectedItem();
        Subject subject3 = (Subject) cbSubject3.getSelectionModel().getSelectedItem();
        Subject subject4 = (Subject) cbSubject4.getSelectionModel().getSelectedItem();
        Subject subject5 = (Subject) cbSubject5.getSelectionModel().getSelectedItem();
        Subject subject6 = (Subject) cbSubject6.getSelectionModel().getSelectedItem();

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
