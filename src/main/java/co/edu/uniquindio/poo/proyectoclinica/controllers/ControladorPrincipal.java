package co.edu.uniquindio.poo.proyectoclinica.controllers;

import co.edu.uniquindio.poo.proyectoclinica.servicios.ClinicaServicio;
import javafx.scene.control.Alert;
import lombok.Getter;

public class ControladorPrincipal {
    private static ControladorPrincipal instancia;

    @Getter
    private final ClinicaServicio clinica;


    private ControladorPrincipal(){
        clinica = new ClinicaServicio();
    }


    public static ControladorPrincipal getInstancia(){
        if(instancia == null){
            instancia = new ControladorPrincipal();
        }
        return instancia;
    }


    public void crearAlerta(String mensaje, Alert.AlertType tipo){
        Alert alert = new Alert(tipo);
        alert.setTitle("Alerta");
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

}
