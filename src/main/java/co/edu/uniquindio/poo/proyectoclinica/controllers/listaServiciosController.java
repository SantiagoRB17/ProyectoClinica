package co.edu.uniquindio.poo.proyectoclinica.controllers;

import co.edu.uniquindio.poo.proyectoclinica.model.Servicio;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class listaServiciosController implements Initializable {

    @FXML
    private TableColumn<Servicio, String> clNombre;

    @FXML
    private TableColumn<Servicio, Double> clPrecio;

    @FXML
    private TableView<Servicio> tbServicios;

    @FXML
    private MenuButton menButtonFiltros;

    @FXML
    private MenuItem menItemBasicos;

    @FXML
    private MenuItem menItemPremium;

    @FXML
    private MenuItem menItemSinCategoria;

    @FXML
    private MenuItem menItemSinFiltro;

    @FXML
    void filtrarBasicos(javafx.event.ActionEvent actionEvent) {
        cargarServiciosBasicas();
    }

    @FXML
    void filtrarPremium(javafx.event.ActionEvent actionEvent) {
        cargarServiciosPremium();
    }

    @FXML
    void filtrarSinSuscripcion(javafx.event.ActionEvent actionEvent) {
        cargarServiciosSinSuscripcion();
    }

    @FXML
    void quitarFiltro(javafx.event.ActionEvent actionEvent) {
        cargarDatosTabla();
    }

    ControladorPrincipal controladorPrincipal=ControladorPrincipal.getInstancia();
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        clNombre.setCellValueFactory(cellData->new SimpleStringProperty(cellData.getValue().getNombre()));
        clPrecio.setCellValueFactory(cellData->new SimpleObjectProperty<>(cellData.getValue().getPrecio()));

        cargarDatosTabla();
    }

    /**
     * Metodo que carga los datos en la tabla
     */
    private void cargarDatosTabla() {
        try{
            List<Servicio> lista= controladorPrincipal.getClinica().getServiciosDisponibles();
            ObservableList<Servicio> observableList= FXCollections.observableArrayList(lista);
            tbServicios.setItems(observableList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo que carga los servicios premium
     */
    private void cargarServiciosPremium(){
        try{
            List<Servicio> lista= controladorPrincipal.getClinica().recuperarServiciosPremium();
            ObservableList<Servicio> observableList= FXCollections.observableArrayList(lista);
            tbServicios.setItems(observableList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Metodo que carga los servicios basicos
     */
    private void cargarServiciosBasicas(){
        try{
            List<Servicio> lista= controladorPrincipal.getClinica().recuperarServiciosBasicos();
            ObservableList<Servicio> observableList= FXCollections.observableArrayList(lista);
            tbServicios.setItems(observableList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void cargarServiciosSinSuscripcion(){
        try{
            List<Servicio> lista= controladorPrincipal.getClinica().recuperarServiciosSinSuscripcion();
            ObservableList<Servicio> observableList= FXCollections.observableArrayList(lista);
            tbServicios.setItems(observableList);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
