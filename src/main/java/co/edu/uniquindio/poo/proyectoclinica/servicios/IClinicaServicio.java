package co.edu.uniquindio.poo.proyectoclinica.servicios;

import co.edu.uniquindio.poo.proyectoclinica.model.Factura;
import co.edu.uniquindio.poo.proyectoclinica.model.Servicio;
import co.edu.uniquindio.poo.proyectoclinica.model.Suscripcion;

import java.util.List;

public interface IClinicaServicio {

    void registrarPaciente( String nombre, String telefono, String cedula, String email, Suscripcion suscripcion) throws Exception;
    List<Servicio> getServiciosDisponibles();
    void registrarServicio();
    void registrarCita();
    Factura generarFactura();
    List<Servicio> getServiciosDisponibles(Suscripcion suscripcion);

}
