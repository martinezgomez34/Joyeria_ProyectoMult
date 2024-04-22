package com.eduard034.joyeria_proyectomult.controllers.joyas;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import com.eduard034.joyeria_proyectomult.models.Joya;
import com.eduard034.joyeria_proyectomult.models.Pedid0s;
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
        boolean Iddelete = true;
        for (Joya ver : JoyeriaApp.getData().getListaJoya()){
            if (ver.getIdJoya() == ide){
                Iddelete = false;
                Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
                alertC.setHeaderText("Eliminar Joya");
                alertC.setContentText("¿Estas seguro de eliminar esta joya?");
                Optional<ButtonType> result = alertC.showAndWait();
                if (result.isPresent() && result.get() == ButtonType.OK){
                    JoyeriaApp.getData().getListaJoya().remove(ver);
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