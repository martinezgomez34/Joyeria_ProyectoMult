package com.eduard034.joyeria_proyectomult.controllers;
import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;

public class GastosController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarGastosButton;

    @FXML
    private Button eliminarGastosButton;

    @FXML
    private Button exitGastosButton;

    @FXML
    private Button modificarGastosButton;

    @FXML
    void onClickAgregarGastosButton(MouseEvent event) {
        JoyeriaApp.newStage("AgregarG.fxml","Agregar Gastos");
    }

    @FXML
    void onClickEliminarGastosButton(MouseEvent event) {
        JoyeriaApp.newStage("EliminarG.fxml","Eliminar Gastos");
    }

    @FXML
    void onClickExitGastosButton(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void onClickModificarGastosButton(MouseEvent event) {
        JoyeriaApp.newStage("BuscarG.fxml","Buscar Gastos");
    }

    @FXML
    void initialize() {
        assert agregarGastosButton != null : "fx:id=\"agregarGastosButton\" was not injected: check your FXML file 'gastos.fxml'.";
        assert eliminarGastosButton != null : "fx:id=\"eliminarGastosButton\" was not injected: check your FXML file 'gastos.fxml'.";
        assert exitGastosButton != null : "fx:id=\"exitGastosButton\" was not injected: check your FXML file 'gastos.fxml'.";
        assert modificarGastosButton != null : "fx:id=\"modificarGastosButton\" was not injected: check your FXML file 'gastos.fxml'.";

    }

}