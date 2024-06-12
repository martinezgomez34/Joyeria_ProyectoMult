package com.eduard034.joyeria_proyectomult.controllers.joyas;

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

public class EjoyasController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Beliminarp;

    @FXML
    private Button bttneliminarj;

    @FXML
    private Button bttnsalirej;

    @FXML
    private TableColumn<Joya, String> cantidadColumn;

    @FXML
    private TableColumn<Joya, String> descripcionColumnJ;

    @FXML
    private TableColumn<Joya, Integer> idColumnJ;

    @FXML
    private TableColumn<Joya, String> nombreColumnJ;

    @FXML
    private TableView<Joya> verLIstaJ;

    @FXML
    void bttneliminarv(MouseEvent event) {
        int ide = Integer.parseInt(Beliminarp.getText());
        Joya joya = searchJ(ide);

        if (joya != null) {
            Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
            alertC.setHeaderText("Eliminar joya");
            alertC.setContentText("¿Estás seguro de eliminar esta joya?");
            Optional<ButtonType> result = alertC.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                if (deleteJ(ide)) {
                    Alert alertagregar = new Alert(Alert.AlertType.INFORMATION);
                    alertagregar.setHeaderText("Se ha eliminado la joya");
                    alertagregar.setContentText("Haga click en aceptar para continuar");
                    alertagregar.showAndWait();
                    JoyeriaApp.newStage("joyas.fxml", "joyas");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error al eliminar", "No se pudo eliminar el gasto de la base de datos.");
                }
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Error al eliminar", "No se encontró el ID.");
        }
    }
    private Joya searchJ(int id) {
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
    private boolean deleteJ(int id) {
        String sql = "DELETE FROM joya WHERE joya_id = ?";

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
    void onClickVerlistaJ(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        verLIstaJ.getItems().clear();
        verLIstaJ.getItems().addAll(date.getListaJoya());
    }

    @FXML
    void initialize() {
        idColumnJ.setCellValueFactory(new PropertyValueFactory<>("idJoya"));
        nombreColumnJ.setCellValueFactory(new PropertyValueFactory<>("nombreJoya"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidadDJoya"));
        descripcionColumnJ.setCellValueFactory(new PropertyValueFactory<>("descripcionDJoya"));
    }

}