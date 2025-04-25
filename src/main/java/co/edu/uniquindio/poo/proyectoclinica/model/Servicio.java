package co.edu.uniquindio.poo.proyectoclinica.model;

import lombok.Builder;

import java.util.UUID;

@Builder
public class Servicio {
    private double precio;
    @Builder.Default
    private UUID id= UUID.randomUUID();
    private String nombre;
}
