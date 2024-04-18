package com.eduard034.joyeria_proyectomult.controllers.joyas;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import com.eduard034.joyeria_proyectomult.models.Joya;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class EjoyasController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Beliminarp;

    @FXML
    private Button bttneliminarj;

    @FXML
    private Button bttnsalirej;

    @FXML
    private TableColumn<Joya, String> cantidadColumn;

    @FXML
    private TableColumn<Joya, String> descripcionColumnJ;

    @FXML
    private TableColumn<Joya, Integer> idColumnJ;

    @FXML
    private TableColumn<Joya, String> nombreColumnJ;

    @FXML
    private TableView<Joya> verLIstaJ;

    @FXML
    void bttneliminarv(MouseEvent event) {
        int ID = Integer.parseInt(Beliminarp.getText());
        boolean idElimidado = true;
        for (Joya item: JoyeriaApp.getData().getListaJoya()) {
            if (item.getIdJoya()==ID) {
                idElimidado = false;
                JoyeriaApp.getData().getListaGastos().remove(item);
                showAlert(Alert.AlertType.INFORMATION, "Eliminado", "Se eliminó correctamente.");
            }
        }
        if (idElimidado) {
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
    void bttnsalirev(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void onClickVerlistaJ(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        verLIstaJ.getItems().clear();
        verLIstaJ.getItems().addAll(date.getListaJoya());
    }

    @FXML
    void initialize() {
        idColumnJ.setCellValueFactory(new PropertyValueFactory<>("idJoya"));
        nombreColumnJ.setCellValueFactory(new PropertyValueFactory<>("nombreJoya"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidadDJoya"));
        descripcionColumnJ.setCellValueFactory(new PropertyValueFactory<>("descripcionDJoya"));
    }

}