package co.edu.uniquindio.poo.proyectoclinica.model;

import java.util.List;

public interface Suscripcion {
    List<Servicio> getServiciosDisponlibles();

    List<Servicio> getServiciosDisponibles();
    Factura generarFacturaCobro(Paciente paciente,Servicio servicio) throws Exception;
}