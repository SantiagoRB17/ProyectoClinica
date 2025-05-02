package co.edu.uniquindio.poo.proyectoclinica.controllers;

import co.edu.uniquindio.poo.proyectoclinica.model.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class registroPacienteController implements Initializable {

    @FXML
    private Button btnCrearPaciente;

    @FXML
    private Button btnLimpiarCampos;

    @FXML
    private ComboBox<TipoSuscripcion> cmbTipoSuscripcion;

    @FXML
    private TextField txtFieldCedula;

    @FXML
    private TextField txtFieldEmail;

    @FXML
    private TextField txtFieldNombre;

    @FXML
    private TextField txtFieldTelefono;

    @FXML
    void crearPaciente(ActionEvent event) {
        try{
            if(cmbTipoSuscripcion.getSelectionModel().isEmpty()){
                throw new Exception("Seleccione un tipo de suscripcion");
            }
            Suscripcion suscripcion=verificarTipoSuscripcion(cmbTipoSuscripcion.getValue());
            controladorPrincipal.getClinica().registrarPaciente(txtFieldNombre.getText(),txtFieldTelefono.getText()
                    ,txtFieldCedula.getText(),txtFieldEmail.getText(),suscripcion);
            controladorPrincipal.crearAlerta("Paciente creado con exito",Alert.AlertType.INFORMATION);
            limpiarCampos();

        }catch(Exception e){
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }
    }

    @FXML
    void limpiarFormulario(ActionEvent event) {
        limpiarCampos();
    }


    ControladorPrincipal controladorPrincipal=ControladorPrincipal.getInstancia();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbTipoSuscripcion.getItems().addAll(controladorPrincipal.getClinica().listarSuscripciones());
    }

    public void limpiarCampos(){
        txtFieldNombre.clear();
        txtFieldCedula.clear();
        txtFieldTelefono.clear();
        txtFieldEmail.clear();
        cmbTipoSuscripcion.getSelectionModel().clearSelection();
    }

    /**
     * Metodo que verifica que tipo de suscripcion se selecciono en la suscripcion
     * @return suscripcion
     */
    public Suscripcion verificarTipoSuscripcion(TipoSuscripcion tipoSuscripcion){
        return controladorPrincipal.getClinica().asginarSuscripcion(tipoSuscripcion);
    }
}

