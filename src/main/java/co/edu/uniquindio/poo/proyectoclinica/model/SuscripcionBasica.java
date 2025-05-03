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
    public List<Servicio> getServiciosDisponibles() {
        return List.of();
    }

    @Override
    public Factura generarFacturaCobro(Paciente paciente, Servicio servicio) throws Exception {
        double subTotal = servicio.getPrecio();
        double total = subTotal;

        if (servicioServiciosDisponibles.getServiciosBasicos().stream()
                .anyMatch(s -> s.getNombre() == servicio.getNombre())) {
            total = subTotal * 0.8; // 20% de descuento para servicios básicos
        } else if (servicioServiciosDisponibles.getServiciosPremium().stream()
                .anyMatch(s -> s.getNombre() == servicio.getNombre())) {
            total = subTotal; // Cobro completo para servicios premium
        } else if (servicioServiciosDisponibles.getServiciosSinSuscripcion().stream()
                .anyMatch(s -> s.getNombre() == servicio.getNombre())) {
            total = subTotal; // Cobro completo para servicios sin suscripción
        }

        return Factura.builder()
                .subTotal(subTotal)
                .total(total)
                .build();
    }

    @Override
    public String toString() {
        return "Basica";
    }


}