package com.eduard034.joyeria_proyectomult.controllers.gastos;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AgastosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Afechav;

    @FXML
    private TextField Agananciav;

    @FXML
    private TextField Anombreclientev;

    @FXML
    private Button bttnagregarg;

    @FXML
    private Button bttnsalirav;

    @FXML
    void bttnagregarg(MouseEvent event) {

    }

    @FXML
    void bttnsalirag(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Afechav != null : "fx:id=\"Afechav\" was not injected: check your FXML file 'AgregarG.fxml'.";
        assert Agananciav != null : "fx:id=\"Agananciav\" was not injected: check your FXML file 'AgregarG.fxml'.";
        assert Anombreclientev != null : "fx:id=\"Anombreclientev\" was not injected: check your FXML file 'AgregarG.fxml'.";
        assert bttnagregarg != null : "fx:id=\"bttnagregarg\" was not injected: check your FXML file 'AgregarG.fxml'.";
        assert bttnsalirav != null : "fx:id=\"bttnsalirav\" was not injected: check your FXML file 'AgregarG.fxml'.";

    }

}
