package com.eduard034.joyeria_proyectomult.controllers.pedidos;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Pedid0s;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EpedidosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Beliminarp;

    @FXML
    private TextField Mpedidoaeliminar;

    @FXML
    private Button bttneliminarp;

    @FXML
    private Button bttnsalirep;

    @FXML
    void bttneliminarp(MouseEvent event) {
        int ID = Integer.parseInt(Beliminarp.getText());
        boolean idElimidado = true;
        for (Pedid0s ver: JoyeriaApp.getData().getListapedidos()) {
            if (ver.getId()==ID) {
                idElimidado = false;
                Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
                alertC.setHeaderText("Confirmar cambio de contraseña");
                alertC.setContentText("¿Estas seguro que quieres cambiar tu contraseña?");
                Optional<ButtonType> result = alertC.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK){
                    JoyeriaApp.getData().getListapedidos().remove(ver);
                }
            }
        }
        if (idElimidado) {
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
    void initialize() {
        assert Beliminarp != null : "fx:id=\"Beliminarp\" was not injected: check your FXML file 'EliminarP.fxml'.";
        assert Mpedidoaeliminar != null : "fx:id=\"Mpedidoaeliminar\" was not injected: check your FXML file 'EliminarP.fxml'.";
        assert bttneliminarp != null : "fx:id=\"bttneliminarp\" was not injected: check your FXML file 'EliminarP.fxml'.";
        assert bttnsalirep != null : "fx:id=\"bttnsalirep\" was not injected: check your FXML file 'EliminarP.fxml'.";

    }

}
