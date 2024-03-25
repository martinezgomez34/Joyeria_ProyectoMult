package com.eduard034.joyeria_proyectomult.controllers.menus;
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
        JoyeriaApp.newStage("AgregarV.fxml","Agregar Ventas");
    }

    @FXML
    void onClickEliminarVentasButton(MouseEvent event) {
        JoyeriaApp.newStage("EliminarV.fxml","Eliminar Ventas");
    }

    @FXML
    void onClickExitVentasButton(MouseEvent event) {
        JoyeriaApp.newStage("home.fxml","Menu");
    }

    @FXML
    void onClickModificarVentasButton(MouseEvent event) {
        JoyeriaApp.newStage("BuscarV.fxml","Buscar Ventas");
    }

    @FXML
    void initialize() {
        assert agregarVentasButton != null : "fx:id=\"agregarVentasButton\" was not injected: check your FXML file 'ventas.fxml'.";
        assert eliminarVentasButton != null : "fx:id=\"eliminarVentasButton\" was not injected: check your FXML file 'ventas.fxml'.";
        assert exitVentasButton != null : "fx:id=\"exitVentasButton\" was not injected: check your FXML file 'ventas.fxml'.";
        assert modificarVentasButton != null : "fx:id=\"modificarVentasButton\" was not injected: check your FXML file 'ventas.fxml'.";

    }

}