package front.controllers;

import java.util.List;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.validation.RequiredFieldValidator;

import business.ContentBusiness;
import business.SubjectBusiness;
import common.Runtime.BuildScreenUtil;
import common.Runtime.UserLoggedUtil;
import common.VO.Content;
import common.VO.Subject;
import common.VO.User;
import de.jensd.fx.glyphs.GlyphsDude;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcons;
import front.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.io.File;
import java.nio.file.Files;

public class RegisterContentController {
    public JFXButton btnClose;
    public JFXComboBox cbSubjects;
    public JFXTextField tfTitle;
    public JFXTextField tfLink;
    public File selectedFile;

    @FXML
    protected void initialize() {
        SubjectBusiness SB = new SubjectBusiness();
        List<Subject> subjects = SB.getSubjects();

        ObservableList<Subject> options = FXCollections.observableArrayList(subjects);
        cbSubjects.setItems(options);
        cbSubjects.getSelectionModel().selectFirst();

        createValidatorsForFields();
    }

    private void createValidatorsForFields() {
        RequiredFieldValidator requiredFieldValidatorUsername = new RequiredFieldValidator("Nome Inválido!");
        requiredFieldValidatorUsername.setIcon(GlyphsDude.createIcon(FontAwesomeIcons.WARNING));

        tfTitle.getValidators().add(requiredFieldValidatorUsername);
        tfTitle.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                tfTitle.validate();
            }
        });

        RequiredFieldValidator requiredFieldValidatorPassword = new RequiredFieldValidator("Link Inválido!");
        requiredFieldValidatorPassword.setIcon(GlyphsDude.createIcon(FontAwesomeIcons.WARNING));

        tfLink.getValidators().add(requiredFieldValidatorPassword);
        tfLink.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                tfLink.validate();
            }
        });
    }

    @FXML
    private void fileChooser_Click() {
        FileChooser fileChooser = new FileChooser();
        Stage stage = (Stage) btnClose.getScene().getWindow();

        fileChooser.setTitle("Selecione o arquivo");
        File file = fileChooser.showOpenDialog(stage);

        if (file != null) {
            selectedFile = file;
        }
    }

    @FXML
    private void btnClose_Click() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void btnSave_Click() {
        if (selectedFile == null) {
            return;
        }

        Content content = new Content();
        try {

            content.setTitle(tfTitle.getText());
            content.setLink(tfLink.getText());
            content.setLikes(0);
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            long size = Files.size(selectedFile.toPath());
            float sizeInKb = size / 1024;

            if(sizeInKb > 2000) {
                FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("views/dialogs/MessageDialogWindow.fxml"));
                Parent root = fxmlLoader.load();

                MessageDialogController controller = fxmlLoader.getController();
                controller.txtHeader.setText("ERRO");
                controller.txtMessage.setText("Arquivo tem mais de 2MB");

                try{
                    BuildScreenUtil.createScreen(root, "Error");
                } catch (Exception e) {
                    System.out.println("");
                }
                return;
            }

            byte[] fileContent = Files.readAllBytes(selectedFile.toPath());
            content.setContent(fileContent);
            content.setFileName(selectedFile.getName());
        } catch (Exception e) {
        }

        User user = UserLoggedUtil.getSession();
        content.setUser(user);

        Subject subject = (Subject) cbSubjects.getSelectionModel().getSelectedItem();
        content.setSubject(subject);

        ContentBusiness CB = new ContentBusiness();
        CB.create(content);

        StudyViewController stView = BuildScreenUtil.getStudyView();
        stView.table.setItems(stView.gradeList());
        stView.addTableButtons();
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }
}
