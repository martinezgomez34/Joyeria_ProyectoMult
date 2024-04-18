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

public class MjoyasController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidadmj;

    @FXML
    private TextField Adescripcionmj;

    @FXML
    private TextField Anombremj;

    @FXML
    private Button bttnmodificarj;

    @FXML
    private TableColumn<Joya, String> cantidadColumJ;

    @FXML
    private TableColumn<Joya, String> descripcionColumnJ;

    @FXML
    private TableColumn<Joya, String> idColumnJ;

    @FXML
    private TableColumn<Joya, String> nombreColumnJ;
    @FXML
    private TableView<Joya> verlistaJ;
    @FXML
    void onClickVerListaJ(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        int id = date.getIdBusqueda();
        verlistaJ.getItems().clear();
        for (Joya item: JoyeriaApp.getData().getListaJoya()) {
            if (item.getIdJoya()==id) {
                verlistaJ.getItems().addAll(item);
            }
        }
    }

    @FXML
    void bttnmodificarj(MouseEvent event) {
        Database database = JoyeriaApp.getData();
        int id = database.getIdBusqueda();
        boolean idModificado = true;
        for (Joya item: JoyeriaApp.getData().getListaJoya()) {
            if (item.getIdJoya()==id) {
                idModificado = false;
                String nombre = Anombremj.getText();
                String cantidad = Acantidadmj.getText();
                String descripcion = Adescripcionmj.getText();
                item.setNombreJoya(nombre);
                item.setCantidadDJoya(cantidad);
                item.setDescripcionDJoya(descripcion);
                showAlert(Alert.AlertType.INFORMATION, "Modificado", "Se modifico correctamente.");
            }
        }
        if (idModificado) {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
        }
        JoyeriaApp.newStage("joyas.fxml","Joyas");

    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        idColumnJ.setCellValueFactory(new PropertyValueFactory<>("idJoya"));
        nombreColumnJ.setCellValueFactory(new PropertyValueFactory<>("nombreJoya"));
        cantidadColumJ.setCellValueFactory(new PropertyValueFactory<>("cantidadDJoya"));
        descripcionColumnJ.setCellValueFactory(new PropertyValueFactory<>("descripcionDJoya"));

    }

}
