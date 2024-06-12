package com.eduard034.joyeria_proyectomult.controllers.pedidos;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.DatabaseHatler;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import com.eduard034.joyeria_proyectomult.models.Pedid0s;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ApedidosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Icantidadjoyas;

    @FXML
    private TextField Icontactocliente;

    @FXML
    private TextField Ifecha;

    @FXML
    private TextField Ihora;

    @FXML
    private TextField Inombrecliente;

    @FXML
    private TextField Itiposdejoya;

    @FXML
    private Button bttnagregarp;

    @FXML
    private Button bttnsalirap;

    @FXML
    void bttnagregarp(MouseEvent event) {
        Random generar = new Random();
        int id = generar.nextInt(1000);
        String nombre = Inombrecliente.getText();
        Integer contacto = Integer.parseInt(Icontactocliente.getText());
        String tipo = Itiposdejoya.getText();
        Integer cantidad = Integer.parseInt((Icantidadjoyas.getText()));
        String fecha = Ifecha.getText();
        String hora = Ihora.getText();
        Pedid0s pedido = new Pedid0s(id,nombre,contacto,tipo,cantidad,fecha,hora);
        JoyeriaApp.getData().setListapedidos(pedido);
        JoyeriaApp.getStageView().close();
        insertP(pedido);
    }
    private void insertP(Pedid0s pedid0s) {
        String sql = "INSERT INTO pedidos (pedidos_id, nombre_pedido, contacto_phonum, tipo_joya, cantidad, fecha, hora) VALUES (?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, pedid0s.getId());
            pstmt.setString(2, pedid0s.getNombrec());
            pstmt.setInt(3, pedid0s.getContactoc());
            pstmt.setString(4, pedid0s.getTipoj());
            pstmt.setInt(5, pedid0s.getCantidadj());
            pstmt.setString(6, pedid0s.getFechap());
            pstmt.setString(7, pedid0s.getHorap());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void bttnsalirap(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Icantidadjoyas != null : "fx:id=\"Icantidadjoyas\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert Icontactocliente != null : "fx:id=\"Icontactocliente\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert Ifecha != null : "fx:id=\"Ifecha\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert Ihora != null : "fx:id=\"Ihora\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert Inombrecliente != null : "fx:id=\"Inombrecliente\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert Itiposdejoya != null : "fx:id=\"Itiposdejoya\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert bttnagregarp != null : "fx:id=\"bttnagregarp\" was not injected: check your FXML file 'AgregarP.fxml'.";
        assert bttnsalirap != null : "fx:id=\"bttnsalirap\" was not injected: check your FXML file 'AgregarP.fxml'.";

    }

}
