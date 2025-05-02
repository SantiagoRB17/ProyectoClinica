package co.edu.uniquindio.poo.proyectoclinica.controllers;

import co.edu.uniquindio.poo.proyectoclinica.model.Suscripcion;
import co.edu.uniquindio.poo.proyectoclinica.model.SuscripcionBasica;
import co.edu.uniquindio.poo.proyectoclinica.model.SuscripcionPremium;
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
    private ComboBox<String> cmbTipoSuscripcion;

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
            Suscripcion suscripcion=verificarTipoSuscripcion();
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

    public Suscripcion verificarTipoSuscripcion(){
        Suscripcion suscripcion = null;
        if(cmbTipoSuscripcion.getSelectionModel().getSelectedItem()==null){
            suscripcion=null;
        } else if (cmbTipoSuscripcion.getSelectionModel().getSelectedItem().equals("Premium")) {
            suscripcion=new SuscripcionPremium();
        } else if (cmbTipoSuscripcion.getSelectionModel().getSelectedItem().equals("Básica")) {
            suscripcion=new SuscripcionBasica();
        }
        return suscripcion;
    }
}

