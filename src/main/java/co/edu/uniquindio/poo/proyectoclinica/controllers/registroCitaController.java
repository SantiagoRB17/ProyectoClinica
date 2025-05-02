package co.edu.uniquindio.poo.proyectoclinica.controllers;

import co.edu.uniquindio.poo.proyectoclinica.model.Servicio;
import co.edu.uniquindio.poo.proyectoclinica.repositorios.RepositorioServicios;
import co.edu.uniquindio.poo.proyectoclinica.servicios.ClinicaServicio;
import co.edu.uniquindio.poo.proyectoclinica.servicios.ServicioCitas;
import com.dlsc.gemsfx.TimePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class registroCitaController implements Initializable {

    @FXML
    private Button btnCrearCita;

    @FXML
    private Button btnLimpiarCampos;

    @FXML
    private ComboBox<Servicio> cmbServiciosDisponibles;

    @FXML
    private DatePicker datePickerFechaCita;

    @FXML
    private TimePicker timePickerHoraCita;

    @FXML
    private TextField txtFieldCedulaPaciente;

    @FXML
    void crearCita(ActionEvent event) {
        try{
            LocalDateTime fecha=obtenerFechaHoraSeleccionada();
            controladorPrincipal.getClinica().registrarCita(txtFieldCedulaPaciente.getText(),cmbServiciosDisponibles.getValue(),fecha);
            controladorPrincipal.crearAlerta("Cita creada con exito",Alert.AlertType.INFORMATION);
            limpiarCampos();
        }catch (Exception e){
            controladorPrincipal.crearAlerta(e.getMessage(),Alert.AlertType.ERROR);
        }
    }

    @FXML
    void limpiarFormulario(ActionEvent event) {
        limpiarCampos();
    }

    ControladorPrincipal controladorPrincipal=ControladorPrincipal.getInstancia();
    ObservableList<Servicio> serviciosDisponibles = FXCollections.observableArrayList(
            controladorPrincipal.getClinica().getServiciosDisponibles());

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cmbServiciosDisponibles.getItems().addAll(serviciosDisponibles);
    }

    /**
     * Metodo que transforma los campos independiente de fecha y hora en un solo local date time
     * @return un objeto de tipo local date time
     * @throws Exception arroja una excepcion si hay una fecha u hora seleccionada
     */
    private LocalDateTime obtenerFechaHoraSeleccionada() throws Exception {
        LocalDate fecha = datePickerFechaCita.getValue();
        LocalTime hora = timePickerHoraCita.getTime();

        if (fecha != null && hora != null) {
            return LocalDateTime.of(fecha, hora);
        } else {
            throw new Exception("Debe seleccionar una fecha y hora");
        }
    }

    /**
     * Metodo que permite limpiar los campos del formulario
     */
    public void limpiarCampos() {
        txtFieldCedulaPaciente.clear();
        datePickerFechaCita.setValue(null);
        timePickerHoraCita.setTime(LocalTime.now());
        cmbServiciosDisponibles.setValue(null);
    }

}

