package co.edu.uniquindio.poo.proyectoclinica.controllers;

import co.edu.uniquindio.poo.proyectoclinica.model.Cita;
import co.edu.uniquindio.poo.proyectoclinica.model.Paciente;
import co.edu.uniquindio.poo.proyectoclinica.model.Suscripcion;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class ListaPacientesControlador implements Initializable {

    @FXML
    private TableColumn<Paciente, String> clCorreo;

    @FXML
    private TableColumn<Paciente, String> clIdentificacion;

    @FXML
    private TableColumn<Paciente, String> clNombre;

    @FXML
    private TableColumn<Paciente, String> clSuscripcion;

    @FXML
    private TableColumn<Paciente, String> clTelefono;

    @FXML
    private TableView<Paciente> tablaPacientes;

    ControladorPrincipal controladorPrincipal=ControladorPrincipal.getInstancia();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clIdentificacion.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getCedula()));
        clNombre.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getNombre()));
        clTelefono.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getTelefono()));
        clCorreo.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getEmail()));
        clSuscripcion.setCellValueFactory(cellData-> new SimpleObjectProperty<>(cellData.getValue().getSuscripcion().toString()));

        cargarDatosTabla();
    }
    private void cargarDatosTabla() {
        try {
            List<Paciente> lista = controladorPrincipal.getClinica().recuperarlistaPacientes();
            tablaPacientes.setItems(FXCollections.observableArrayList(lista));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

