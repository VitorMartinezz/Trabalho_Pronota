package front.controllers;

import com.jfoenix.controls.JFXButton;
import common.Runtime.BuildScreenUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class StudyViewController {
    public JFXButton btnRegisterContent;

    @FXML
    private void btnRegisterContent_Click() throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/RegisterContent.fxml"));
        BuildScreenUtil.createScreen(root, "Cadastro de Conteudo");
    }
}
