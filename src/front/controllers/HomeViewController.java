package front.controllers;

import business.GradesBusiness;
import business.UserSubjectBusiness;
import common.Runtime.UserLoggedUtil;
import common.VO.GradeTypes;
import common.VO.GradesUserSubject;
import common.VO.User;
import common.VO.UserSubject;
import javafx.fxml.FXML;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.text.Text;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HomeViewController {
    public Text lblWelCome;
    public BarChart bcGrades;

    @FXML
    protected void initialize() {
        lblWelCome.setText("     Bem Vindo, " + UserLoggedUtil.getSession().getUsername());
        getSubjects();
    }

    private void getSubjects(){
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("N1");

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("N2");

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("2ºN1");

        XYChart.Series series4 = new XYChart.Series();
        series4.setName("AF");

        XYChart.Series series5 = new XYChart.Series();
        series5.setName("2ºN2");

        UserSubjectBusiness usb = new UserSubjectBusiness();
        User user = UserLoggedUtil.getSession();
        List<UserSubject> us = usb.getAll(user);
        GradesBusiness gradesBusiness = new GradesBusiness();
        int i = 0;
        for (UserSubject uss : us){

            List<GradesUserSubject> grades = gradesBusiness.getAll(uss);

            for (GradesUserSubject x : grades){
                if(x.getGradeTypes().getId() == 1 && x.getSequence() == 1){
                    series1.getData().add(new XYChart.Data(uss.getSubject().getName(), x.getGrade()));
                }
                else if(x.getGradeTypes().getId() == 2 && x.getSequence() == 1){
                    series2.getData().add(new XYChart.Data(uss.getSubject().getName(),  x.getGrade()));
                }
                else if(x.getGradeTypes().getId() == 1 && x.getSequence() == 2){
                    series3.getData().add(new XYChart.Data(uss.getSubject().getName(),x.getGrade()));
                }
                else if(x.getGradeTypes().getId() == 2 && x.getSequence() == 2){
                    series5.getData().add(new XYChart.Data(uss.getSubject().getName(),x.getGrade()));
                }
                else {
                    series4.getData().add(new XYChart.Data(uss.getSubject().getName(),x.getGrade()));
                }
            }
        }
        initBarChart(series1,series2,series3,series4,series5);
    }


    private void initBarChart(XYChart.Series series1, XYChart.Series series2, XYChart.Series series3, XYChart.Series series4, XYChart.Series series5){
        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String,Number> bc =
                new BarChart<String,Number>(xAxis,yAxis);
        bc.setTitle("Notas");
        yAxis.setMaxHeight(10);
        xAxis.setLabel("Máterias");
        yAxis.setLabel("Notas");

        bcGrades.getData().addAll(series1,series2,series3,series4,series5);
    }
}
