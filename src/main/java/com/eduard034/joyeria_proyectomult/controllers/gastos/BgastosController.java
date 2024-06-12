package com.eduard034.joyeria_proyectomult.controllers.gastos;

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
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BgastosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Bgastosmg;

    @FXML
    private Button bttnbuscarg;

    @FXML
    private Button bttnsalirbg;

    @FXML
    void bttnbuscarg(MouseEvent event) {
        int idBusqueda = Integer.parseInt(Bgastosmg.getText());
        Gasto gasto = searchGasto(idBusqueda);

        if (gasto != null) {
            Database database = JoyeriaApp.getData();
            database.setIdBusqueda(idBusqueda);
            JoyeriaApp.newStage("ModificarG.fxml", "Modificar Gastos");
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
        }
    }
    private Gasto searchGasto(int id) {
        String sql = "SELECT * FROM gastos WHERE gastos_id = ?";
        Gasto gasto = null;

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                gasto = new Gasto(
                        rs.getInt("gastos_id"),
                        rs.getString("describcion_g"),
                        rs.getString("cantidad_g"),
                        rs.getString("fecha_de_gasto")
                );
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return gasto;
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void bttnsalirbg(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Bgastosmg != null : "fx:id=\"Bgastosmg\" was not injected: check your FXML file 'BuscarG.fxml'.";
        assert bttnbuscarg != null : "fx:id=\"bttnbuscarg\" was not injected: check your FXML file 'BuscarG.fxml'.";
        assert bttnsalirbg != null : "fx:id=\"bttnsalirbg\" was not injected: check your FXML file 'BuscarG.fxml'.";

    }

}
