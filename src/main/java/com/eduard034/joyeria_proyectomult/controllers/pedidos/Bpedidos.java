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
        Database data = JoyeriaApp.getData();
        int idBusqueda = Integer.parseInt(Bpedidos.getText());
        boolean busqueda = true;
        for (Pedid0s ver: JoyeriaApp.getData().getListapedidos()) {
            if (ver.getId()==idBusqueda) {
                busqueda = false;
                data.setIdbP(idBusqueda);
                JoyeriaApp.newStage("ModificarG.fxml","Modificar Gastos");
            }
        }
        if (busqueda) {
            Alert alertagregar = new Alert(Alert.AlertType.INFORMATION);
            alertagregar.setHeaderText("Confirmacion");
            alertagregar.setContentText("Se ha agregado un nuevo pedido");
            alertagregar.showAndWait();

        }
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
