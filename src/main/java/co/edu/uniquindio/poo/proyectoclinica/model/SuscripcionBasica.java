package co.edu.uniquindio.poo.proyectoclinica.model;

import co.edu.uniquindio.poo.proyectoclinica.repositorios.RepositorioServicios;
import co.edu.uniquindio.poo.proyectoclinica.servicios.ServicioServiciosDisponibles;

import java.util.List;

public class SuscripcionBasica implements Suscripcion {
    ServicioServiciosDisponibles servicioServiciosDisponibles=new ServicioServiciosDisponibles();
    @Override
    public List<Servicio> getServiciosDisponlibles() {
        return servicioServiciosDisponibles.getServiciosBasicos();
    }

    @Override
    public Factura generarFacturaCobro() {
        return null;
    }

    @Override
    public String toString() {
        return "Basica";
    }
}
