package com.example.proyectovectorial;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;



public class MenuController {

    @FXML
    private Button btnBasicas;

    @FXML
    private Button btnDerivadas;

    @FXML
    private Button btnIntegrales;

    @FXML
    private Button button4;

    public void initialize() {
        btnBasicas.setStyle("-fx-min-width: 150px;");
        btnDerivadas.setStyle("-fx-min-width: 150px;");
        btnIntegrales.setStyle("-fx-min-width: 150px;");
        button4.setStyle("-fx-min-width: 150px;");
    }

    @FXML
    private void abrirVentanaBasicas() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("basicas-view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root,500,400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirVentanaDerivadas() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("derivadas-view.fxml"));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setScene(new Scene(root,500,400));
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}