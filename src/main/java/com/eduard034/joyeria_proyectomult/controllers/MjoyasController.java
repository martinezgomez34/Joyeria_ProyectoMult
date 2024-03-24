package com.eduard034.joyeria_proyectomult.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MjoyasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidadmj;

    @FXML
    private TextField Adescripcionmj;

    @FXML
    private TextField Anombremj;

    @FXML
    private TextField Mjoyasmj;

    @FXML
    private Button bttnmodificarj;

    @FXML
    void bttnmodificarv(MouseEvent event) {
        JoyeriaApp.newStage("joyas.fxml","Joyas");
    }

    @FXML
    void initialize() {
        assert Acantidadmj != null : "fx:id=\"Acantidadmj\" was not injected: check your FXML file 'ModificarJ.fxml'.";
        assert Adescripcionmj != null : "fx:id=\"Adescripcionmj\" was not injected: check your FXML file 'ModificarJ.fxml'.";
        assert Anombremj != null : "fx:id=\"Anombremj\" was not injected: check your FXML file 'ModificarJ.fxml'.";
        assert Mjoyasmj != null : "fx:id=\"Mjoyasmj\" was not injected: check your FXML file 'ModificarJ.fxml'.";
        assert bttnmodificarj != null : "fx:id=\"bttnmodificarj\" was not injected: check your FXML file 'ModificarJ.fxml'.";

    }

}
