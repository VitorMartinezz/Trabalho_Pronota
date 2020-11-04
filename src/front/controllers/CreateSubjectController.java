package front.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.stage.Stage;

public class CreateSubjectController {

    public JFXButton btnClose;
    public JFXButton btnSave;
    public JFXButton btnClearFields;

    public void btnClose_Click(){
        Stage stage = (Stage)btnClose.getScene().getWindow();
        stage.close();
    }

    public void btnClearFields_Click(){

    }
}
