package co.edu.uniquindio.poo.proyectoclinica.model;

import co.edu.uniquindio.poo.proyectoclinica.servicios.IClinicaServicio;
import co.edu.uniquindio.poo.proyectoclinica.servicios.ServicioPacientes;
import lombok.Builder;

import java.util.ArrayList;
import java.util.List;

@Builder
public class Clinica implements IClinicaServicio {

    private final ServicioPacientes servicioPacientes;


    @Override
    public void registrarPaciente( String nombre, String telefono, String cedula, String email,
                                   Suscripcion suscripcion) throws Exception{

    }

    @Override
    public List<Servicio> getServiciosDisponibles() {
        return List.of();
    }

    @Override
    public void registrarServicio() {

    }

    @Override
    public void registrarCita() {

    }

    @Override
    public Factura generarFactura() {
        return null;
    }

    @Override
    public List<Servicio> getServiciosDisponibles(Suscripcion suscripcion) {
        return List.of();
    }
}
