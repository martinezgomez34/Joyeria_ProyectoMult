package com.eduard034.joyeria_proyectomult.controllers.gastos;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MgasstosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidadmj;

    @FXML
    private TextField Afechamg;

    @FXML
    private TextField Atipodegastomg;

    @FXML
    private Button bttnmodificarg;

    @FXML
    private TableColumn<Gasto, String> cantidadColumnM;

    @FXML
    private TableColumn<Gasto, String> descripcionColumnM;

    @FXML
    private TableColumn<Gasto, String> fechaColumnM;

    @FXML
    private TableColumn<Gasto, Integer> idColumnM;

    @FXML
    private TableView<Gasto> verLista;
    @FXML
    void onClickVerTablaM(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        int id = date.getIdBusqueda();
        verLista.getItems().clear();
        for (Gasto item: JoyeriaApp.getData().getListaGastos()) {
            if (item.getId()==id) {
                verLista.getItems().addAll(item);
            }
        }
    }
    @FXML
    void bttnmodificarg(MouseEvent event) {
        Database database = JoyeriaApp.getData();
        int id = database.getIdBusqueda();
        boolean idModificado = true;
        for (Gasto item: JoyeriaApp.getData().getListaGastos()) {
            if (item.getId()==id) {
                idModificado = false;
                String descripcionDGasto = Atipodegastomg.getText();
                String cantidadDGasto = Acantidadmj.getText();
                String fechaDGasto = Afechamg.getText();
                item.setDescripcionDGasto(descripcionDGasto);
                item.setCantidadDGasto(cantidadDGasto);
                item.setFechaDGasto(fechaDGasto);
                showAlert(Alert.AlertType.INFORMATION, "Modificado", "Se modifico correctamente.");
            }
        }
        if (idModificado) {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
        }
        JoyeriaApp.newStage("gastos.fxml","Gastos");
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
        idColumnM.setCellValueFactory(new PropertyValueFactory<>("id"));
        descripcionColumnM.setCellValueFactory(new PropertyValueFactory<>("descripcionDGasto"));
        cantidadColumnM.setCellValueFactory(new PropertyValueFactory<>("cantidadDGasto"));
        fechaColumnM.setCellValueFactory(new PropertyValueFactory<>("fechaDGasto"));
    }

}
