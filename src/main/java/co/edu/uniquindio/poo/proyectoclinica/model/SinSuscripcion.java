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
    public List<Servicio> getServiciosDisponibles() {
        return List.of();
    }

    @Override
    public Factura generarFacturaCobro(Paciente paciente,Servicio servicio) {
        double subTotal=servicio.getPrecio();
        double total=subTotal;
        return Factura.builder()
                .subTotal(subTotal)
                .total(total)
                .build();
    }
    @Override
    public String toString() {
        return "Sin suscripcion";
    }
}
