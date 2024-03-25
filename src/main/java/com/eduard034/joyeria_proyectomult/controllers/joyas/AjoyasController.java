package com.eduard034.joyeria_proyectomult.controllers.joyas;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AjoyasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidadj;

    @FXML
    private TextField Adescripcionj;

    @FXML
    private TextField Anombrej;

    @FXML
    private Button bttnagregarj;

    @FXML
    private Button bttnsaliraj;

    @FXML
    void bttnagregarj(MouseEvent event) {

    }

    @FXML
    void bttnsaliraj(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Acantidadj != null : "fx:id=\"Acantidadj\" was not injected: check your FXML file 'AgregarJ.fxml'.";
        assert Adescripcionj != null : "fx:id=\"Adescripcionj\" was not injected: check your FXML file 'AgregarJ.fxml'.";
        assert Anombrej != null : "fx:id=\"Anombrej\" was not injected: check your FXML file 'AgregarJ.fxml'.";
        assert bttnagregarj != null : "fx:id=\"bttnagregarj\" was not injected: check your FXML file 'AgregarJ.fxml'.";
        assert bttnsaliraj != null : "fx:id=\"bttnsaliraj\" was not injected: check your FXML file 'AgregarJ.fxml'.";

    }

}
