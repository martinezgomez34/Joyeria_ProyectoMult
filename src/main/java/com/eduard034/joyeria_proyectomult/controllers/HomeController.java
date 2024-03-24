package com.eduard034.joyeria_proyectomult.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
public class HomeController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button exitHomeButton;

    @FXML
    private Button gastosButton;

    @FXML
    private Button joyasButton;

    @FXML
    private Button pedidosButton;

    @FXML
    private Button ventasButton;
    @FXML
    void onClickGastosButton(MouseEvent event) {
        JoyeriaApp.newStage("gastos.fxml","Gastos");
    }

    @FXML
    void onClickJoyasButton(MouseEvent event) {
        JoyeriaApp.newStage("joyas.fxml","Joyas");
    }

    @FXML
    void onClickPedidosButton(MouseEvent event) {
        JoyeriaApp.newStage("pedidos.fxml","Pedidos");
    }

    @FXML
    void onClickExitHome(MouseEvent event) { JoyeriaApp.getStageView().close();}

    @FXML
    void onClickVentasButton(MouseEvent event) {
        JoyeriaApp.newStage("ventas.fxml","Ventas");
    }

    @FXML
    void initialize() {

    }

}