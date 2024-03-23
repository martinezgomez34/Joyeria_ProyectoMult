package com.eduard034.joyeria_proyectomult.controllers;
import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
public class VentasController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarVentasButton;

    @FXML
    private Button eliminarVentasButton;

    @FXML
    private Button exitVentasButton;

    @FXML
    private Button modificarVentasButton;

    @FXML
    void onClickAgregarVentasButton(MouseEvent event) {

    }

    @FXML
    void onClickEliminarVentasButton(MouseEvent event) {

    }

    @FXML
    void onClickExitVentasButton(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void onClickModificarVentasButton(MouseEvent event) {

    }

    @FXML
    void initialize() {
        assert agregarVentasButton != null : "fx:id=\"agregarVentasButton\" was not injected: check your FXML file 'ventas.fxml'.";
        assert eliminarVentasButton != null : "fx:id=\"eliminarVentasButton\" was not injected: check your FXML file 'ventas.fxml'.";
        assert exitVentasButton != null : "fx:id=\"exitVentasButton\" was not injected: check your FXML file 'ventas.fxml'.";
        assert modificarVentasButton != null : "fx:id=\"modificarVentasButton\" was not injected: check your FXML file 'ventas.fxml'.";

    }

}