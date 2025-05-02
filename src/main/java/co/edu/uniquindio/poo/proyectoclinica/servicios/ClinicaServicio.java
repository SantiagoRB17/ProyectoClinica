package co.edu.uniquindio.poo.proyectoclinica.servicios;

import co.edu.uniquindio.poo.proyectoclinica.model.*;

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

    @Override
    public List<Servicio> getServiciosDisponibles() {
        return servicioServiciosDisponibles.getServiciosDisponibles();
    }


    @Override
    public void registrarCita(String cedula, Servicio servicio, LocalDateTime fecha) throws Exception {
        servicioCitas.agregarCita(cedula,servicio,fecha);
    }

    @Override
    public void cancelarCita(UUID id) throws Exception {
        servicioCitas.cancelarCita(id);
    }

    @Override
    public Factura generarFactura() {
        return null;
    }

    @Override
    public List<Servicio> getServiciosDisponibles(Suscripcion suscripcion) {
            return suscripcion.getServiciosDisponlibles();
    }

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
}
