package front.controllers;

import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import business.*;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import common.Runtime.UserLoggedUtil;
import common.VO.EventTypes;
import common.VO.UserSubject;
import common.VO.Subject;
import common.VO.User;
import common.VO.Event;
import common.VO.StudentEvent;
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

    private Date DateValidator(String date) {
        Date date1 = null;
        try {
            DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            date1 = (java.util.Date)formatter.parse(date);
        } catch (Exception e) {

            return null;
        }
        return date1;
    }
    @FXML
    private void btnSalvar_Click() {


        Date data = DateValidator (txtDataEvento.getText());
        EventTypes event_types = (EventTypes) cbTipoEvento.getSelectionModel().getSelectedItem();
        UserSubject users = (UserSubject) cbSubjects.getSelectionModel().getSelectedItem();

        Subject subject = new Subject();

        subject = users.getSubject();


        if (data == null || event_types == null) {
            return;
        }

        Event event = new Event();
        event.setEvent_date(data);
        event.setEvent_type(event_types);
        event.setSubject(subject);

        EventBusiness eb = new EventBusiness();

        eb.createEvent(event);

        StudentEvent student_event = new StudentEvent();

        student_event.setUser(UserLoggedUtil.getSession());
        student_event.setEvent(event);

        StudentEventBusiness seb = new StudentEventBusiness();

        seb.createStudentEvent(student_event);

        Stage LoginStage = (Stage) btnClose.getScene().getWindow();
        LoginStage.close();
    }

    @FXML
    private void btnLimpar_Click()
    {
        ClearAllFields();
    }

    private void ClearAllFields(){

        txtDataEvento.setText("");
        cbTipoEvento.getSelectionModel().select(-1);

    }
}
