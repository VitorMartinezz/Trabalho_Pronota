package front.controllers;

import business.StudentEventBusiness;
import com.jfoenix.controls.JFXButton;
import common.Runtime.BuildScreenUtil;
import common.Runtime.UserLoggedUtil;
import common.VO.StudentEvent;
import front.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import common.auxClasses.EventTableViewModel;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.List;

public class CalendarViewController {
    public JFXButton btnRegisterEvents;
    public JFXButton btnEdit;
    public JFXButton btnDelete;

    @FXML
    public TableView<EventTableViewModel> table;
    @FXML
    private TableColumn<EventTableViewModel, String> colEventType;
    @FXML
    private TableColumn<EventTableViewModel, String> colSubject;
    @FXML
    private TableColumn<EventTableViewModel, Integer> colDate;

    @FXML
    protected void initialize() {
        colEventType.setCellValueFactory(new PropertyValueFactory<>("type_event"));
        colSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        colDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        table.setItems(gradeList());
        btnDelete.setVisible(false);
        btnEdit.setVisible(false);
    }
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

    public ObservableList<EventTableViewModel> gradeList() {
        StudentEventBusiness SEB = new StudentEventBusiness();

        List<StudentEvent> StudentEvents = SEB.getAllByUser(UserLoggedUtil.getSession());

        ObservableList<EventTableViewModel> eventTableViewModel = FXCollections.observableArrayList();

        for (StudentEvent StudentEvent : StudentEvents) {
            eventTableViewModel.add(new EventTableViewModel(StudentEvent.getId(),
                     StudentEvent.getEvent().getEvent_type().getName(), StudentEvent.getEvent().getSubject().getName() , StudentEvent.getEvent().getEvent_date().toString()));
        }
        return eventTableViewModel;
    }
}
