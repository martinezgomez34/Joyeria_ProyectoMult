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

public class MventasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidaddejoyamv;

    @FXML
    private TextField Afechamv;

    @FXML
    private TextField Agananciamv;

    @FXML
    private TextField Anombremv;

    @FXML
    private TextField Atipodejoyamv;

    @FXML
    private TextField Mventasmv;

    @FXML
    private Button bttnmodificarv;

    @FXML
    private TableColumn<Venta, Integer> cantidadColumn;

    @FXML
    private TableColumn<Venta, String> fechaColumn;

    @FXML
    private TableColumn<Venta, String> nombreColumn;

    @FXML
    private TableColumn<Venta, String> tipoColumn;

    @FXML
    private TableColumn<Venta, String> totalColumn;

    @FXML
    private TableView<Venta> verListasV;

    private String idventa;
    @FXML
    void bttnmodificarv(MouseEvent event) {
        String name = Anombremv.getText();
        String fecha = Afechamv.getText();
        String total = Agananciamv.getText();
        String tipo = Atipodejoyamv.getText();
        int cantidad = Integer.parseInt(Acantidaddejoyamv.getText());

        Venta venta = new Venta(name,fecha,total,tipo,cantidad);

        Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
        alertC.setHeaderText("Modificar venta");
        alertC.setContentText("¿Estás seguro de modificar esta venta?");
        Optional<ButtonType> result = alertC.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            if (updateV(venta)) {
                showAlert(Alert.AlertType.INFORMATION, "Modificado", "Se modificó correctamente.");
                JoyeriaApp.newStage("ventas.fxml", "ventas");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error al modificar", "No se pudo modificar el gasto en la base de datos.");
            }
        }
    }
    private boolean updateV(Venta venta) {
        String sql = "UPDATE venta SET fecha = ?, total_ganancia = ?, tipo_de_joya = ?, cantidad = ? WHERE nombre = ?";

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, venta.getFechaDVenta());
            pstmt.setString(2, venta.getTotalGanancia());
            pstmt.setString(3, venta.getTipoDJoya());
            pstmt.setInt(4, venta.getCantidadDJoya());
            pstmt.setString(5, venta.getNombreDCliente());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
    private Venta searchV(String nombre) {
        String sql = "SELECT * FROM venta WHERE nombre = ?";
        Venta venta = null;

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, nombre);
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
    void onClickVerLista(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        verListasV.getItems().clear();
        verListasV.getItems().addAll(date.getListaVenta());
    }

    @FXML
    void initialize() {
        nombreColumn.setCellValueFactory(new PropertyValueFactory<>("nombreDCliente"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaDVenta"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("totalGanancia"));
        tipoColumn.setCellValueFactory(new PropertyValueFactory<>("tipoDJoya"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidadDJoya"));
        Database database = JoyeriaApp.getData();
        idventa = database.getNBusqueda();

        Venta venta = searchV(idventa);

        if (venta != null) {
            Anombremv.setText(venta.getNombreDCliente());
            Afechamv.setText(venta.getFechaDVenta());
            Agananciamv.setText(venta.getTotalGanancia());
            Atipodejoyamv.setText(venta.getTipoDJoya());
            Acantidaddejoyamv.setText(String.valueOf(venta.getCantidadDJoya()));
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
            JoyeriaApp.getStageView().close();
        }
    }
}

