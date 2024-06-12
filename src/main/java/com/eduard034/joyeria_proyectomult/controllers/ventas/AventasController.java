package com.eduard034.joyeria_proyectomult.controllers.ventas;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AventasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidadv;

    @FXML
    private TextField Afechav;

    @FXML
    private TextField Agananciav;

    @FXML
    private TextField Anombreclientev;

    @FXML
    private TextField Atipodejoyav;

    @FXML
    private Button bttnagregarv;

    @FXML
    private Button bttnsalirav;

    Pedid0s pedid0s;
    Database data;
    @FXML
    void bttnagregarv(MouseEvent event) {
        String nombre = Anombreclientev.getText();
        String fecha = Afechav.getText();
        String total = Agananciav.getText();
        String tipo = Atipodejoyav.getText();
        int cantidad = Integer.parseInt(Acantidadv.getText());
        Venta venta = new Venta(nombre,fecha,total,tipo,cantidad);
        for (Pedid0s ver : JoyeriaApp.getData().getListapedidos()) {
            if (ver.getNombrec().equals(nombre) && ver.getCantidadj() == cantidad) {
                Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
                alertC.setHeaderText("Confirmar venta");
                alertC.setContentText("¿Estas seguro que se realizo la venta del pedido?");
                Optional<ButtonType> result = alertC.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK) {
                    JoyeriaApp.getData().getListapedidos().remove(ver);
                    JoyeriaApp.getData().setListaVenta(venta);
                    JoyeriaApp.getStageView().close();
                }
            }
        }
        JoyeriaApp.getData().setListaVenta(venta);
        JoyeriaApp.getStageView().close();
        insertV(venta);
    }
    private void insertV(Venta venta) {
        String sql = "INSERT INTO venta (nombre, fecha, total_ganancia, tipo_de_joya, cantidad) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, venta.getNombreDCliente());
            pstmt.setString(2, venta.getFechaDVenta());
            pstmt.setString(3, venta.getTotalGanancia());
            pstmt.setString(4, venta.getTipoDJoya());
            pstmt.setInt(5, venta.getCantidadDJoya());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @FXML
    void bttnsalirav(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Acantidadv != null : "fx:id=\"Acantidadv\" was not injected: check your FXML file 'AgregarV.fxml'.";
        assert Afechav != null : "fx:id=\"Afechav\" was not injected: check your FXML file 'AgregarV.fxml'.";
        assert Agananciav != null : "fx:id=\"Agananciav\" was not injected: check your FXML file 'AgregarV.fxml'.";
        assert Anombreclientev != null : "fx:id=\"Anombreclientev\" was not injected: check your FXML file 'AgregarV.fxml'.";
        assert Atipodejoyav != null : "fx:id=\"Atipodejoyav\" was not injected: check your FXML file 'AgregarV.fxml'.";
        assert bttnagregarv != null : "fx:id=\"bttnagregarv\" was not injected: check your FXML file 'AgregarV.fxml'.";
        assert bttnsalirav != null : "fx:id=\"bttnsalirav\" was not injected: check your FXML file 'AgregarV.fxml'.";

    }

}
