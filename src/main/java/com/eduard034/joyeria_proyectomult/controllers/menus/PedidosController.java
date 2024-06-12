package com.eduard034.joyeria_proyectomult.controllers.menus;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.DatabaseHatler;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import com.eduard034.joyeria_proyectomult.models.Pedid0s;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class PedidosController {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML
    private AnchorPane BActu;

    @FXML
    private TableColumn<Pedid0s, Integer> MosCant;

    @FXML
    private TableColumn<Pedid0s, Integer> MosContact;

    @FXML
    private TableColumn<Pedid0s,Integer> MosID;

    @FXML
    private TableColumn<Pedid0s, String> MosNom;

    @FXML
    private TableColumn<Pedid0s, String> Mosfecha;

    @FXML
    private TableColumn<Pedid0s, String> Moshora;

    @FXML
    private TableColumn<Pedid0s, Integer> Mostipo;
    @FXML
    private TableView<Pedid0s> Mpedidos;
    private ObservableList<Pedid0s> pedid0sList = FXCollections.observableArrayList();
    @FXML
    private Button Bactu;

    @FXML
    private Button agregarPedidosButton;

    @FXML
    private Button eliminarPedidosButton;

    @FXML
    private Button exitPedidosButton;

    @FXML
    private Button modificarPedidosButton;
    @FXML
    void BActu(MouseEvent event) {
        loadGastosFromDatabase();
    }
    public void loadGastosFromDatabase() {
        String sql = "SELECT * FROM pedidos";
        pedid0sList.clear();

        try (Connection conn = DatabaseHatler.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                Pedid0s pedid0s = new Pedid0s(
                        rs.getInt("pedidos_id"),
                        rs.getString("nombre_pedido"),
                        rs.getInt("contacto_phonum"),
                        rs.getString("tipo_joya"),
                        rs.getInt("cantidad"),
                        rs.getString("fecha"),
                        rs.getString("hora")
                );
                pedid0sList.add(pedid0s);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        Mpedidos.setItems(pedid0sList);
    }
    @FXML
    void onClickAgregarPedidosButton(MouseEvent event) {
    JoyeriaApp.newStage("AgregarP.fxml","AgregarPedidos");
    }

    @FXML
    void onClickEliminarPedidosButton(MouseEvent event) {
    JoyeriaApp.newStage("EliminarP.fxml","EliminarPedidos");
    }

    @FXML
    void onClickExitPedidosButton(MouseEvent event) {
        JoyeriaApp.newStage("home.fxml","home");
    }

    @FXML
    void onClickModificarPedidosButton(MouseEvent event) {
        JoyeriaApp.newStage("BuscarP.fxml","Buscar Pedidos Para Modificar");
    }

    @FXML
    void initialize() {
        MosID.setCellValueFactory(new PropertyValueFactory<>("id"));
        MosNom.setCellValueFactory(new PropertyValueFactory<>("nombrec"));
        MosContact.setCellValueFactory(new PropertyValueFactory<>("contactoc"));
        Mostipo.setCellValueFactory(new PropertyValueFactory<>("tipoj"));
        MosCant.setCellValueFactory(new PropertyValueFactory<>("cantidadj"));
        Mosfecha.setCellValueFactory(new PropertyValueFactory<>("fechap"));
        Moshora.setCellValueFactory(new PropertyValueFactory<>("horap"));
        Mpedidos.setItems(pedid0sList);
        loadGastosFromDatabase();
    }
}
