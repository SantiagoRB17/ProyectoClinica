package co.edu.uniquindio.poo.proyectoclinica.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.layout.StackPane;

public class PanelController {
    @FXML
    private StackPane panelPrincipal;

    public void mostrarRegistroPaciente(ActionEvent actionEvent) {
        Parent node =cargarPanel("/registroPaciente.fxml");

        panelPrincipal.getChildren().setAll(node);
    }

    public void mostrarListaPacientes(ActionEvent actionEvent) {
        Parent node = cargarPanel("/listarPacientes.fxml");

        panelPrincipal.getChildren().setAll(node);
    }

    public void mostrarRegistroCita(ActionEvent actionEvent) {
        Parent node = cargarPanel("/registroCita.fxml");

        panelPrincipal.getChildren().setAll(node);
    }

    public void mostrarListaCitas(ActionEvent actionEvent) {
        Parent node = cargarPanel("/listaCitas.fxml");

        panelPrincipal.getChildren().setAll(node);
    }

    private Parent cargarPanel(String fxmlFile) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent node = loader.load();
            return node;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}
