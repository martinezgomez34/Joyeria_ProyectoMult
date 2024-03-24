package com.eduard034.joyeria_proyectomult.controllers;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class MventasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidaddejoyamv;

    @FXML
    private TextField Afechamv;

    @FXML
    private TextField Agananciamv;

    @FXML
    private TextField Anombremv;

    @FXML
    private TextField Atipodejoyamv;

    @FXML
    private TextField Mventasmv;

    @FXML
    private Button bttnmodificarv;

    @FXML
    void bttnmodificarv(MouseEvent event) {
        JoyeriaApp.newStage("ventas.fxml","Ventas");
    }

    @FXML
    void initialize() {
        assert Acantidaddejoyamv != null : "fx:id=\"Acantidaddejoyamv\" was not injected: check your FXML file 'ModificarV.fxml'.";
        assert Afechamv != null : "fx:id=\"Afechamv\" was not injected: check your FXML file 'ModificarV.fxml'.";
        assert Agananciamv != null : "fx:id=\"Agananciamv\" was not injected: check your FXML file 'ModificarV.fxml'.";
        assert Anombremv != null : "fx:id=\"Anombremv\" was not injected: check your FXML file 'ModificarV.fxml'.";
        assert Atipodejoyamv != null : "fx:id=\"Atipodejoyamv\" was not injected: check your FXML file 'ModificarV.fxml'.";
        assert Mventasmv != null : "fx:id=\"Mventasmv\" was not injected: check your FXML file 'ModificarV.fxml'.";
        assert bttnmodificarv != null : "fx:id=\"bttnmodificarv\" was not injected: check your FXML file 'ModificarV.fxml'.";

    }

}
