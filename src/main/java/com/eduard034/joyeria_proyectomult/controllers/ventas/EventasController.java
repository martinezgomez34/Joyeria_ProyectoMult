package com.eduard034.joyeria_proyectomult.controllers.ventas;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EventasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Beliminarp;

    @FXML
    private TextField Mventaaeliminar;

    @FXML
    private Button bttneliminarv;

    @FXML
    private Button bttnsalirev;

    @FXML
    void bttneliminarv(MouseEvent event) {

    }

    @FXML
    void bttnsalirev(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Beliminarp != null : "fx:id=\"Beliminarp\" was not injected: check your FXML file 'EliminarV.fxml'.";
        assert Mventaaeliminar != null : "fx:id=\"Mventaaeliminar\" was not injected: check your FXML file 'EliminarV.fxml'.";
        assert bttneliminarv != null : "fx:id=\"bttneliminarv\" was not injected: check your FXML file 'EliminarV.fxml'.";
        assert bttnsalirev != null : "fx:id=\"bttnsalirev\" was not injected: check your FXML file 'EliminarV.fxml'.";

    }

}
