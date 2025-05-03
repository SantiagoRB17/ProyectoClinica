package co.edu.uniquindio.poo.proyectoclinica.model;

import co.edu.uniquindio.poo.proyectoclinica.servicios.ServicioServiciosDisponibles;
import java.util.List;

public class SuscripcionPremium implements Suscripcion {
    private final ServicioServiciosDisponibles servicioServicios;

    public SuscripcionPremium() {
        this.servicioServicios = new ServicioServiciosDisponibles();
    }

    @Override
    public List<Servicio> getServiciosDisponlibles() {
        // Solo devuelve servicios Premium (los básicos se verifican aparte)
        return servicioServicios.getServiciosPremium();
    }

    @Override
    public List<Servicio> getServiciosDisponibles() {
        try {
            return List.of();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Factura generarFacturaCobro(Paciente paciente, Servicio servicio) throws Exception {
        double subTotal = servicio.getPrecio();
        double total = subTotal;

        if (servicioServicios.getServiciosPremium().stream()
                .anyMatch(s -> s.getNombre() == servicio.getNombre())) {
            total = 0; // 100% descuento para Premium
        } else if (servicioServicios.getServiciosBasicos().stream()
                .anyMatch(s -> s.getNombre() == servicio.getNombre())) {
            total = 0; // 100% descuento para Básicos
        }

        // Los servicios sin suscripción mantienen el precio completo

        return Factura.builder()
                .subTotal(subTotal)
                .total(total)
                .build();
    }

    @Override
    public String toString() {
        return "Premium";
    }
}
