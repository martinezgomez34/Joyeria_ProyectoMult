package com.eduard034.joyeria_proyectomult.controllers.ventas;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BventasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Bpedidosmp;

    @FXML
    private Button bttnbuscarv;

    @FXML
    private Button bttnsalirbv;

    @FXML
    void bttnbuscarp(MouseEvent event) {
        String name = Bpedidosmp.getText();
        Venta venta = searchV(name);

        if (venta != null) {
            Database database = JoyeriaApp.getData();
            database.setNBusqueda(name);
            JoyeriaApp.newStage("ModificarV.fxml", "Modificar ventas");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
        }
    }
    private Venta searchV(String id) {
        String sql = "SELECT * FROM venta WHERE nombre = ?";
        Venta venta = null;

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                venta = new Venta(
                        rs.getString("nombre"),
                        rs.getString("fecha"),
                        rs.getString("total_ganancia"),
                        rs.getString("tipo_de_joya"),
                        rs.getInt("cantidad")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return venta;
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

    }

}
