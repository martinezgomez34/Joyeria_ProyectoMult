package com.eduard034.joyeria_proyectomult.controllers.joyas;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EjoyasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Beliminarp;

    @FXML
    private TextField Mjoyaaeliminar;

    @FXML
    private Button bttneliminarj;

    @FXML
    private Button bttnsalirej;

    @FXML
    void bttneliminarv(MouseEvent event) {

    }

    @FXML
    void bttnsalirev(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Beliminarp != null : "fx:id=\"Beliminarp\" was not injected: check your FXML file 'EliminarJ.fxml'.";
        assert Mjoyaaeliminar != null : "fx:id=\"Mjoyaaeliminar\" was not injected: check your FXML file 'EliminarJ.fxml'.";
        assert bttneliminarj != null : "fx:id=\"bttneliminarj\" was not injected: check your FXML file 'EliminarJ.fxml'.";
        assert bttnsalirej != null : "fx:id=\"bttnsalirej\" was not injected: check your FXML file 'EliminarJ.fxml'.";

    }

}
