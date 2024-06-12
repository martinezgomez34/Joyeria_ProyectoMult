package com.eduard034.joyeria_proyectomult.controllers.joyas;

import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.DatabaseHatler;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import com.eduard034.joyeria_proyectomult.models.Joya;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class AjoyasController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Acantidadj;

    @FXML
    private TextField Adescripcionj;

    @FXML
    private TextField Anombrej;

    @FXML
    private Button bttnagregarj;

    @FXML
    private Button bttnsaliraj;

    @FXML
    void bttnagregarj(MouseEvent event) {
        Random generar = new Random();
        int id = generar.nextInt(1000);
        String nombre = Anombrej.getText();
        String cantidad = Acantidadj.getText();
        String descripcion = Adescripcionj.getText();
        Joya joya = new Joya(id,nombre,cantidad,descripcion);
        JoyeriaApp.getData().setListaJoya(joya);
        JoyeriaApp.getStageView().close();
        insertJoya(joya);
    }
    private void insertJoya(Joya joya) {
        String sql = "INSERT INTO joya (joya_id, nombre_joya, cantidad_joya, description) VALUES (?, ?, ?, ?)";

        try (Connection conn = DatabaseHatler.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, joya.getIdJoya());
            pstmt.setString(2, joya.getNombreJoya());
            pstmt.setString(3, joya.getCantidadDJoya());
            pstmt.setString(4, joya.getDescripcionDJoya());
            pstmt.executeUpdate();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    @FXML
    void bttnsaliraj(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {

    }

}
