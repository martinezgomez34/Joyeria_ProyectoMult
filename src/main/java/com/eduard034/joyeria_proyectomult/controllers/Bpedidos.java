package com.eduard034.joyeria_proyectomult.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class Bpedidos {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bttnbuscarp;

    @FXML
    private Button bttnsalirbp;

    @FXML
    void bttnbuscarp(MouseEvent event) {
        JoyeriaApp.newStage("ModificarP.fxml","Modificar Pedido");
    }

    @FXML
    void bttnsalirbp(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert bttnbuscarp != null : "fx:id=\"bttnbuscarp\" was not injected: check your FXML file 'BuscarP.fxml'.";
        assert bttnsalirbp != null : "fx:id=\"bttnsalirbp\" was not injected: check your FXML file 'BuscarP.fxml'.";

    }

}
