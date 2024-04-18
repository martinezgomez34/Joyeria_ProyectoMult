package com.eduard034.joyeria_proyectomult.controllers.menus;
import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Pedid0s;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
public class PedidosController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableColumn<Pedid0s, String> MosCant;

    @FXML
    private TableColumn<Pedid0s, Integer> MosContact;

    @FXML
    private TableColumn<Pedid0s,Integer> MosID;

    @FXML
    private TableColumn<Pedid0s, String> MosNom;

    @FXML
    private TableColumn<Pedid0s, String> Mosfecha;

    @FXML
    private TableColumn<Pedid0s, String> Moshora;

    @FXML
    private TableColumn<Pedid0s, Integer> Mostipo;
    @FXML
    private TableView<Pedid0s> Mpedidos;

    @FXML
    private Button agregarPedidosButton;

    @FXML
    private Button eliminarPedidosButton;

    @FXML
    private Button exitPedidosButton;

    @FXML
    private Button modificarPedidosButton;
    @FXML
    void Bactu(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        Mpedidos.getItems().clear();
        Mpedidos.getItems().addAll(date.getListapedidos());
    }
    @FXML
    void onClickAgregarPedidosButton(MouseEvent event) {
    JoyeriaApp.newStage("AgregarP.fxml","AgregarPedidos");
    }

    @FXML
    void onClickEliminarPedidosButton(MouseEvent event) {
    JoyeriaApp.newStage("EliminarP.fxml","EliminarPedidos");
    }

    @FXML
    void onClickExitPedidosButton(MouseEvent event) {
        JoyeriaApp.newStage("home.fxml","home");
    }

    @FXML
    void onClickModificarPedidosButton(MouseEvent event) {
        JoyeriaApp.newStage("BuscarP.fxml","Buscar Pedidos Para Modificar");
    }

    @FXML
    void initialize() {
        MosID.setCellValueFactory(new PropertyValueFactory<>("id"));
        MosNom.setCellValueFactory(new PropertyValueFactory<>("nombrec"));
        MosContact.setCellValueFactory(new PropertyValueFactory<>("contactoc"));
        Mostipo.setCellValueFactory(new PropertyValueFactory<>("tipoj"));
        MosCant.setCellValueFactory(new PropertyValueFactory<>("cantidadj"));
        Mosfecha.setCellValueFactory(new PropertyValueFactory<>("fechap"));
        Moshora.setCellValueFactory(new PropertyValueFactory<>("horap"));
    }

}
