package com.eduard034.joyeria_proyectomult.controllers.gastos;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MgasstosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidadmj;

    @FXML
    private TextField Afechamg;

    @FXML
    private TextField Atipodegastomg;

    @FXML
    private TextField Mgastomg;

    @FXML
    private Button bttnmodificarg;

    @FXML
    void bttnmodificarg(MouseEvent event) {
        JoyeriaApp.newStage("gastos.fxml","Gastos");
    }

    @FXML
    void initialize() {
        assert Acantidadmj != null : "fx:id=\"Acantidadmj\" was not injected: check your FXML file 'ModificarG.fxml'.";
        assert Afechamg != null : "fx:id=\"Afechamg\" was not injected: check your FXML file 'ModificarG.fxml'.";
        assert Atipodegastomg != null : "fx:id=\"Atipodegastomg\" was not injected: check your FXML file 'ModificarG.fxml'.";
        assert Mgastomg != null : "fx:id=\"Mgastomg\" was not injected: check your FXML file 'ModificarG.fxml'.";
        assert bttnmodificarg != null : "fx:id=\"bttnmodificarg\" was not injected: check your FXML file 'ModificarG.fxml'.";

    }

}
