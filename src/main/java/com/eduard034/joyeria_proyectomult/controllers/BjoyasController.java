package com.eduard034.joyeria_proyectomult.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BjoyasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Bjoyasmj;

    @FXML
    private Button bttnbuscarj;

    @FXML
    private Button bttnsalirbj;

    @FXML
    void bttnbuscarj(MouseEvent event) {
        JoyeriaApp.newStage("ModificarJ.fxml","Modificar Joyas");
    }

    @FXML
    void bttnsalirbj(MouseEvent event) {
    JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Bjoyasmj != null : "fx:id=\"Bjoyasmj\" was not injected: check your FXML file 'BuscarJ.fxml'.";
        assert bttnbuscarj != null : "fx:id=\"bttnbuscarj\" was not injected: check your FXML file 'BuscarJ.fxml'.";
        assert bttnsalirbj != null : "fx:id=\"bttnsalirbj\" was not injected: check your FXML file 'BuscarJ.fxml'.";

    }

}

