package front.controllers;

import business.GradesBusiness;
import business.UserSubjectBusiness;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import common.Runtime.BuildScreenUtil;
import common.Runtime.UserLoggedUtil;
import common.VO.GradesUserSubject;
import common.VO.User;
import common.VO.UserSubject;
import common.auxClasses.GradesTableViewModel;
import front.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class GradesViewController {
    public JFXButton btnRegisterGrades;
    public JFXButton btnRegisterSubjects;
    public JFXButton btnCreateSubject;
    public JFXComboBox cbSubjects;
    public Text lbLastGrade;
    public Text lbFinalAverage;
    public Text lbMinimumRequired;
    public Text lbNeedToPass;
    private float n1 = 0;
    private float n2 = 0;
    private float n12 = 0;
    private float n22 = 0;
    private float af = 0;

    @FXML
    public TableView<GradesTableViewModel> table;
    @FXML
    private TableColumn<GradesTableViewModel, Float> colSubject;
    @FXML
    private TableColumn<GradesTableViewModel, Float> colN11;
    @FXML
    private TableColumn<GradesTableViewModel, Float> colN21;
    @FXML
    private TableColumn<GradesTableViewModel, Float> colM1;
    @FXML
    private TableColumn<GradesTableViewModel, Float> colN12;
    @FXML
    private TableColumn<GradesTableViewModel, Float> colAF;
    @FXML
    private TableColumn<GradesTableViewModel, Float> colN22;
    @FXML
    private TableColumn<GradesTableViewModel, Float> colM2;
    @FXML
    private TableColumn<GradesTableViewModel, Float> colMF;

    @FXML
    protected void initialize() {
        UserSubjectBusiness usb = new UserSubjectBusiness();
        User user = UserLoggedUtil.getSession();
        List<UserSubject> us = usb.getAll(user);

        ObservableList<UserSubject> options = FXCollections.observableArrayList(us);
        cbSubjects.setItems(options);
        cbSubjects.getSelectionModel().selectFirst();
        cbSubjects_Changed();

        colSubject.setCellValueFactory(new PropertyValueFactory<>("subject"));
        colN11.setCellValueFactory(new PropertyValueFactory<>("n11"));
        colN21.setCellValueFactory(new PropertyValueFactory<>("n21"));
        colM1.setCellValueFactory(new PropertyValueFactory<>("M1"));
        colN12.setCellValueFactory(new PropertyValueFactory<>("n12"));
        colAF.setCellValueFactory(new PropertyValueFactory<>("AF"));
        colN22.setCellValueFactory(new PropertyValueFactory<>("n22"));
        colM2.setCellValueFactory(new PropertyValueFactory<>("M2"));
        colMF.setCellValueFactory(new PropertyValueFactory<>("MF"));

        table.setItems(gradeList());
        if (!us.isEmpty()) {
            cbSubjects_Changed();
        }

        if(UserLoggedUtil.getSession().getRole().getId() == 2){
            btnRegisterGrades.setDisable(true);
            btnRegisterSubjects.setDisable(true);
            cbSubjects.setDisable(true);
        }
        else{
            btnCreateSubject.setVisible(false);
        }
    }

    public ObservableList<GradesTableViewModel> gradeList() {
        GradesBusiness GB = new GradesBusiness();
        UserSubjectBusiness USB = new UserSubjectBusiness();

        User user = UserLoggedUtil.getSession();

        List<UserSubject> us = USB.getAll(user);

        List<List<GradesUserSubject>> gradesUserSubjectList = new ArrayList<List<GradesUserSubject>>();
        ObservableList<GradesTableViewModel> gradesTableViewModelList = FXCollections.observableArrayList();

        for (UserSubject auxUs : us) {
            List<GradesUserSubject> gradesUserSubjectList1 = GB.getAll(auxUs);
            if (gradesUserSubjectList1.size() > 0) {
                gradesUserSubjectList.add(gradesUserSubjectList1);
                String subject = gradesUserSubjectList1.get(0).getUserSubject().getSubject().getName();
                int id = gradesUserSubjectList1.get(0).getUserSubject().getSubject().getId();
                float n11 = 0, n21 = 0, n12 = 0, n22 = 0, AF = 0;

                for (GradesUserSubject gradesUserSubject : gradesUserSubjectList1) {
                    int gradeType = gradesUserSubject.getGradeTypes().getId();
                    int gradeSequence = gradesUserSubject.getSequence();

                    if (gradeType == 1 && gradeSequence == 1) {
                        n11 = gradesUserSubject.getGrade();
                    } else if (gradeType == 2 && gradeSequence == 1) {
                        n21 = gradesUserSubject.getGrade();
                    } else if (gradeType == 1 && gradeSequence == 2) {
                        n12 = gradesUserSubject.getGrade();
                    } else if (gradeType == 2 && gradeSequence == 2) {
                        n22 = gradesUserSubject.getGrade();
                    } else if (gradeType == 3 && gradeSequence == 2) {
                        AF = gradesUserSubject.getGrade();
                    }
                }

                gradesTableViewModelList.add(new GradesTableViewModel(id, false, subject, n11, n21, n12, n22, AF));
            }
        }
        return gradesTableViewModelList;

    }

    @FXML
    public void cbSubjects_Changed() {
        ClearFields();
        UserSubject userSubject = (UserSubject) cbSubjects.getSelectionModel().getSelectedItem();
        GradesBusiness gradesBusiness = new GradesBusiness();
        List<GradesUserSubject> grades = gradesBusiness.getAll(userSubject);
        populateGrades(grades);
        setLastGrade();
        setLbFinalAverage();
        int i = 0;
        for (GradesTableViewModel gtvm : table.getItems()) {
            int subjectId = userSubject.getSubject().getId();
            int modelId = gtvm.getId();
            if (subjectId == modelId) {
                table.getSelectionModel().select(i);
                break;
            }
            i++;
        }
    }

    private void ClearFields() {
        n1 = 0;
        n2 = 0;
        n12 = 0;
        n22 = 0;
        af = 0;
        lbNeedToPass.setText("0");
        lbFinalAverage.setText("0");
        lbLastGrade.setText("0");
    }

    private void setLbNeedToPass(float result) {
        if (result < 5) {
            result = 5 - result;
            lbNeedToPass.setText(new DecimalFormat("##.##").format(result));
        } else {
            lbNeedToPass.setText("OK");
        }
    }

    private void setLbFinalAverage() {
        float m1 = 0;
        float m2 = 0;
        m1 = (float) ((n1 * 0.4) + (n2 * 0.6));
        m2 = (float) ((n12 * 0.2) + (af * 0.2) + (n22 * 0.6));
        float result = (m1 + m2) / 2;
        lbFinalAverage.setText(new DecimalFormat("##.##").format(result));
        setLbNeedToPass(result);
    }

    private void setLastGrade() {
        if (n1 != 0 && n2 == 0 && n12 == 0 && n22 == 0 && af == 0)
            lbLastGrade.setText(new DecimalFormat("##.##").format(n1));
        if (n1 != 0 && n2 != 0 && n12 == 0 && n22 == 0 && af == 0)
            lbLastGrade.setText(new DecimalFormat("##.##").format(n2));
        if (n1 != 0 && n2 != 0 && n12 != 0 && n22 == 0 && af == 0)
            lbLastGrade.setText(new DecimalFormat("##.##").format(n12));
        if (n1 != 0 && n2 != 0 && n12 != 0 && af != 0 && n22 == 0)
            lbLastGrade.setText(new DecimalFormat("##.##").format(af));
        if (n1 != 0 && n2 != 0 && n12 != 0 && af != 0 && n22 != 0)
            lbLastGrade.setText(new DecimalFormat("##.##").format(n22));

    }

    private void populateGrades(List<GradesUserSubject> grades) {
        if (grades != null) {
            for (GradesUserSubject grade : grades) {
                if (grade.getGradeTypes().getId() == 1 && grade.getSequence() == 1) {
                    n1 = grade.getGrade();
                }
                if (grade.getGradeTypes().getId() == 2 && grade.getSequence() == 1) {
                    n2 = grade.getGrade();
                }
                if (grade.getGradeTypes().getId() == 1 && grade.getSequence() == 2) {
                    n12 = grade.getGrade();
                }
                if (grade.getGradeTypes().getId() == 2 && grade.getSequence() == 2) {
                    n22 = grade.getGrade();
                }
                if (grade.getGradeTypes().getId() == 3 && grade.getSequence() == 2) {
                    af = grade.getGrade();
                }
            }
        }
    }

    public void btnRegisterGrades_Click() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("views/RegisterGrades.fxml"));
        BuildScreenUtil.createScreen(root, "Cadastro de notas");
    }

    public void btnRegisterSubjects_Click() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("views/RegisterSubjects.fxml"));
        BuildScreenUtil.createScreen(root, "Cadastro de materias");
    }

    public void btnCreateSubject_Click() throws IOException {
        Parent root = FXMLLoader.load(Main.class.getResource("views/CreateSubject.fxml"));
        BuildScreenUtil.createScreen(root, "Cria materia");
    }
}
