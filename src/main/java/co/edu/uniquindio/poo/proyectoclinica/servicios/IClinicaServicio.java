package co.edu.uniquindio.poo.proyectoclinica.servicios;

import co.edu.uniquindio.poo.proyectoclinica.model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public interface IClinicaServicio {

    void registrarPaciente( String nombre, String telefono, String cedula, String email, Suscripcion suscripcion) throws Exception;
    List<Servicio> getServiciosDisponibles();
    void registrarCita(String cedula, Servicio servicio, LocalDateTime fecha) throws Exception;
    void cancelarCita(UUID id) throws Exception;
    Factura generarFactura(Cita cita) throws Exception;
    List<Servicio> getServiciosDisponibles(Suscripcion suscripcion);

}