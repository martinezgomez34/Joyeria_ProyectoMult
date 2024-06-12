package com.eduard034.joyeria_proyectomult.controllers.gastos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.net.URL;
import java.util.ResourceBundle;
import com.eduard034.joyeria_proyectomult.controllers.menus.GastosController;
import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.DatabaseHatler;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import com.eduard034.joyeria_proyectomult.models.Database;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import java.util.Random;

public class AgastosController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button bttnagregarg;

    @FXML
    private Button bttnsalirav;

    @FXML
    private TextField ingCantidad;

    @FXML
    private TextField ingFecha;

    @FXML
    private TextField ingTipGas;
    private GastosController gastosController = new GastosController();

    @FXML
    void bttnagregarg(MouseEvent event) {
        Random generar = new Random();
        int id = generar.nextInt(1000);
        String descripcionDGasto = ingTipGas.getText();
        String cantidadDGasto = ingCantidad.getText();
        String fechaDGasto = ingFecha.getText();
        Gasto gasto = new Gasto(id,descripcionDGasto,cantidadDGasto,fechaDGasto);
        JoyeriaApp.getData().setListaGastos(gasto);
        JoyeriaApp.getStageView().close();
        insertGasto(gasto);
    }
    private void insertGasto(Gasto gasto) {
        String sql = "INSERT INTO gastos (gastos_id, describcion_g, cantidad_g, fecha_de_gasto) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, gasto.getId());
            pstmt.setString(2, gasto.getDescripcionDGasto());
            pstmt.setString(3, gasto.getCantidadDGasto());
            pstmt.setString(4, gasto.getFechaDGasto());
            pstmt.executeUpdate();
            gastosController.loadGastosFromDatabase();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void bttnsalirag(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {

    }
}

