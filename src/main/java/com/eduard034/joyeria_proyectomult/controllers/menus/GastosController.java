package com.eduard034.joyeria_proyectomult.controllers.menus;
import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import com.eduard034.joyeria_proyectomult.models.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;

public class GastosController {

    @FXML
    private Button actualizar;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarGastosButton;

    @FXML
    private TableColumn<Gasto, String> cantidadColumn;

    @FXML
    private TableColumn<Gasto, String> descripcionColumn;

    @FXML
    private Button eliminarGastosButton;

    @FXML
    private Button exitGastosButton;

    @FXML
    private TableColumn<Gasto, String> fechaColumn;

    @FXML
    private TableColumn<Gasto, Integer> idColumn;


    @FXML
    private TableView<Gasto> verGasto;
    @FXML
    void onClickActualizar(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        verGasto.getItems().clear();
        verGasto.getItems().addAll(date.getListaGastos());
    }

    @FXML
    void onClickAgregarGastosButton(MouseEvent event) {
        JoyeriaApp.newStage("AgregarG.fxml","AgregarGastos");
    }

    @FXML
    void onClickEliminarGastosButton(MouseEvent event) {
        JoyeriaApp.newStage("EliminarG.fxml","EliminarGastos");
    }

    @FXML
    void onClickExitGastosButton(MouseEvent event) {
        JoyeriaApp.newStage("home.fxml","Menu");
    }

    @FXML
    void onClickModificarGastosButton(MouseEvent event) {
        JoyeriaApp.newStage("BuscarG.fxml","ModificarGastos");
    }

    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcionDGasto"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidadDGasto"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaDGasto"));
    }

}
