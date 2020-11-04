package front.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.stage.Stage;

public class RegisterGradesController {
    public JFXButton btnClose;

    public void btnClose_Click(){
        Stage stage = (Stage)btnClose.getScene().getWindow();
        stage.close();
    }
}
