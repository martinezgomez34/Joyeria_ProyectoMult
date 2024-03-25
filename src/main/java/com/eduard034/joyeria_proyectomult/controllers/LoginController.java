package com.eduard034.joyeria_proyectomult.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.PlusMinusSlider;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField actualpswd;

    @FXML
    private Button bttnchangepswd;

    @FXML
    private Button bttniniciar;

    @FXML
    private ImageView imagen;

    @FXML
    private TextField ingresarpswd;

    @FXML
    private TextField nuevapswd;

    @FXML
    void bttnchangepswd(MouseEvent event) {
    }

    @FXML
    void bttniniciar(MouseEvent event) {
        JoyeriaApp.newStage("home.fxml", "home");
    }
    @FXML
    void bttnexit(MouseEvent event) {
        Platform.exit();
    }
    @FXML
    void initialize() {
        assert actualpswd != null : "fx:id=\"actualpswd\" was not injected: check your FXML file 'InicioSecion.fxml'.";
        assert bttnchangepswd != null : "fx:id=\"bttnchangepswd\" was not injected: check your FXML file 'InicioSecion.fxml'.";
        assert bttniniciar != null : "fx:id=\"bttniniciar\" was not injected: check your FXML file 'InicioSecion.fxml'.";
        assert imagen != null : "fx:id=\"imagen\" was not injected: check your FXML file 'InicioSecion.fxml'.";
        assert ingresarpswd != null : "fx:id=\"ingresarpswd\" was not injected: check your FXML file 'InicioSecion.fxml'.";
        assert nuevapswd != null : "fx:id=\"nuevapswd\" was not injected: check your FXML file 'InicioSecion.fxml'.";

    }

}
