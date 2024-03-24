package com.eduard034.joyeria_proyectomult.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MpedidosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidaddejoyasmp;

    @FXML
    private TextField Acontactomp;

    @FXML
    private TextField Afechamp;

    @FXML
    private TextField Ahoramp;

    @FXML
    private TextField Anombremp;

    @FXML
    private TextField Atipodejoyasmp;

    @FXML
    private TextField Mpedidospm;

    @FXML
    private Button bttnmodificarp;

    @FXML
    void bttnmodificarp(MouseEvent event) {
        JoyeriaApp.newStage("pedidos.fxml","Pedidos");
    }

    @FXML
    void initialize() {
        assert Acantidaddejoyasmp != null : "fx:id=\"Acantidaddejoyasmp\" was not injected: check your FXML file 'ModificarP.fxml'.";
        assert Acontactomp != null : "fx:id=\"Acontactomp\" was not injected: check your FXML file 'ModificarP.fxml'.";
        assert Afechamp != null : "fx:id=\"Afechamp\" was not injected: check your FXML file 'ModificarP.fxml'.";
        assert Ahoramp != null : "fx:id=\"Ahoramp\" was not injected: check your FXML file 'ModificarP.fxml'.";
        assert Anombremp != null : "fx:id=\"Anombremp\" was not injected: check your FXML file 'ModificarP.fxml'.";
        assert Atipodejoyasmp != null : "fx:id=\"Atipodejoyasmp\" was not injected: check your FXML file 'ModificarP.fxml'.";
        assert Mpedidospm != null : "fx:id=\"Mpedidospm\" was not injected: check your FXML file 'ModificarP.fxml'.";
        assert bttnmodificarp != null : "fx:id=\"bttnmodificarp\" was not injected: check your FXML file 'ModificarP.fxml'.";

    }

}
