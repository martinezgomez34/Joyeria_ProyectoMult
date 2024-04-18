package com.eduard034.joyeria_proyectomult.controllers.joyas;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import com.eduard034.joyeria_proyectomult.models.Joya;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BjoyasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Bjoyasmj;

    @FXML
    private Button bttnbuscarj;

    @FXML
    private Button bttnsalirbj;

    @FXML
    void bttnbuscarj(MouseEvent event) {
        Database database = JoyeriaApp.getData();
        int idBusqueda = Integer.parseInt(Bjoyasmj.getText());
        boolean busqueda = true;
        for (Joya item: JoyeriaApp.getData().getListaJoya()) {
            if (item.getIdJoya()==idBusqueda) {
                busqueda = false;
                database.setIdBusqueda(idBusqueda);
                JoyeriaApp.newStage("ModificarJ.fxml","Modificar Gastos");
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
    void bttnsalirbj(MouseEvent event) {
        JoyeriaApp.newStage("joyas.fxml","Menu de joyas");
    }

    @FXML
    void initialize() {

    }

}

