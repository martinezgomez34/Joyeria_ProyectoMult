package com.eduard034.joyeria_proyectomult.controllers.ventas;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Joya;
import com.eduard034.joyeria_proyectomult.models.Venta;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BventasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Bpedidosmp;

    @FXML
    private Button bttnbuscarv;

    @FXML
    private Button bttnsalirbv;

    @FXML
    void bttnbuscarp(MouseEvent event) {
        Database database = JoyeriaApp.getData();
        String nbusqueda = Bpedidosmp.getText();
        boolean busqueda = true;
        for (Venta item: JoyeriaApp.getData().getListaVenta()) {
            if (item.getNombreDCliente()==nbusqueda) {
                busqueda = false;
                database.setNBusqueda(nbusqueda);
                JoyeriaApp.newStage("ModificarV.fxml","Modificar Ventas");
            }
        }
        if (busqueda) {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
        }
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void bttnsalirbp(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {

    }

}
