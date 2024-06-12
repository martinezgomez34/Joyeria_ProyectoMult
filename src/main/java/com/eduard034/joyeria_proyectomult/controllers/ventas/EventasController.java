package com.eduard034.joyeria_proyectomult.controllers.ventas;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class EventasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Beliminarp;

    @FXML
    private Button bttneliminarv;

    @FXML
    private Button bttnsalirev;

    @FXML
    private TableColumn<Venta, Integer> cantidadColumn;

    @FXML
    private TableColumn<Venta, String> fechaColumn;

    @FXML
    private TableColumn<Venta, String> nombrecolumn;

    @FXML
    private TableColumn<Venta, String> tipoColumn;

    @FXML
    private TableColumn<Venta, String> totalColumn;

    @FXML
    private TableView<Venta> verLista;
    @FXML
    void bttneliminarv(MouseEvent event) {
        String ide = Beliminarp.getText();
        Venta venta = searchV(ide);

        if (venta != null) {
            Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
            alertC.setHeaderText("Eliminar venta");
            alertC.setContentText("¿Estás seguro de eliminar esta venta?");
            Optional<ButtonType> result = alertC.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                if (deleteV(ide)) {
                    Alert alertagregar = new Alert(Alert.AlertType.INFORMATION);
                    alertagregar.setHeaderText("Se ha eliminado la venta");
                    alertagregar.setContentText("Haga click en aceptar para continuar");
                    alertagregar.showAndWait();
                    JoyeriaApp.newStage("ventas.fxml", "ventas");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error al eliminar", "No se pudo eliminar el gasto de la base de datos.");
                }
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Error al eliminar", "No se encontró el ID.");
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
    private boolean deleteV(String id) {
        String sql = "DELETE FROM venta WHERE nombre = ?";

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, id);
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void bttnsalirev(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void onClickVerLista(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        verLista.getItems().clear();
        verLista.getItems().addAll(date.getListaVenta());
    }

    @FXML
    void initialize() {
        nombrecolumn.setCellValueFactory(new PropertyValueFactory<>("nombreDCliente"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaDVenta"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("totalGanancia"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipoDJoya"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidadDJoya"));
    }

}
