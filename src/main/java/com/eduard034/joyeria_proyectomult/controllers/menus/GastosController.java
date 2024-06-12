package com.eduard034.joyeria_proyectomult.controllers.menus;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.DatabaseHatler;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import com.eduard034.joyeria_proyectomult.models.Database;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.TableView;

public class GastosController {

    @FXML
    private Button actualizar;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button agregarGastosButton;

    @FXML
    private TableColumn<Gasto, String> cantidadColumn;

    @FXML
    private TableColumn<Gasto, String> descripcionColumn;

    @FXML
    private Button eliminarGastosButton;

    @FXML
    private Button exitGastosButton;

    @FXML
    private TableColumn<Gasto, String> fechaColumn;

    @FXML
    private TableColumn<Gasto, Integer> idColumn;


    @FXML
    private TableView<Gasto> verGasto;
    private ObservableList<Gasto> gastosList = FXCollections.observableArrayList();
    @FXML
    void onClickActualizar(MouseEvent event) {
        loadGastosFromDatabase();
    }
    public void loadGastosFromDatabase() {
        String sql = "SELECT * FROM gastos";
        gastosList.clear();

        try (Connection conn = DatabaseHatler.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Gasto gasto = new Gasto(
                        rs.getInt("gastos_id"),
                        rs.getString("describcion_g"),
                        rs.getString("cantidad_g"),
                        rs.getString("fecha_de_gasto")
                );
                gastosList.add(gasto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @FXML
    void onClickAgregarGastosButton(MouseEvent event) {
        JoyeriaApp.newStage("AgregarG.fxml","AgregarGastos");
    }

    @FXML
    void onClickEliminarGastosButton(MouseEvent event) {
        JoyeriaApp.newStage("EliminarG.fxml","EliminarGastos");
    }

    @FXML
    void onClickExitGastosButton(MouseEvent event) {
        JoyeriaApp.newStage("home.fxml","Menu");
    }

    @FXML
    void onClickModificarGastosButton(MouseEvent event) {
        JoyeriaApp.newStage("BuscarG.fxml","ModificarGastos");
    }

    @FXML
    void initialize() {
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        descripcionColumn.setCellValueFactory(new PropertyValueFactory<>("descripcionDGasto"));
        cantidadColumn.setCellValueFactory(new PropertyValueFactory<>("cantidadDGasto"));
        fechaColumn.setCellValueFactory(new PropertyValueFactory<>("fechaDGasto"));
        verGasto.setItems(gastosList);
        loadGastosFromDatabase();
    }
}
