package front.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.stage.Stage;

public class RegisterGradesController {
    public JFXButton btnClose;
    public JFXTextField txtN1;
    public JFXTextField txtN2;
    public JFXTextField txtN12;
    public JFXTextField txtN22;
    public JFXTextField txtAF;

    public void btnClose_Click(){
        Stage stage = (Stage)btnClose.getScene().getWindow();
        stage.close();
    }
}
