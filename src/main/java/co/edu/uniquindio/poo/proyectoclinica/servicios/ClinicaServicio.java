package co.edu.uniquindio.poo.proyectoclinica.servicios;

import co.edu.uniquindio.poo.proyectoclinica.model.Factura;
import co.edu.uniquindio.poo.proyectoclinica.model.Servicio;
import co.edu.uniquindio.poo.proyectoclinica.model.Suscripcion;

import java.util.List;

public class ClinicaServicio implements IClinicaServicio{


    @Override
    public void registrarPaciente(String nombre, String telefono, String cedula, String email,
                                  Suscripcion suscripcion) throws Exception {

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
