package com.eduard034.joyeria_proyectomult.controllers.joyas;

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
import com.eduard034.joyeria_proyectomult.models.Joya;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BjoyasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Bjoyasmj;

    @FXML
    private Button bttnbuscarj;

    @FXML
    private Button bttnsalirbj;

    @FXML
    void bttnbuscarj(MouseEvent event) {
        int idBusqueda = Integer.parseInt(Bjoyasmj.getText());
        Joya joya = searchjoya(idBusqueda);
        if (joya != null) {
            Database database = JoyeriaApp.getData();
            database.setIdBusqueda(idBusqueda);
            JoyeriaApp.newStage("ModificarJ.fxml", "Modificar joyas");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
        }
    }
    private Joya searchjoya(int id) {
        String sql = "SELECT * FROM joya WHERE joya_id = ?";
        Joya joya = null;

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                joya = new Joya(
                        rs.getInt("joya_id"),
                        rs.getString("nombre_joya"),
                        rs.getString("cantidad_joya"),
                        rs.getString("description")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return joya;
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void bttnsalirbj(MouseEvent event) {
        JoyeriaApp.newStage("joyas.fxml","Menu de joyas");
    }

    @FXML
    void initialize() {

    }

}

