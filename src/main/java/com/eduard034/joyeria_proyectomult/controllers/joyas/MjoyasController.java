package com.eduard034.joyeria_proyectomult.controllers.joyas;

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
import com.eduard034.joyeria_proyectomult.models.Joya;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

public class MjoyasController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidadmj;

    @FXML
    private TextField Adescripcionmj;

    @FXML
    private TextField Anombremj;

    @FXML
    private Button bttnmodificarj;

    @FXML
    private TableColumn<Joya, String> cantidadColumJ;

    @FXML
    private TableColumn<Joya, String> descripcionColumnJ;

    @FXML
    private TableColumn<Joya, String> idColumnJ;

    @FXML
    private TableColumn<Joya, String> nombreColumnJ;
    @FXML
    private TableView<Joya> verlistaJ;
    private int idjoya;
    @FXML
    void onClickVerListaJ(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        int id = date.getIdBusqueda();
        verlistaJ.getItems().clear();
        for (Joya item: JoyeriaApp.getData().getListaJoya()) {
            if (item.getIdJoya()==id) {
                verlistaJ.getItems().addAll(item);
            }
        }
    }

    @FXML
    void bttnmodificarj(MouseEvent event) {
        String nombreJ = Anombremj.getText();
        String cantidadJ = Acantidadmj.getText();
        String descriptionJ = Adescripcionmj.getText();

        Joya joya = new Joya(idjoya,nombreJ,cantidadJ,descriptionJ);

        Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
        alertC.setHeaderText("Modificar joya");
        alertC.setContentText("¿Estás seguro de modificar esta joya?");
        Optional<ButtonType> result = alertC.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            if (updateJ(joya)) {
                showAlert(Alert.AlertType.INFORMATION, "Modificado", "Se modificó correctamente.");
                JoyeriaApp.newStage("joyas.fxml", "joyas");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error al modificar", "No se pudo modificar el joya en la base de datos.");
            }
        }
    }
    private boolean updateJ(Joya joya) {
        String sql = "UPDATE joya SET nombre_joya = ?, cantidad_joya = ?, description = ? WHERE joya_id = ?";

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, joya.getNombreJoya());
            pstmt.setString(2, joya.getCantidadDJoya());
            pstmt.setString(3, joya.getDescripcionDJoya());
            pstmt.setInt(4, joya.getIdJoya());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
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

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }

    @FXML
    void initialize() {
        idColumnJ.setCellValueFactory(new PropertyValueFactory<>("idJoya"));
        nombreColumnJ.setCellValueFactory(new PropertyValueFactory<>("nombreJoya"));
        cantidadColumJ.setCellValueFactory(new PropertyValueFactory<>("cantidadDJoya"));
        descripcionColumnJ.setCellValueFactory(new PropertyValueFactory<>("descripcionDJoya"));
        Database database = JoyeriaApp.getData();
        idjoya = database.getIdBusqueda();
        Joya joya = searchJ(idjoya);

        if (joya != null) {
            Anombremj.setText(joya.getNombreJoya());
            Acantidadmj.setText(joya.getCantidadDJoya());
            Adescripcionmj.setText(joya.getDescripcionDJoya());
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
            JoyeriaApp.getStageView().close(); // Cerrar la ventana si no se encuentra el gasto
        }
    }
}
