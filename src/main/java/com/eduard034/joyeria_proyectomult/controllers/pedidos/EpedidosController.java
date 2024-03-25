package com.eduard034.joyeria_proyectomult.controllers.pedidos;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EpedidosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Beliminarp;

    @FXML
    private TextField Mpedidoaeliminar;

    @FXML
    private Button bttneliminarp;

    @FXML
    private Button bttnsalirep;

    @FXML
    void bttneliminarp(MouseEvent event) {

    }

    @FXML
    void bttnsalirep(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Beliminarp != null : "fx:id=\"Beliminarp\" was not injected: check your FXML file 'EliminarP.fxml'.";
        assert Mpedidoaeliminar != null : "fx:id=\"Mpedidoaeliminar\" was not injected: check your FXML file 'EliminarP.fxml'.";
        assert bttneliminarp != null : "fx:id=\"bttneliminarp\" was not injected: check your FXML file 'EliminarP.fxml'.";
        assert bttnsalirep != null : "fx:id=\"bttnsalirep\" was not injected: check your FXML file 'EliminarP.fxml'.";

    }

}
