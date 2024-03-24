package com.eduard034.joyeria_proyectomult.controllers;
import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
public class PedidosController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarPedidosButton;

    @FXML
    private Button eliminarPedidosButton;

    @FXML
    private Button exitPedidosButton;

    @FXML
    private Button modificarPedidosButton;

    @FXML
    void onClickAgregarPedidosButton(MouseEvent event) {
    JoyeriaApp.newStage("AgregarP.fxml","AgregarPedidos");
    }

    @FXML
    void onClickEliminarPedidosButton(MouseEvent event) {
    JoyeriaApp.newStage("EliminarP.fxml","EliminarPedidos");
    }

    @FXML
    void onClickExitPedidosButton(MouseEvent event) {
        JoyeriaApp.newStage("home.fxml","home");
    }

    @FXML
    void onClickModificarPedidosButton(MouseEvent event) {
        JoyeriaApp.newStage("BuscarP.fxml","Buscar Pedidos Para Modificar");
    }

    @FXML
    void initialize() {
        assert agregarPedidosButton != null : "fx:id=\"agregarPedidosButton\" was not injected: check your FXML file 'pedidos.fxml'.";
        assert eliminarPedidosButton != null : "fx:id=\"eliminarPedidosButton\" was not injected: check your FXML file 'pedidos.fxml'.";
        assert exitPedidosButton != null : "fx:id=\"exitPedidosButton\" was not injected: check your FXML file 'pedidos.fxml'.";
        assert modificarPedidosButton != null : "fx:id=\"modificarPedidosButton\" was not injected: check your FXML file 'pedidos.fxml'.";

    }

}
