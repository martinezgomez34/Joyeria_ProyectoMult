package com.eduard034.joyeria_proyectomult.controllers.ventas;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BventasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Bpedidosmp;

    @FXML
    private Button bttnbuscarv;

    @FXML
    private Button bttnsalirbv;

    @FXML
    void bttnbuscarp(MouseEvent event) {
        JoyeriaApp.newStage("ModificarV.fxml","Modificar Ventas");
    }

    @FXML
    void bttnsalirbp(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Bpedidosmp != null : "fx:id=\"Bpedidosmp\" was not injected: check your FXML file 'BuscarV.fxml'.";
        assert bttnbuscarv != null : "fx:id=\"bttnbuscarv\" was not injected: check your FXML file 'BuscarV.fxml'.";
        assert bttnsalirbv != null : "fx:id=\"bttnsalirbv\" was not injected: check your FXML file 'BuscarV.fxml'.";

    }

}
