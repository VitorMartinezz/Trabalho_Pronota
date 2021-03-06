package front.controllers;

import business.AreaBusiness;
import business.SubjectBusiness;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import common.VO.Area;
import common.VO.Subject;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
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
        cbArea.getSelectionModel().selectFirst();

        createValidatorsForFields();
    }

    private void createValidatorsForFields() {
        RequiredFieldValidator requiredFieldValidatorUsername = new RequiredFieldValidator("Nome Inválida!");
        requiredFieldValidatorUsername.setIcon(GlyphsDude.createIcon(FontAwesomeIcons.WARNING));

        txtName.getValidators().add(requiredFieldValidatorUsername);
        txtName.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                txtName.validate();
            }
        });

        RequiredFieldValidator requiredFieldValidatorPassword = new RequiredFieldValidator("Descrição Inválida!");
        requiredFieldValidatorPassword.setIcon(GlyphsDude.createIcon(FontAwesomeIcons.WARNING));

        txtDescription.getValidators().add(requiredFieldValidatorPassword);
        txtDescription.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                txtDescription.validate();
            }
        });
    }

    public void btnClose_Click() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    public void btnClearFields_Click() {
        ClearAllFields();
    }

    private void ClearAllFields(){

        txtName.setText("");
        txtDescription.setText("");
        cbArea.getSelectionModel().select(-1);

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
