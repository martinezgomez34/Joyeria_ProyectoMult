package com.eduard034.joyeria_proyectomult.controllers.gastos;

import java.net.URL;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import com.eduard034.joyeria_proyectomult.models.Database;
import com.eduard034.joyeria_proyectomult.models.Gasto;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class BgastosController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField Bgastosmg;

    @FXML
    private Button bttnbuscarg;

    @FXML
    private Button bttnsalirbg;

    @FXML
    void bttnbuscarg(MouseEvent event) {
        Database database = JoyeriaApp.getData();
        int idBusqueda = Integer.parseInt(Bgastosmg.getText());
        boolean busqueda = true;
        for (Gasto item: JoyeriaApp.getData().getListaGastos()) {
            if (item.getId()==idBusqueda) {
                busqueda = false;
                database.setIdBusqueda(idBusqueda);
                JoyeriaApp.newStage("ModificarG.fxml","Modificar Gastos");
            }
        }
        if (busqueda) {
            showAlert(Alert.AlertType.ERROR, "Error", "No se encontró el ID.");
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
    void bttnsalirbg(MouseEvent event) {
        JoyeriaApp.getStageView().close();
    }

    @FXML
    void initialize() {
        assert Bgastosmg != null : "fx:id=\"Bgastosmg\" was not injected: check your FXML file 'BuscarG.fxml'.";
        assert bttnbuscarg != null : "fx:id=\"bttnbuscarg\" was not injected: check your FXML file 'BuscarG.fxml'.";
        assert bttnsalirbg != null : "fx:id=\"bttnsalirbg\" was not injected: check your FXML file 'BuscarG.fxml'.";

    }

}
