package com.eduard034.joyeria_proyectomult.controllers.pedidos;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Pedid0s;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MpedidosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

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
    void bttnmodificarp(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        int id = date.getIdbP();
        String nombre = Anombremp.getText();
        Integer contacto = Integer.valueOf(Acontactomp.getText());
        Integer tipo = Integer.valueOf(Atipodejoyasmp.getText());
        String cantidad = Acantidaddejoyasmp.getText();
        String fecha = Afechamp.getText();
        String hora = Ahoramp.getText();
        Pedid0s pedidosm = new Pedid0s(id,nombre,contacto,tipo,cantidad,fecha,hora);
        if (date.getListapedidos().contains(pedidosm)){
            for (Pedid0s mod : date.getListapedidos()){
                nombre = mod.getNombrec();
                contacto = mod.getContactoc();
                tipo = mod.getTipoj();
                cantidad = mod.getCantidadj();
                fecha = mod.getFechap();
                hora = mod.getHorap();
                JoyeriaApp.newStage("pedidos.fxml","Pedidos");
            }
        }
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


