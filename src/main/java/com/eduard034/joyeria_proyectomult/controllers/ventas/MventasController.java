package com.eduard034.joyeria_proyectomult.controllers.ventas;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Venta;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MventasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidaddejoyamv;

    @FXML
    private TextField Afechamv;

    @FXML
    private TextField Agananciamv;

    @FXML
    private TextField Anombremv;

    @FXML
    private TextField Atipodejoyamv;

    @FXML
    private TextField Mventasmv;

    @FXML
    private Button bttnmodificarv;

    @FXML
    private TableColumn<Venta, Integer> cantidadColumn;

    @FXML
    private TableColumn<Venta, String> fechaColumn;

    @FXML
    private TableColumn<Venta, String> nombreColumn;

    @FXML
    private TableColumn<Venta, String> tipoColumn;

    @FXML
    private TableColumn<Venta, String> totalColumn;

    @FXML
    private TableView<Venta> verListasV;

    @FXML
    void bttnmodificarv(MouseEvent event) {
        Database database = JoyeriaApp.getData();
        String nbusqueda = database.getNBusqueda();
        boolean busqueda = true;
        for (Venta item: JoyeriaApp.getData().getListaVenta()) {
            if (item.getNombreDCliente().equals(nbusqueda)) {
                busqueda = false;
                String nombre = Anombremv.getText();
                String fecha = Afechamv.getText();
                String total = Agananciamv.getText();
                String tipo = Atipodejoyamv.getText();
                int cantidad = Integer.parseInt(Acantidaddejoyamv.getText());
                item.setNombreDCliente(nombre);
                item.setFechaDVenta(fecha);
                item.setTotalGanancia(total);
                item.setTipoDJoya(tipo);
                item.setCantidadDJoya(cantidad);
                showAlert(Alert.AlertType.INFORMATION, "Modificado", "Se modifico correctamente.");
            }
        }
        if (busqueda) {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el nombre.");
        }
        JoyeriaApp.newStage("ventas.fxml","Ventas");
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void onClickVerLista(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        verListasV.getItems().clear();
        verListasV.getItems().addAll(date.getListaVenta());
    }

    @FXML
    void initialize() {
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombreDCliente"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaDVenta"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("totalGanancia"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipoDJoya"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidadDJoya"));
    }

}

