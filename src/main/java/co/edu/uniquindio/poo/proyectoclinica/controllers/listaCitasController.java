package co.edu.uniquindio.poo.proyectoclinica.controllers;

import co.edu.uniquindio.poo.proyectoclinica.model.Cita;
import javafx.beans.Observable;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ResourceBundle;

public class listaCitasController implements Initializable {

    @FXML
    private Button btnCancelarCita;

    @FXML
    private TableColumn<Cita, LocalDateTime> clFecha;

    @FXML
    private TableColumn<Cita, String> clNombre;

    @FXML
    private TableColumn<Cita, Double> clPrecio;

    @FXML
    private TableView<Cita> tbCitas;

    @FXML
    void cancelarCita(ActionEvent event) {
        try{
            if(citaSeleccionada==null){
                throw new Exception("Seleccione una cita");
            }
            controladorPrincipal.getClinica().cancelarCita(citaSeleccionada.getId());
            controladorPrincipal.crearAlerta("Cita cancelada con exito",Alert.AlertType.INFORMATION);
            cargarDatosTabla();
        }catch(Exception e){
            controladorPrincipal.crearAlerta(e.getMessage(), Alert.AlertType.ERROR);
        }

    }

    private Cita citaSeleccionada;
    ControladorPrincipal controladorPrincipal=ControladorPrincipal.getInstancia();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clNombre.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue
                ().getPaciente().getNombre()));
        clPrecio.setCellValueFactory(cellData->new SimpleObjectProperty<>(cellData.
                getValue().getServicio().getPrecio()));
        clFecha.setCellValueFactory(cellData->new SimpleObjectProperty<>(cellData.
                getValue().getFecha()));

        cargarDatosTabla();

        tbCitas.setOnMouseClicked(event -> {
            citaSeleccionada = tbCitas.getSelectionModel().getSelectedItem();
        });
    }

    /**
     * Metodo que carga la lista de citas en la tabla
     */
    public void cargarDatosTabla(){
        try {
            List<Cita> lista = controladorPrincipal.getClinica().recuperarlistaCitas();
            tbCitas.setItems(FXCollections.observableArrayList(lista));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


