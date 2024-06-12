package com.eduard034.joyeria_proyectomult.controllers.pedidos;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.DatabaseHatler;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import com.eduard034.joyeria_proyectomult.models.Pedid0s;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class EpedidosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane Actua;

    @FXML
    private TextField Beliminarp;
    @FXML
    private TableView<Pedid0s> Meliminarpedidos;

    @FXML
    private TextField Mpedidoaeliminar;

    @FXML
    private Button bttneliminarp;

    @FXML
    private Button bttnsalirep;
    @FXML
    private TableColumn<Pedid0s,String> deletecant;

    @FXML
    private TableColumn<Pedid0s,Integer> deletecont;

    @FXML
    private TableColumn<Pedid0s,String> deletefe;

    @FXML
    private TableColumn<Pedid0s,String> deleteho;

    @FXML
    private TableColumn<Pedid0s,Integer> deleteid;

    @FXML
    private TableColumn<Pedid0s,String> deletenom;

    @FXML
    private TableColumn<Pedid0s,Integer> deletetipo;

    @FXML
    void bttneliminarp(MouseEvent event) {
        int ide = Integer.parseInt(Beliminarp.getText());
        Pedid0s pedid0s = searchP(ide);
        if (pedid0s != null) {
            Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
            alertC.setHeaderText("Eliminar Pedidos");
            alertC.setContentText("¿Estás seguro de eliminar este pedidos?");
            Optional<ButtonType> result = alertC.showAndWait();

            if (result.isPresent() && result.get() == ButtonType.OK) {
                if (deleteP(ide)) {
                    Alert alertagregar = new Alert(Alert.AlertType.INFORMATION);
                    alertagregar.setHeaderText("Se ha eliminado el gasto");
                    alertagregar.setContentText("Haga click en aceptar para continuar");
                    alertagregar.showAndWait();
                    JoyeriaApp.newStage("pedidos.fxml", "pedidos");
                } else {
                    showAlert(Alert.AlertType.ERROR, "Error al eliminar", "No se pudo eliminar el gasto de la base de datos.");
                }
            }
        } else {
            showAlert(Alert.AlertType.ERROR, "Error al eliminar", "No se encontró el ID.");
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
    private boolean deleteP(int id) {
        String sql = "DELETE FROM pedidos WHERE pedidos_id = ?";

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
    void bttnsalirep(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }
    @FXML
    void Actua(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        Meliminarpedidos.getItems().clear();
        Meliminarpedidos.getItems().addAll(date.getListapedidos());
    }

    @FXML
    void initialize() {
        deleteid.setCellValueFactory(new PropertyValueFactory<>("id"));
        deletenom.setCellValueFactory(new PropertyValueFactory<>("nombrec"));
        deletecont.setCellValueFactory(new PropertyValueFactory<>("contactoc"));
        deletetipo.setCellValueFactory(new PropertyValueFactory<>("tipoj"));
        deletecant.setCellValueFactory(new PropertyValueFactory<>("cantidadj"));
        deletefe.setCellValueFactory(new PropertyValueFactory<>("fechap"));
        deleteho.setCellValueFactory(new PropertyValueFactory<>("horap"));

    }

}
