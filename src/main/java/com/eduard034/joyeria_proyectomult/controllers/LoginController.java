package com.eduard034.joyeria_proyectomult.controllers;

import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;

import com.eduard034.joyeria_proyectomult.JoyeriaApp;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import org.controlsfx.control.PlusMinusSlider;

public class LoginController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField actualpswd;

    @FXML
    private Button bttnchangepswd;

    @FXML
    private Button bttniniciar;

    @FXML
    private ImageView imagen;

    @FXML
    private TextField ingresarpswd;

    @FXML
    private TextField nuevapswd;

    int pass = 4321;
    public String Ingresarusuario(){

        return ingresarpswd.getText();
    }
    public String changepass1(){
        return actualpswd.getText();
    }
    public String changepass2(){
        return nuevapswd.getText();
    }
    public String passwordpred (){
        return Integer.toString(pass);
    }
    @FXML
    void bttnchangepswd(MouseEvent event) {
        if (changepass1().equals(passwordpred())){
            Alert alertC = new Alert(Alert.AlertType.CONFIRMATION);
            alertC.setHeaderText("Confirmar cambio de contraseña");
            alertC.setContentText("¿Estas seguro que quieres cambiar tu contraseña?");
            Optional<ButtonType> result = alertC.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK){
                pass = Integer.parseInt(changepass2());
                Alert alertI = new Alert(Alert.AlertType.INFORMATION);
                alertI.setHeaderText("Contraseña cambiada");
                alertI.setContentText("Su contraseña se cambio exitosamente");
                alertI.showAndWait();
            }
        }else {
            Alert alertE = new Alert(Alert.AlertType.ERROR);
            alertE.setHeaderText("Error en su contraseña actual");
            alertE.setContentText("Su contraseña es incorrecta, intentelo de nuevo");
            alertE.showAndWait();
        }
    }

    @FXML
    void bttniniciar(MouseEvent event) {
        if (Ingresarusuario().equals(passwordpred())){
            JoyeriaApp.newStage("home.fxml", "home");
        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Error");
            alert.setContentText("Su contraseña es incorrecta");
            alert.showAndWait();
        }
    }
    @FXML
    void bttnexit(MouseEvent event) {
        Platform.exit();
    }
    @FXML
    void initialize() {
        assert actualpswd != null : "fx:id=\"actualpswd\" was not injected: check your FXML file 'InicioSecion.fxml'.";
        assert bttnchangepswd != null : "fx:id=\"bttnchangepswd\" was not injected: check your FXML file 'InicioSecion.fxml'.";
        assert bttniniciar != null : "fx:id=\"bttniniciar\" was not injected: check your FXML file 'InicioSecion.fxml'.";
        assert imagen != null : "fx:id=\"imagen\" was not injected: check your FXML file 'InicioSecion.fxml'.";
        assert ingresarpswd != null : "fx:id=\"ingresarpswd\" was not injected: check your FXML file 'InicioSecion.fxml'.";
        assert nuevapswd != null : "fx:id=\"nuevapswd\" was not injected: check your FXML file 'InicioSecion.fxml'.";

    }

}
