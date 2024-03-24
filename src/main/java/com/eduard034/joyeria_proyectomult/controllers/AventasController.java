package com.eduard034.joyeria_proyectomult.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AventasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidadv;

    @FXML
    private TextField Afechav;

    @FXML
    private TextField Agananciav;

    @FXML
    private TextField Anombreclientev;

    @FXML
    private TextField Atipodejoyav;

    @FXML
    private Button bttnagregarv;

    @FXML
    private Button bttnsalirav;

    @FXML
    void bttnagregarv(MouseEvent event) {

    }

    @FXML
    void bttnsalirav(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Acantidadv != null : "fx:id=\"Acantidadv\" was not injected: check your FXML file 'AgregarV.fxml'.";
        assert Afechav != null : "fx:id=\"Afechav\" was not injected: check your FXML file 'AgregarV.fxml'.";
        assert Agananciav != null : "fx:id=\"Agananciav\" was not injected: check your FXML file 'AgregarV.fxml'.";
        assert Anombreclientev != null : "fx:id=\"Anombreclientev\" was not injected: check your FXML file 'AgregarV.fxml'.";
        assert Atipodejoyav != null : "fx:id=\"Atipodejoyav\" was not injected: check your FXML file 'AgregarV.fxml'.";
        assert bttnagregarv != null : "fx:id=\"bttnagregarv\" was not injected: check your FXML file 'AgregarV.fxml'.";
        assert bttnsalirav != null : "fx:id=\"bttnsalirav\" was not injected: check your FXML file 'AgregarV.fxml'.";

    }

}
