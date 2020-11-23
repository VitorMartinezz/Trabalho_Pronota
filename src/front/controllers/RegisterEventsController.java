package front.controllers;

import business.EventTypeBusiness;
import business.UserSubjectBusiness;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import common.Runtime.UserLoggedUtil;
import common.VO.Area;
import common.VO.EventTypes;
import common.VO.User;
import common.VO.UserSubject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.util.List;

public class RegisterEventsController {
    public JFXButton btnClose;
    public JFXTextField txtDataEvento;
    public JFXComboBox cbTipoEvento;
    public JFXComboBox cbSubjects;

    @FXML
    protected void initialize() {
        UserSubjectBusiness usb = new UserSubjectBusiness();
        User user = UserLoggedUtil.getSession();
        List<UserSubject> us = usb.getAll(user);
        txtDataEvento.setText("01/01/2020");

        ObservableList<UserSubject> options = FXCollections.observableArrayList(us);
        cbSubjects.setItems(options);
        cbSubjects.getSelectionModel().selectFirst();

        EventTypeBusiness et = new EventTypeBusiness();
        List<EventTypes> event_type = et.getEventType();

        ObservableList<EventTypes> options2 = FXCollections.observableArrayList(event_type);
        cbTipoEvento.setItems(options2);
        cbTipoEvento.getSelectionModel().selectFirst();
    }


    @FXML
    private void btnClose_Click(){
        Stage stage = (Stage)btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnSalvar_Click()
    {

    }

    @FXML
    private void btnLimpar_Click()
    {
        ClearAllFields();
    }

    private void ClearAllFields(){

        txtDataEvento.setText("");
        cbSubjects.getSelectionModel().select(-1);

    }
}
