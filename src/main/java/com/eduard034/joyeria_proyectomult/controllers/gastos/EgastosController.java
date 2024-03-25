package com.eduard034.joyeria_proyectomult.controllers.gastos;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EgastosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Beliminarp;

    @FXML
    private TextField Mgastoaeliminar;

    @FXML
    private Button bttneliminarg;

    @FXML
    private Button bttnsalireg;

    @FXML
    void bttneliminarg(MouseEvent event) {

    }

    @FXML
    void bttnsalireg(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Beliminarp != null : "fx:id=\"Beliminarp\" was not injected: check your FXML file 'EliminarG.fxml'.";
        assert Mgastoaeliminar != null : "fx:id=\"Mgastoaeliminar\" was not injected: check your FXML file 'EliminarG.fxml'.";
        assert bttneliminarg != null : "fx:id=\"bttneliminarg\" was not injected: check your FXML file 'EliminarG.fxml'.";
        assert bttnsalireg != null : "fx:id=\"bttnsalireg\" was not injected: check your FXML file 'EliminarG.fxml'.";

    }

}
