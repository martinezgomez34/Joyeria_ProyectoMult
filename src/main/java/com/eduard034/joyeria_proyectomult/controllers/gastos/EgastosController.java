package com.eduard034.joyeria_proyectomult.controllers.gastos;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;
import com.eduard034.joyeria_proyectomult.controllers.menus.GastosController;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.DatabaseHatler;
import com.eduard034.joyeria_proyectomult.models.Joya;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EgastosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Beliminarp;

    @FXML
    private Button bttneliminarg;

    @FXML
    private Button bttnsalireg;

    @FXML
    private TableColumn<Gasto, String> cantidadColumnE;

    @FXML
    private TableColumn<Gasto, String> descripcionColumnE;

    @FXML
    private TableColumn<Gasto, String> fechaColumE;

    @FXML
    private TableColumn<Gasto, Integer> idColumnE;

    @FXML
    private TableView<Gasto> verColumna;
    private ObservableList<Gasto> gastosList = FXCollections.observableArrayList();
    private GastosController gastosController = new GastosController();

    @FXML
    void bttneliminarg(MouseEvent event) {
        int ide = Integer.parseInt(Beliminarp.getText());
        Gasto gasto = searchGasto(ide);

        if (gasto != null) {
            Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
            alertC.setHeaderText("Eliminar Gasto");
            alertC.setContentText("¿Estás seguro de eliminar este gasto?");
            Optional<ButtonType> result = alertC.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                if (deleteGasto(ide)) {
                    Alert alertagregar = new Alert(Alert.AlertType.INFORMATION);
                    alertagregar.setHeaderText("Se ha eliminado el gasto");
                    alertagregar.setContentText("Haga click en aceptar para continuar");
                    alertagregar.showAndWait();
                    JoyeriaApp.newStage("gastos.fxml", "Gastos");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error al eliminar", "No se pudo eliminar el gasto de la base de datos.");
                }
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Error al eliminar", "No se encontró el ID.");
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
    private boolean deleteGasto(int id) {
        String sql = "DELETE FROM gastos WHERE gastos_id = ?";

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }


    @FXML
    void bttnsalireg(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void verListaGastos(MouseEvent event) {
        gastosController.loadGastosFromDatabase();
    }

    @FXML
    void initialize() {
        idColumnE.setCellValueFactory(new PropertyValueFactory<>("id"));
        descripcionColumnE.setCellValueFactory(new PropertyValueFactory<>("descripcionDGasto"));
        cantidadColumnE.setCellValueFactory(new PropertyValueFactory<>("cantidadDGasto"));
        fechaColumE.setCellValueFactory(new PropertyValueFactory<>("fechaDGasto"));
        verColumna.setItems(gastosList);
        gastosController.loadGastosFromDatabase();
    }
}
