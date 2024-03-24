package com.eduard034.joyeria_proyectomult.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BgastosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Bgastosmg;

    @FXML
    private Button bttnbuscarg;

    @FXML
    private Button bttnsalirbg;

    @FXML
    void bttnbuscarg(MouseEvent event) {
        JoyeriaApp.newStage("ModificarG.fxml","Modificar Gastos");
    }

    @FXML
    void bttnsalirbg(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Bgastosmg != null : "fx:id=\"Bgastosmg\" was not injected: check your FXML file 'BuscarG.fxml'.";
        assert bttnbuscarg != null : "fx:id=\"bttnbuscarg\" was not injected: check your FXML file 'BuscarG.fxml'.";
        assert bttnsalirbg != null : "fx:id=\"bttnsalirbg\" was not injected: check your FXML file 'BuscarG.fxml'.";

    }

}
