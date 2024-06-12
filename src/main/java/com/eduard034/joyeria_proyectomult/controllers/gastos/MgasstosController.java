package com.eduard034.joyeria_proyectomult.controllers.gastos;

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
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class MgasstosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidadmj;

    @FXML
    private TextField Afechamg;

    @FXML
    private TextField Atipodegastomg;

    @FXML
    private Button bttnmodificarg;

    @FXML
    private TableColumn<Gasto, String> cantidadColumnM;

    @FXML
    private TableColumn<Gasto, String> descripcionColumnM;

    @FXML
    private TableColumn<Gasto, String> fechaColumnM;

    @FXML
    private TableColumn<Gasto, Integer> idColumnM;

    @FXML
    private TableView<Gasto> verLista;

    private int idGasto;
    @FXML
    void onClickVerTablaM(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        int id = date.getIdBusqueda();
        verLista.getItems().clear();
        for (Gasto item: JoyeriaApp.getData().getListaGastos()) {
            if (item.getId()==id) {
                verLista.getItems().addAll(item);
            }
        }
    }
    @FXML
    void bttnmodificarg(MouseEvent event) {
        String descripcionDGasto = Atipodegastomg.getText();
        String cantidadDGasto = Acantidadmj.getText();
        String fechaDGasto = Afechamg.getText();

        Gasto gasto = new Gasto(idGasto, descripcionDGasto, cantidadDGasto, fechaDGasto);

        Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
        alertC.setHeaderText("Modificar Gasto");
        alertC.setContentText("¿Estás seguro de modificar este gasto?");
        Optional<ButtonType> result = alertC.showAndWait();

        if (result.isPresent() && result.get() == ButtonType.OK) {
            if (updateGasto(gasto)) {
                showAlert(Alert.AlertType.INFORMATION, "Modificado", "Se modificó correctamente.");
                JoyeriaApp.newStage("gastos.fxml", "Gastos");
            } else {
                showAlert(Alert.AlertType.ERROR, "Error al modificar", "No se pudo modificar el gasto en la base de datos.");
            }
        }
    }

    private boolean updateGasto(Gasto gasto) {
        String sql = "UPDATE gastos SET describcion_g = ?, cantidad_g = ?, fecha_de_gasto = ? WHERE gastos_id = ?";

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, gasto.getDescripcionDGasto());
            pstmt.setString(2, gasto.getCantidadDGasto());
            pstmt.setString(3, gasto.getFechaDGasto());
            pstmt.setInt(4, gasto.getId());
            int affectedRows = pstmt.executeUpdate();
            return affectedRows > 0;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
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
    void initialize() {
        idColumnM.setCellValueFactory(new PropertyValueFactory<>("id"));
        descripcionColumnM.setCellValueFactory(new PropertyValueFactory<>("descripcionDGasto"));
        cantidadColumnM.setCellValueFactory(new PropertyValueFactory<>("cantidadDGasto"));
        fechaColumnM.setCellValueFactory(new PropertyValueFactory<>("fechaDGasto"));
        Database database = JoyeriaApp.getData();
        idGasto = database.getIdBusqueda();

        Gasto gasto = searchGasto(idGasto);

        if (gasto != null) {
            Atipodegastomg.setText(gasto.getDescripcionDGasto());
            Acantidadmj.setText(gasto.getCantidadDGasto());
            Afechamg.setText(gasto.getFechaDGasto());
        } else {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
            JoyeriaApp.getStageView().close();
        }
    }
}
