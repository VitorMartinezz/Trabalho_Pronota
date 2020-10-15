package front.controllers;

import com.jfoenix.controls.JFXButton;
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

    public void btnClose_Click() throws IOException {

        Stage mainStage = (Stage)btnClose.getScene().getWindow();
        mainStage.close();
        Parent root = FXMLLoader.load(getClass().getResource("../views/LoginWindow.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Inicio");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.show();
    }
    private void SwitchView(String ViewName) throws IOException {
        AnchorPane ap = FXMLLoader.load(getClass().getResource(ViewName));
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
