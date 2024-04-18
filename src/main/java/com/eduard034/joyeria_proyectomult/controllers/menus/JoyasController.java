package com.eduard034.joyeria_proyectomult.controllers.menus;
import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Joya;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
public class JoyasController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarJoyasButton;

    @FXML
    private TableColumn<Joya, String> cantidadColumnJ;

    @FXML
    private TableColumn<Joya, String> descripcionColumnJ;

    @FXML
    private Button eliminarJoyasButton;

    @FXML
    private Button exitJoyasButton;

    @FXML
    private TableColumn<Joya, String> idColumnJ;

    @FXML
    private TableView<Joya> listaJoyas;

    @FXML
    private Button modificarJoyasButton;

    @FXML
    private TableColumn<Joya, String> nombreColumnJ;


    @FXML
    void onClickAgregarJoyasButton(MouseEvent event) {
        JoyeriaApp.newStage("AgregarJ.fxml","Agregar joyas");
    }

    @FXML
    void onClickEliminarJoyasButton(MouseEvent event) {
        JoyeriaApp.newStage("EliminarJ.fxml","Eliminar joyas");
    }

    @FXML
    void onClickExitJoyasButton(MouseEvent event) {
        JoyeriaApp.newStage("home.fxml","Menu");
    }

    @FXML
    void onClickModificarJoyasButton(MouseEvent event) {
        JoyeriaApp.newStage("BuscarJ.fxml","Buscar joyas");
    }
    @FXML
    void onClickVerLIstaJ(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        listaJoyas.getItems().clear();
        listaJoyas.getItems().addAll(date.getListaJoya());
    }

    @FXML
    void initialize() {
        idColumnJ.setCellValueFactory(new PropertyValueFactory<>("idJoya"));
        nombreColumnJ.setCellValueFactory(new PropertyValueFactory<>("nombreJoya"));
        cantidadColumnJ.setCellValueFactory(new PropertyValueFactory<>("cantidadDJoya"));
        descripcionColumnJ.setCellValueFactory(new PropertyValueFactory<>("descripcionDJoya"));
    }

}
