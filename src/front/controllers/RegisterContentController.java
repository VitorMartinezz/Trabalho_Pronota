package front.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class RegisterContentController {
    public JFXButton btnClose;

    @FXML
    private void btnClose_Click(){
        Stage stage = (Stage)btnClose.getScene().getWindow();
        stage.close();
    }
}
