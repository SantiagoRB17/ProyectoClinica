package co.edu.uniquindio.poo.proyectoclinica.model;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@Builder
@Getter
public class Servicio {
    private double precio;
    @Builder.Default
    @Getter
    private UUID id= UUID.randomUUID();
    private ServiciosDisponibles nombre;

    @Override
    public String toString() {
        return "Nombre: " + nombre + ", Precio: " + precio;

    }
}
