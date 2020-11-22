package front.controllers;

import business.AreaBusiness;
import business.SubjectBusiness;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import common.Runtime.BuildScreenUtil;
import common.VO.Area;
import common.VO.Subject;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.stage.Stage;

import java.util.List;

public class CreateSubjectController {

    public JFXButton btnClose;
    public JFXButton btnSave;
    public JFXButton btnClearFields;
    public JFXTextField txtName;
    public JFXTextField txtDescription;
    public JFXComboBox cbArea;

    @FXML
    protected void initialize() {
        AreaBusiness ab = new AreaBusiness();
        List<Area> areas = ab.getAreas();

        ObservableList<Area> options = FXCollections.observableArrayList(areas);
        cbArea.setItems(options);
    }

    public void btnClose_Click() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void btnClearFields_Click() {

    }

    public void btnSave_Click() {
        String name = txtName.getText();
        String description = txtDescription.getText();
        Area area = (Area) cbArea.getSelectionModel().getSelectedItem();

        if (name.length() == 0 || description.length() == 0 || area == null) {
            return;
        }

        Subject subject = new Subject();
        subject.setName(name);
        subject.setArea(area);
        subject.setDescription(description);

        SubjectBusiness sb = new SubjectBusiness();

        sb.createSubject(subject);

        Stage LoginStage = (Stage) btnClose.getScene().getWindow();
        LoginStage.close();
    }
}
