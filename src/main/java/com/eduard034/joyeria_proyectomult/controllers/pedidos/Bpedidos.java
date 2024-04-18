package com.eduard034.joyeria_proyectomult.controllers.pedidos;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Pedid0s;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Bpedidos {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TextField Bpedidos;

    @FXML
    private Button bttnbuscarp;

    @FXML
    private Button bttnsalirbp;

    @FXML
    void bttnbuscarp(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        int Idbus = Integer.parseInt(Bpedidos.getText());
        for (Pedid0s buscar:date.getListapedidos()) {
            if (Idbus == buscar.getId()) {
                date.setIdbP(Idbus);
                JoyeriaApp.newStage("ModificarP.fxml","Modificar Pedido");
            }
        }
        Alert alerterrorp = new Alert(Alert.AlertType.ERROR);
        alerterrorp.setHeaderText("Error de busqueda");
        alerterrorp.setContentText("Ups... no se pudo encontrar su pedido");
        alerterrorp.showAndWait();

    }

    @FXML
    void bttnsalirbp(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert bttnbuscarp != null : "fx:id=\"bttnbuscarp\" was not injected: check your FXML file 'BuscarP.fxml'.";
        assert bttnsalirbp != null : "fx:id=\"bttnsalirbp\" was not injected: check your FXML file 'BuscarP.fxml'.";

    }

}
