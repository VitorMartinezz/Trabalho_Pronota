package front.controllers;

import common.Runtime.UserLoggedUtil;
import javafx.fxml.FXML;
import javafx.scene.text.Text;

public class HomeViewController {
    public Text lblWelCome;

    @FXML
    protected void initialize() {
        lblWelCome.setText("     Bem Vindo, " + UserLoggedUtil.getSession().getUsername());
    }
}
