package co.edu.uniquindio.poo.proyectoclinica.model;

import java.util.List;

public interface Suscripcion {
    List<Servicio> getServiciosDisponlibles();
    Factura generarFacturaCobro();
}
