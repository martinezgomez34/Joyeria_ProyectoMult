package com.eduard034.joyeria_proyectomult.controllers.gastos;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Joya;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class EgastosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Beliminarp;

    @FXML
    private Button bttneliminarg;

    @FXML
    private Button bttnsalireg;

    @FXML
    private TableColumn<Gasto, String> cantidadColumnE;

    @FXML
    private TableColumn<Gasto, String> descripcionColumnE;

    @FXML
    private TableColumn<Gasto, String> fechaColumE;

    @FXML
    private TableColumn<Gasto, Integer> idColumnE;

    @FXML
    private TableView<Gasto> verColumna;

    @FXML
    void bttneliminarg(MouseEvent event) {
        int ide = Integer.parseInt(Beliminarp.getText());
        boolean Iddelete = true;
        for (Gasto ver : JoyeriaApp.getData().getListaGastos()){
            if (ver.getId() == ide){
                Iddelete = false;
                Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
                alertC.setHeaderText("Eliminar Gasto");
                alertC.setContentText("¿Estas seguro de eliminar esta gasto?");
                Optional<ButtonType> result = alertC.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK){
                    JoyeriaApp.getData().getListaGastos().remove(ver);
                    Alert alertagregar = new Alert(Alert.AlertType.INFORMATION);
                    alertagregar.setHeaderText("Se ha eliminado su pedido");
                    alertagregar.setContentText("Haga click en aceptar para continuar");
                    alertagregar.showAndWait();
                }
            }
        }
        if (Iddelete){
            Alert alerterrorp = new Alert(Alert.AlertType.ERROR);
            alerterrorp.setHeaderText("Error al eliminar");
            alerterrorp.setContentText("No se encontro el ID");
            alerterrorp.showAndWait();
        }
    }

    @FXML
    void bttnsalireg(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    private void showAlert(Alert.AlertType alertType, String title, String message) {
        Alert alert = new Alert(alertType);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
    @FXML
    void verListaGastos(MouseEvent event) {
        Database date = JoyeriaApp.getData();
        verColumna.getItems().clear();
        verColumna.getItems().addAll(date.getListaGastos());
    }

    @FXML
    void initialize() {
        idColumnE.setCellValueFactory(new PropertyValueFactory<>("id"));
        descripcionColumnE.setCellValueFactory(new PropertyValueFactory<>("descripcionDGasto"));
        cantidadColumnE.setCellValueFactory(new PropertyValueFactory<>("cantidadDGasto"));
        fechaColumE.setCellValueFactory(new PropertyValueFactory<>("fechaDGasto"));
    }

}
