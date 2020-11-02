package front.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.stage.Stage;

public class RegisterSubjectsController {
    public JFXButton btnClose;
    public JFXButton btnSaveSubjects;
    public JFXComboBox cbSubject1;
    public JFXComboBox cbSubject2;
    public JFXComboBox cbSubject3;
    public JFXComboBox cbSubject4;
    public JFXComboBox cbSubject5;
    public JFXComboBox cbSubject6;


    public void btnClose_Click(){
        Stage LoginStage = (Stage) btnClose.getScene().getWindow();
        LoginStage.close();
    }

    public void btnSaveSubjects_Click(){

    }
}
