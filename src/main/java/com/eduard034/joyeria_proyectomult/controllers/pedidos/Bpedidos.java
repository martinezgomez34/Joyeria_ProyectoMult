package com.eduard034.joyeria_proyectomult.controllers.pedidos;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.DatabaseHatler;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import com.eduard034.joyeria_proyectomult.models.Pedid0s;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class Bpedidos {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private TextField Bpedidos;

    @FXML
    private Button bttnbuscarp;

    @FXML
    private Button bttnsalirbp;

    @FXML
    void bttnbuscarp(MouseEvent event) {
        int Idbus = Integer.parseInt(Bpedidos.getText());
        Pedid0s pedid0s = searchP(Idbus);
        if (pedid0s != null) {
            Database database = JoyeriaApp.getData();
            database.setIdBusqueda(Idbus);
            JoyeriaApp.newStage("ModificarP.fxml", "Modificar Pedidos");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
        }
    }
    private Pedid0s searchP(int id) {
        String sql = "SELECT * FROM pedidos WHERE pedidos_id = ?";
        Pedid0s pedid0s = null;

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                pedid0s = new Pedid0s(
                        rs.getInt("pedidos_id"),
                        rs.getString("nombre_pedido"),
                        rs.getInt("contacto_phonum"),
                        rs.getString("tipo_joya"),
                        rs.getInt("cantidad"),
                        rs.getString("fecha"),
                        rs.getString("hora")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pedid0s;
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void bttnsalirbp(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert bttnbuscarp != null : "fx:id=\"bttnbuscarp\" was not injected: check your FXML file 'BuscarP.fxml'.";
        assert bttnsalirbp != null : "fx:id=\"bttnsalirbp\" was not injected: check your FXML file 'BuscarP.fxml'.";

    }

}
