package com.eduard034.joyeria_proyectomult.controllers.gastos;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import com.eduard034.joyeria_proyectomult.models.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.Random;

public class AgastosController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bttnagregarg;

    @FXML
    private Button bttnsalirav;

    @FXML
    private TextField ingCantidad;

    @FXML
    private TextField ingFecha;

    @FXML
    private TextField ingTipGas;

    @FXML
    void bttnagregarg(MouseEvent event) {
        Random generar = new Random();
        int id = generar.nextInt(1000);
        String descripcionDGasto = ingTipGas.getText();
        String cantidadDGasto = ingCantidad.getText();
        String fechaDGasto = ingFecha.getText();
        Gasto gasto = new Gasto(id,descripcionDGasto,cantidadDGasto,fechaDGasto);
        JoyeriaApp.getData().setListaGastos(gasto);
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void bttnsalirag(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {

    }
}

