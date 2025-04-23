package co.edu.uniquindio.poo.proyectoclinica.model;

import java.util.List;

public class SuscripcionBasica implements Suscripcion {
    @Override
    public List<Servicio> getServiciosDisponlibles() {
        return List.of();
    }

    @Override
    public Factura generarFacturaCobro() {
        return null;
    }
}
