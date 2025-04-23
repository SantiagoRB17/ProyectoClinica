package co.edu.uniquindio.poo.proyectoclinica.model;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public class Cita {
    Paciente paciente;
    String id;
    LocalDateTime fecha;
    Servicio servicio;
    Factura factura;
}
