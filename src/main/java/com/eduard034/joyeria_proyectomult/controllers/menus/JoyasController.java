package com.eduard034.joyeria_proyectomult.controllers.menus;
import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
public class JoyasController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarJoyasButton;

    @FXML
    private Button eliminarJoyasButton;

    @FXML
    private Button exitJoyasButton;

    @FXML
    private Button modificarJoyasButton;

    @FXML
    void onClickAgregarJoyasButton(MouseEvent event) {
        JoyeriaApp.newStage("AgregarJ.fxml","Agregar joyas");
    }

    @FXML
    void onClickEliminarJoyasButton(MouseEvent event) {
        JoyeriaApp.newStage("EliminarJ.fxml","Eliminar joyas");
    }

    @FXML
    void onClickExitJoyasButton(MouseEvent event) {
        JoyeriaApp.newStage("home.fxml","Menu");
    }

    @FXML
    void onClickModificarJoyasButton(MouseEvent event) {
        JoyeriaApp.newStage("BuscarJ.fxml","Buscar joyas");
    }

    @FXML
    void initialize() {
        assert agregarJoyasButton != null : "fx:id=\"agregarJoyasButton\" was not injected: check your FXML file 'joyas.fxml'.";
        assert eliminarJoyasButton != null : "fx:id=\"eliminarJoyasButton\" was not injected: check your FXML file 'joyas.fxml'.";
        assert exitJoyasButton != null : "fx:id=\"exitJoyasButton\" was not injected: check your FXML file 'joyas.fxml'.";
        assert modificarJoyasButton != null : "fx:id=\"modificarJoyasButton\" was not injected: check your FXML file 'joyas.fxml'.";

    }

}
