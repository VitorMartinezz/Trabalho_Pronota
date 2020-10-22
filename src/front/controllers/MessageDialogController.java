package front.controllers;

import com.jfoenix.controls.JFXButton;
import common.Runtime.BuildScreenUtil;
import javafx.fxml.FXML;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class MessageDialogController {
    public JFXButton btnClose;
    public JFXButton btnOk;
    public Text txtMessage;
    public Text txtHeader;

    @FXML
    protected void initialize() {
        txtMessage.setText(BuildScreenUtil.message);
    }

    public void btnClose_Click(){
        Stage MessageStage = (Stage) txtHeader.getScene().getWindow();
        MessageStage.close();
    }

    public void btnOk_Click(){
        Stage MessageStage = (Stage) txtHeader.getScene().getWindow();
        MessageStage.close();
    }
}
