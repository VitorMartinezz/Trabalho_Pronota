package front.controllers;

import business.AreaBusiness;
import business.UserSubjectBusiness;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
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

public class RegisterGradesController {
    public JFXButton btnClose;
    public JFXTextField txtN1;
    public JFXTextField txtN2;
    public JFXTextField txtN12;
    public JFXTextField txtN22;
    public JFXTextField txtAF;
    public JFXComboBox cbSubjects;

    @FXML
    protected void initialize() {
        UserSubjectBusiness usb = new UserSubjectBusiness();
        User user = UserLoggedUtil.getSession();
        List<UserSubject> us = usb.getAll(user);

        ObservableList<UserSubject> options = FXCollections.observableArrayList(us);
        cbSubjects.setItems(options);
    }

    public void btnClose_Click(){
        Stage stage = (Stage)btnClose.getScene().getWindow();
        stage.close();
    }
}
