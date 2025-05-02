package co.edu.uniquindio.poo.proyectoclinica.model;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder @Getter
public class Cita {
    private Paciente paciente;
    @Builder.Default
    private UUID id= UUID.randomUUID();
    private LocalDateTime fecha;
    private Servicio servicio;
    private Factura factura;
}
