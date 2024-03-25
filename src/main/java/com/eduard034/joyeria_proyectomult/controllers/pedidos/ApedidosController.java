package com.eduard034.joyeria_proyectomult.controllers.pedidos;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ApedidosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Icantidadjoyas;

    @FXML
    private TextField Icontactocliente;

    @FXML
    private TextField Ifecha;

    @FXML
    private TextField Ihora;

    @FXML
    private TextField Inombrecliente;

    @FXML
    private TextField Itiposdejoya;

    @FXML
    private Button bttnagregarp;

    @FXML
    private Button bttnsalirap;

    @FXML
    void bttnagregarp(MouseEvent event) {

    }

    @FXML
    void bttnsalirap(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Icantidadjoyas != null : "fx:id=\"Icantidadjoyas\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert Icontactocliente != null : "fx:id=\"Icontactocliente\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert Ifecha != null : "fx:id=\"Ifecha\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert Ihora != null : "fx:id=\"Ihora\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert Inombrecliente != null : "fx:id=\"Inombrecliente\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert Itiposdejoya != null : "fx:id=\"Itiposdejoya\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert bttnagregarp != null : "fx:id=\"bttnagregarp\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert bttnsalirap != null : "fx:id=\"bttnsalirap\" was not injected: check your FXML file 'AgregarP.fxml'.";

    }

}