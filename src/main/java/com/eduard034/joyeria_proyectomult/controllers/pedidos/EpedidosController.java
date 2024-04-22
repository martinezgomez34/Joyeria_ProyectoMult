package com.eduard034.joyeria_proyectomult.controllers.pedidos;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Pedid0s;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class EpedidosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane Actua;

    @FXML
    private TextField Beliminarp;
    @FXML
    private TableView<Pedid0s> Meliminarpedidos;

    @FXML
    private TextField Mpedidoaeliminar;

    @FXML
    private Button bttneliminarp;

    @FXML
    private Button bttnsalirep;
    @FXML
    private TableColumn<Pedid0s,String> deletecant;

    @FXML
    private TableColumn<Pedid0s,Integer> deletecont;

    @FXML
    private TableColumn<Pedid0s,String> deletefe;

    @FXML
    private TableColumn<Pedid0s,String> deleteho;

    @FXML
    private TableColumn<Pedid0s,Integer> deleteid;

    @FXML
    private TableColumn<Pedid0s,String> deletenom;

    @FXML
    private TableColumn<Pedid0s,Integer> deletetipo;

    @FXML
    void bttneliminarp(MouseEvent event) {
    int ide = Integer.parseInt(Beliminarp.getText());
        boolean Iddelete = true;
        for (Pedid0s ver : JoyeriaApp.getData().getListapedidos()){
            if (ver.getId() == ide){
                Iddelete = false;
                Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
                alertC.setHeaderText("Eliminar Pedido");
                alertC.setContentText("¿Estas seguro de eliminar este pedido?");
                Optional<ButtonType> result = alertC.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK){
                    JoyeriaApp.getData().getListapedidos().remove(ver);
                    Alert alertagregar = new Alert(Alert.AlertType.INFORMATION);
                    alertagregar.setHeaderText("Se ha eliminado su pedido");
                    alertagregar.setContentText("Haga click en aceptar para continuar");
                    alertagregar.showAndWait();
                }
            }
        }
        if (Iddelete){
            Alert alerterrorp = new Alert(Alert.AlertType.ERROR);
            alerterrorp.setHeaderText("Error al eliminar");
            alerterrorp.setContentText("No se encontro el ID");
            alerterrorp.showAndWait();
        }
    }

    @FXML
    void bttnsalirep(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }
    @FXML
    void Actua(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        Meliminarpedidos.getItems().clear();
        Meliminarpedidos.getItems().addAll(date.getListapedidos());
    }

    @FXML
    void initialize() {
        deleteid.setCellValueFactory(new PropertyValueFactory<>("id"));
        deletenom.setCellValueFactory(new PropertyValueFactory<>("nombrec"));
        deletecont.setCellValueFactory(new PropertyValueFactory<>("contactoc"));
        deletetipo.setCellValueFactory(new PropertyValueFactory<>("tipoj"));
        deletecant.setCellValueFactory(new PropertyValueFactory<>("cantidadj"));
        deletefe.setCellValueFactory(new PropertyValueFactory<>("fechap"));
        deleteho.setCellValueFactory(new PropertyValueFactory<>("horap"));

    }

}
