package com.eduard034.joyeria_proyectomult.controllers.menus;
import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Venta;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
public class VentasController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarVentasButton;

    @FXML
    private TableColumn<String, Integer> cantidadColumn;

    @FXML
    private Button eliminarVentasButton;

    @FXML
    private Button exitVentasButton;

    @FXML
    private TableColumn<Venta, String> fechaColumn;

    @FXML
    private Button modificarVentasButton;

    @FXML
    private TableColumn<Venta, String> nombreColumn;

    @FXML
    private TableColumn<Venta, String> tipoColumn;

    @FXML
    private TableColumn<Venta, String> totalColumn;

    @FXML
    private TableView<Venta> verLista;

    @FXML
    void onClickAgregarVentasButton(MouseEvent event) {
        JoyeriaApp.newStage("AgregarV.fxml","Agregar Ventas");
    }

    @FXML
    void onClickEliminarVentasButton(MouseEvent event) {
        JoyeriaApp.newStage("EliminarV.fxml","Eliminar Ventas");
    }

    @FXML
    void onClickExitVentasButton(MouseEvent event) {
        JoyeriaApp.newStage("home.fxml","Menu");
    }

    @FXML
    void onClickModificarVentasButton(MouseEvent event) {
        JoyeriaApp.newStage("BuscarV.fxml","Buscar Ventas");
    }

    @FXML
    void onClickVerLista(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        verLista.getItems().clear();
        verLista.getItems().addAll(date.getListaVenta());
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