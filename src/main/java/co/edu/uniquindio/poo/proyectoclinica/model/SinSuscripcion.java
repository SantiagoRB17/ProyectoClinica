package co.edu.uniquindio.poo.proyectoclinica.model;

import co.edu.uniquindio.poo.proyectoclinica.servicios.ServicioServiciosDisponibles;

import java.util.List;

public class SinSuscripcion implements Suscripcion{

    @Override
    public List<Servicio> getServiciosDisponlibles() {
        ServicioServiciosDisponibles servicioServiciosDisponibles=new ServicioServiciosDisponibles();
        return servicioServiciosDisponibles.getServiciosSinSuscripcion();
    }

    @Override
    public Factura generarFacturaCobro() {
        return null;
    }
    @Override
    public String toString() {
        return "Sin suscripcion";
    }
}
