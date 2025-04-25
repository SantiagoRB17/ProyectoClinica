package co.edu.uniquindio.poo.proyectoclinica.model;

import lombok.Builder;

import java.time.LocalDateTime;
import java.util.UUID;

@Builder
public class Factura {
    private LocalDateTime fecha;
    @Builder.Default
    private UUID id=UUID.randomUUID();
    private double total;
    private double subTotal;
}
