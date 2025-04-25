package co.edu.uniquindio.poo.proyectoclinica.model;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public class Cita {
    Paciente paciente;
    @Builder.Default
    UUID id=UUID.randomUUID();
    LocalDateTime fecha;
    Servicio servicio;
    Factura factura;
}
