package com.eduard034.joyeria_proyectomult.controllers.gastos;

import java.net.URL;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.models.Database;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseEvent;
import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Gasto;
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
    private Button bttneliminarg;

    @FXML
    private Button bttnsalireg;

    @FXML
    private TableColumn<?, ?> cantidadColumnE;

    @FXML
    private TableColumn<?, ?> descripcionColumnE;

    @FXML
    private TableColumn<?, ?> fechaColumE;

    @FXML
    private TableColumn<?, ?> idColumnE;

    @FXML
    private TableView<?> verColumna;

    @FXML
    void bttneliminarg(MouseEvent event) {
        int ID = Integer.parseInt(Beliminarp.getText());
        boolean idElimidado = true;
        for (Gasto item: JoyeriaApp.getData().getListaGastos()) {
            if (item.getId()==ID) {
                idElimidado = false;
                JoyeriaApp.getData().getListaGastos().remove(item);
                showAlert(Alert.AlertType.INFORMATION, "Eliminado", "Se eliminó correctamente.");
            }
        }
        if (idElimidado) {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
        }
    }

    @FXML
    void bttnsalireg(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void verListaGastos(MouseEvent event) {

    }

    @FXML
    void initialize() {

    }

}
