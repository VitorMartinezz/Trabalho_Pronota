package front.controllers;

import com.jfoenix.controls.JFXButton;
import common.Runtime.BuildScreenUtil;
import common.Runtime.UserLoggedUtil;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class MainController {
    public AnchorPane apViewer;
    public JFXButton btnClose;
    public JFXButton btnGrades;
    public JFXButton btnStudy;
    public JFXButton btnCalender;
    public JFXButton btnFeedback;

    @FXML
    protected void initialize() throws IOException {
        SwitchView("../views/HomeView.fxml");
    }

    public void btnClose_Click() throws IOException {

        Stage mainStage = (Stage)btnClose.getScene().getWindow();
        mainStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("../views/LoginWindow.fxml"));
        UserLoggedUtil.cleanSession();
        BuildScreenUtil.createScreen(root, "Login");
    }

    private void SwitchView(String ViewName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(ViewName));
        AnchorPane ap = fxmlLoader.load();

        apViewer.getChildren().removeAll();
        apViewer.getChildren().setAll(ap);
    }

    public void btnHome_Click() throws IOException {
        SwitchView("../views/HomeView.fxml");
    }
    public void btnGrades_Click() throws IOException {
        SwitchView("../views/GradesView.fxml");
    }
    public void btnStudy_Click() throws IOException {
        SwitchView("../views/StudyView.fxml");
    }
    public void btnCalender_Click() throws IOException {
        SwitchView("../views/CalenderView.fxml");
    }
    public void btnFeedback_Click() throws IOException {
        SwitchView("../views/FeedbackView.fxml");
    }
}
