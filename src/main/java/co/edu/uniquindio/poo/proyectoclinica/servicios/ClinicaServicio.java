package co.edu.uniquindio.poo.proyectoclinica.servicios;

import co.edu.uniquindio.poo.proyectoclinica.model.*;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClinicaServicio implements IClinicaServicio{

    ServicioCitas servicioCitas = new ServicioCitas();
    ServicioPacientes servicioPacientes = new ServicioPacientes();
    ServicioServiciosDisponibles servicioServiciosDisponibles = new ServicioServiciosDisponibles();

    @Override
    public void registrarPaciente(String nombre, String telefono, String cedula, String email,
                                  Suscripcion suscripcion) throws Exception {
        servicioPacientes.registrarPaciente(cedula,nombre,email, telefono, suscripcion);
    }

    /**
     * Metodo que recupera la lista de todos los servicios
     * @return lista de servicios disponibles
     */
    @Override
    public List<Servicio> getServiciosDisponibles() {
        return servicioServiciosDisponibles.getServiciosDisponibles();
    }

    /**
     * Metodo que permite registrar una cita
     * @param cedula cedula del paciente
     * @param servicio servicio que sera prestado en la cita
     * @param fecha fecha de la cita
     * @throws Exception
     */
    @Override
    public void registrarCita(String cedula, Servicio servicio, LocalDateTime fecha) throws Exception {
        servicioCitas.agregarCita(cedula,servicio,fecha);
    }

    /**
     * Metodo que permite cancelar una cita
     * @param id id de la cita a cancelar
     * @throws Exception
     */
    @Override
    public void cancelarCita(UUID id) throws Exception {
        servicioCitas.cancelarCita(id);
    }

    @Override
    public Factura generarFactura() {
        return null;
    }

    /**
     * Metodo que recupera la lista de servicios segun la suscripcion
     * @param suscripcion suscripcion
     * @return lista de servicios disponibles segun la suscripcion
     */
    @Override
    public List<Servicio> getServiciosDisponibles(Suscripcion suscripcion) {
            return suscripcion.getServiciosDisponlibles();
    }

    /**
     * Metodo que lista las suscripciones como una cadena para enviarlo al combo box
     * @return lista de cadenas
     */
    public List<String> listarSuscripciones() {
        return List.of("Premium", "Básica", "Sin suscripcion");
    }

    /**
     * Metodo que recupera la lista de citas de la clase servicio citas
     * @return lista de citas
     */
    public List<Cita> recuperarlistaCitas() {
        return servicioCitas.listarCitas();
    }

    public List<Paciente> recuperarlistaPacientes() {
        return servicioPacientes.listarPacientes();
    }

    public List<Servicio> recuperarServiciosPremium() {
        return servicioServiciosDisponibles.getServiciosPremium();
    }
    public List<Servicio> recuperarServiciosBasicos() {
        return servicioServiciosDisponibles.getServiciosBasicos();
    }
    public List<Servicio> recuperarServiciosSinSuscripcion() {
        return servicioServiciosDisponibles.getServiciosSinSuscripcion();
    }
}
