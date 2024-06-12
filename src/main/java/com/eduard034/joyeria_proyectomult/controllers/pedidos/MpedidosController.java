package com.eduard034.joyeria_proyectomult.controllers.pedidos;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.Random;
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

public class MpedidosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane Bactu;

    @FXML
    private TextField Acantidaddejoyasmp;

    @FXML
    private TextField Acontactomp;

    @FXML
    private TextField Afechamp;

    @FXML
    private TextField Ahoramp;

    @FXML
    private TextField Anombremp;

    @FXML
    private TextField Atipodejoyasmp;

    @FXML
    private Button bttnmodificarp;
    @FXML
    private TableView<Pedid0s> Mverpedidos;
    @FXML
    private TableColumn<Pedid0s,String> cantidadmod;

    @FXML
    private TableColumn<Pedid0s,Integer> contacmod;

    @FXML
    private TableColumn<Pedid0s,String> fechamod;

    @FXML
    private TableColumn<Pedid0s,String> horamod;

    @FXML
    private TableColumn<Pedid0s,Integer> idmod;

    @FXML
    private TableColumn<Pedid0s,String> nommod;

    @FXML
    private TableColumn<Pedid0s,String> tipomod;
    private int idpedido;

    @FXML
    void bttnmodificarp(MouseEvent event) {
        String nombre = Anombremp.getText();
        int contact = Integer.parseInt(Acontactomp.getText());
        String tipo = Atipodejoyasmp.getText();
        int cantidad = Integer.parseInt(Acantidaddejoyasmp.getText());
        String fecha = Afechamp.getText();
        String hora = Ahoramp.getText();

        Pedid0s pedid0s = new Pedid0s(idpedido,nombre,contact,tipo,cantidad,fecha,hora);

        Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
        alertC.setHeaderText("Modificar Gasto");
        alertC.setContentText("¿Estás seguro de modificar este gasto?");
        Optional<ButtonType> result = alertC.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            if (updateP(pedid0s)) {
                showAlert(Alert.AlertType.INFORMATION, "Modificado", "Se modificó correctamente.");
                JoyeriaApp.newStage("pedidos.fxml", "pedidos");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error al modificar", "No se pudo modificar el gasto en la base de datos.");
            }
        }
    }
    private boolean updateP(Pedid0s pedid0s) {
        String sql = "UPDATE pedidos SET nombre_pedido = ?, contacto_phonum = ?, tipo_joya = ?, cantidad = ?, fecha = ?, hora = ? WHERE pedidos_id = ?";

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, pedid0s.getNombrec());
            pstmt.setInt(2, pedid0s.getContactoc());
            pstmt.setString(3, pedid0s.getTipoj());
            pstmt.setInt(4, pedid0s.getCantidadj());
            pstmt.setString(5, pedid0s.getFechap());
            pstmt.setString(6, pedid0s.getHorap());
            pstmt.setInt(7, pedid0s.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
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
    @FXML
    void Bactu(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        Mverpedidos.getItems().clear();
        Mverpedidos.getItems().addAll(date.getListapedidos());
    }
    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        idmod.setCellValueFactory(new PropertyValueFactory<>("id"));
        nommod.setCellValueFactory(new PropertyValueFactory<>("nombrec"));
        contacmod.setCellValueFactory(new PropertyValueFactory<>("contactoc"));
        tipomod.setCellValueFactory(new PropertyValueFactory<>("tipoj"));
        cantidadmod.setCellValueFactory(new PropertyValueFactory<>("cantidadj"));
        fechamod.setCellValueFactory(new PropertyValueFactory<>("fechap"));
        horamod.setCellValueFactory(new PropertyValueFactory<>("horap"));
        Database database = JoyeriaApp.getData();
        idpedido = database.getIdBusqueda();

        Pedid0s pedid0s = searchP(idpedido);

        if (pedid0s != null) {
            Anombremp.setText(pedid0s.getNombrec());
            Acontactomp.setText(String.valueOf(pedid0s.getContactoc()));
            Atipodejoyasmp.setText(pedid0s.getTipoj());
            Acantidaddejoyasmp.setText(String.valueOf(pedid0s.getCantidadj()));
            Afechamp.setText(pedid0s.getFechap());
            Ahoramp.setText(pedid0s.getHorap());
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
            JoyeriaApp.getStageView().close(); // Cerrar la ventana si no se encuentra el pedido
        }
    }
}


