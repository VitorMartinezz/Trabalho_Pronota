package front.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;

import business.ContentBusiness;
import business.SubjectBusiness;
import common.Runtime.BuildScreenUtil;
import common.VO.Content;
import common.VO.Subject;
import common.auxClasses.ContentTableViewModel;
import front.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import javafx.util.Callback;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class StudyViewController {
    public JFXButton btnRegisterContent;
    public JFXComboBox cbSubjects;

    @FXML
    public TableView<ContentTableViewModel> table;
    @FXML
    private TableColumn<ContentTableViewModel, String> colTitle;
    @FXML
    private TableColumn<ContentTableViewModel, String> colSubject;
    @FXML
    private TableColumn<ContentTableViewModel, Integer> colLikes;
    @FXML
    private TableColumn<ContentTableViewModel, String> colLink;
    @FXML
    private TableColumn<ContentTableViewModel, String> colFileName;

    @FXML
    protected void initialize() {
        SubjectBusiness SB = new SubjectBusiness();
        List<Subject> subjects = SB.getSubjects();

        ObservableList<Subject> options = FXCollections.observableArrayList(subjects);
        cbSubjects.setItems(options);
        cbSubjects.getSelectionModel().selectFirst();

        colSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        colTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        colLink.setCellValueFactory(new PropertyValueFactory<>("link"));
        colFileName.setCellValueFactory(new PropertyValueFactory<>("fileName"));
        colLikes.setCellValueFactory(new PropertyValueFactory<>("likes"));

        table.setItems(gradeList());
        addTableButtons();
    }
    
    @FXML
    private void onSubjectChange() {
        table.setItems(gradeList());
        addTableButtons();
    }

    public ObservableList<ContentTableViewModel> gradeList() {
        ContentBusiness CB = new ContentBusiness();

        Subject subject = (Subject) cbSubjects.getSelectionModel().getSelectedItem();

        List<Content> contents = CB.getAllBySubject(subject);

        ObservableList<ContentTableViewModel> contentTableViewModel = FXCollections.observableArrayList();

        for (Content content : contents) {
            contentTableViewModel.add(new ContentTableViewModel(content.getId(), content.getTitle(),
                    content.getSubject().getName(), content.getLink(), content.getFileName(), content.getLikes(), content.getContent()));
        }
        return contentTableViewModel;
    }

    public void addTableButtons() {
        ObservableList<TableColumn<ContentTableViewModel, ?>> col = table.getColumns();
        if(col.get(col.size() - 1).getText() == "Ações") {
            table.getColumns().remove(col.get(col.size() - 1));
        }
        
        TableColumn<ContentTableViewModel, Void> colBtn = new TableColumn("Ações");
        Callback<TableColumn<ContentTableViewModel, Void>, TableCell<ContentTableViewModel, Void>> cellFactory = new Callback<TableColumn<ContentTableViewModel, Void>, TableCell<ContentTableViewModel, Void>>() {
            @Override
            public TableCell<ContentTableViewModel, Void> call(final TableColumn<ContentTableViewModel, Void> param) {
                final TableCell<ContentTableViewModel, Void> cell = new TableCell<ContentTableViewModel, Void>() {

                    private final Button btn = new Button("Baixar");

                    {
                        btn.setOnAction((ActionEvent event) -> {
                            ContentTableViewModel data = getTableView().getItems().get(getIndex());
                            Stage stage = (Stage) btnRegisterContent.getScene().getWindow();

                            DirectoryChooser directoryChooser = new DirectoryChooser();
                            File selectedDirectory = directoryChooser.showDialog(stage);

                            if(selectedDirectory != null){
                                try (FileOutputStream stream = new FileOutputStream(selectedDirectory.getAbsolutePath() + "\\" + data.getFileName())) {
                                    stream.write(data.getContent());
                                    stream.close();
                                } catch(Exception e) {}
                            }
                        });
                    }

                    @Override
                    public void updateItem(Void item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            setGraphic(btn);
                        }
                    }
                };
                return cell;
            }  
        };

        colBtn.setCellFactory(cellFactory);

        table.getColumns().add(colBtn);
    }

    @FXML
    private void btnRegisterContent_Click() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("views/RegisterContent.fxml"));
        BuildScreenUtil.createScreen(root, "Cadastro de Conteudo");
    }
}
