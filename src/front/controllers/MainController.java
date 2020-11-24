package front.controllers;

import com.jfoenix.controls.JFXButton;
import common.Runtime.BuildScreenUtil;
import common.Runtime.UserLoggedUtil;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import front.Main;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;

public class MainController {
    public AnchorPane apViewer;
    public JFXButton btnClose2;
    public JFXButton btnGrades;
    public JFXButton btnStudy;
    public JFXButton btnCalender;
    public JFXButton btnFeedback;
    public JFXButton btnHome;
    public FontAwesomeIcon icon1;
    public FontAwesomeIcon icon2;
    public FontAwesomeIcon icon3;
    public FontAwesomeIcon icon4;
    public FontAwesomeIcon icon5;

    @FXML
    protected void initialize() throws IOException {
        SwitchView("views/HomeView.fxml");
        resetColor();
        btnHome.setOpacity(1);
        icon1.setOpacity(1);
        if(UserLoggedUtil.getSession().getRole().getId() == 2){
            btnCalender.setVisible(false);
            btnFeedback.setVisible(false);
            icon4.setVisible(false);
            icon5.setVisible(false);
        }
        btnFeedback.setVisible(false);
        icon5.setVisible(false);
    }

    public void btnClose_Click() throws IOException {

        Stage mainStage = (Stage)btnClose2.getScene().getWindow();
        mainStage.close();
        Parent root = FXMLLoader.load(Main.class.getResource("views/LoginWindow.fxml"));
        UserLoggedUtil.cleanSession();
        BuildScreenUtil.createScreen(root, "Login");
    }

    private void SwitchView(String ViewName) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(ViewName));
        AnchorPane ap = fxmlLoader.load();
        if(ViewName == "views/GradesView.fxml")
            BuildScreenUtil.setGradesView((GradesViewController) fxmlLoader.getController());
        if(ViewName == "views/StudyView.fxml")
            BuildScreenUtil.setStudyView((StudyViewController) fxmlLoader.getController());
        if(ViewName == "views/CalenderView.fxml")
            BuildScreenUtil.setCalendarView((CalendarViewController) fxmlLoader.getController());
        apViewer.getChildren().removeAll();
        apViewer.getChildren().setAll(ap);
    }

    public void btnHome_Click() throws IOException {
        resetColor();
        btnHome.setOpacity(1);
        icon1.setOpacity(1);
        SwitchView("views/HomeView.fxml");
    }
    public void btnGrades_Click() throws IOException {
        resetColor();
        btnGrades.setOpacity(1);
        icon2.setOpacity(1);
        SwitchView("views/GradesView.fxml");
    }
    public void btnStudy_Click() throws IOException {
        resetColor();
        btnStudy.setOpacity(1);
        icon3.setOpacity(1);
        SwitchView("views/StudyView.fxml");
    }
    public void btnCalender_Click() throws IOException {
        resetColor();
        btnCalender.setOpacity(1);
        icon4.setOpacity(1);
        SwitchView("views/CalenderView.fxml");
    }
    public void btnFeedback_Click() throws IOException {
        resetColor();
        btnFeedback.setOpacity(1);
        icon5.setOpacity(1);
        SwitchView("views/FeedbackView.fxml");
    }

    private void resetColor(){
        btnHome.setOpacity(0.5);
        icon1.setOpacity(0.5);
        btnCalender.setOpacity(0.5);
        icon2.setOpacity(0.5);
        btnFeedback.setOpacity(0.5);
        icon3.setOpacity(0.5);
        btnGrades.setOpacity(0.5);
        icon4.setOpacity(0.5);
        btnStudy.setOpacity(0.5);
        icon5.setOpacity(0.5);
    }
}
