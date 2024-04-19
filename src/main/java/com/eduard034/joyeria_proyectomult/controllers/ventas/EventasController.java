package com.eduard034.joyeria_proyectomult.controllers.ventas;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Joya;
import com.eduard034.joyeria_proyectomult.models.Venta;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class EventasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Beliminarp;

    @FXML
    private Button bttneliminarv;

    @FXML
    private Button bttnsalirev;

    @FXML
    private TableColumn<Venta, Integer> cantidadColumn;

    @FXML
    private TableColumn<Venta, String> fechaColumn;

    @FXML
    private TableColumn<Venta, String> nombrecolumn;

    @FXML
    private TableColumn<Venta, String> tipoColumn;

    @FXML
    private TableColumn<Venta, String> totalColumn;

    @FXML
    private TableView<Venta> verLista;

    @FXML
    void bttneliminarv(MouseEvent event) {
        Database database = JoyeriaApp.getData();
        String nbusqueda = Beliminarp.getText();
        boolean busqueda = true;
        for (Venta item: JoyeriaApp.getData().getListaVenta()) {
            if (item.getNombreDCliente().equals(nbusqueda)) {
                busqueda = false;
                JoyeriaApp.getData().getListaVenta().remove(item);
                JoyeriaApp.newStage("ventas.fxml","Ventas");
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
    void bttnsalirev(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void onClickVerLista(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        verLista.getItems().clear();
        verLista.getItems().addAll(date.getListaVenta());
    }

    @FXML
    void initialize() {
        nombrecolumn.setCellValueFactory(new PropertyValueFactory<>("nombreDCliente"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaDVenta"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("totalGanancia"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipoDJoya"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidadDJoya"));
    }

}
