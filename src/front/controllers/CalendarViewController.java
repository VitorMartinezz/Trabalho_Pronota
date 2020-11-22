package front.controllers;

import com.jfoenix.controls.JFXButton;
import common.Runtime.BuildScreenUtil;
import front.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class CalendarViewController {
    public JFXButton btnRegisterEvents;
    public JFXButton btnEdit;
    public JFXButton btnDelete;

    @FXML
    private void btnRegisterEvents_Click() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("views/RegisterEvents.fxml"));
        BuildScreenUtil.createScreen(root, "Cadastro de Eventos");
    }

    @FXML
    private void btnEdit_Click(){

    }

    @FXML
    private void btnDelete_Click(){

    }
}
