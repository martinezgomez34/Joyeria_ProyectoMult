package com.eduard034.joyeria_proyectomult.controllers.pedidos;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Pedid0s;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MpedidosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane Bactu;

    @FXML
    private TextField Acantidaddejoyasmp;

    @FXML
    private TextField Acontactomp;

    @FXML
    private TextField Afechamp;

    @FXML
    private TextField Ahoramp;

    @FXML
    private TextField Anombremp;

    @FXML
    private TextField Atipodejoyasmp;

    @FXML
    private Button bttnmodificarp;
    @FXML
    private TableView<Pedid0s> Mverpedidos;
    @FXML
    private TableColumn<Pedid0s,String> cantidadmod;

    @FXML
    private TableColumn<Pedid0s,Integer> contacmod;

    @FXML
    private TableColumn<Pedid0s,String> fechamod;

    @FXML
    private TableColumn<Pedid0s,String> horamod;

    @FXML
    private TableColumn<Pedid0s,Integer> idmod;

    @FXML
    private TableColumn<Pedid0s,String> nommod;

    @FXML
    private TableColumn<Pedid0s,Integer> tipomod;

    @FXML
    private TableColumn<Pedid0s,Integer> tipomod;
    @FXML
    void actu(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        int id = date.getIdbP();
        Mverpedidos.getItems().clear();
        for (Pedid0s item : JoyeriaApp.getData().getListapedidos()) {
            if (item.getId() == id) {
                Mverpedidos.getItems().addAll(item);
            }
        }
    }
    @FXML
    void bttnmodificarp(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        int id = date.getIdbP();
        boolean idmod = true;
        for (Pedid0s ver : JoyeriaApp.getData().getListapedidos()){
            if (ver.getId() == id){
                idmod = false;
                String nombre = Anombremp.getText();
                Integer contacto = Integer.valueOf(Acontactomp.getText());
                Integer tipo = Integer.valueOf(Atipodejoyasmp.getText());
                String cantidad = Acantidaddejoyasmp.getText();
                String fecha = Afechamp.getText();
                String hora = Ahoramp.getText();
                ver.setNombrec(nombre);
                ver.setContactoc(contacto);
                ver.setTipoj(tipo);
                ver.setCantidadj(cantidad);
                ver.setFechap(fecha);
                ver.setHorap(hora);
                Alert alertagregar = new Alert(Alert.AlertType.INFORMATION);
                alertagregar.setHeaderText("Se ha modificado");
                alertagregar.setContentText("Se agrego con exito");
                alertagregar.showAndWait();
            }
        }
        if (idmod){
            Alert alerterrorp = new Alert(Alert.AlertType.ERROR);
            alerterrorp.setHeaderText("Error al agregar");
            alerterrorp.setContentText("Ups... hubo un problema al agregar su pedido, intentelo de nuevo");
            alerterrorp.showAndWait();
        }JoyeriaApp.newStage("pedidos.fxml","Pedidos");

    }
    @FXML
    void Bactu(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        Mverpedidos.getItems().clear();
        Mverpedidos.getItems().addAll(date.getListapedidos());
    }

    @FXML
    void initialize() {
        idmod.setCellValueFactory(new PropertyValueFactory<>("id"));
        nommod.setCellValueFactory(new PropertyValueFactory<>("nombrec"));
        contacmod.setCellValueFactory(new PropertyValueFactory<>("contactoc"));
        tipomod.setCellValueFactory(new PropertyValueFactory<>("tipoj"));
        cantidadmod.setCellValueFactory(new PropertyValueFactory<>("cantidadj"));
        fechamod.setCellValueFactory(new PropertyValueFactory<>("fechap"));
        horamod.setCellValueFactory(new PropertyValueFactory<>("horap"));
        }
    }


