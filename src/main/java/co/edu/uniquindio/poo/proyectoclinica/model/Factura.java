package co.edu.uniquindio.poo.proyectoclinica.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;
@Getter
@Setter
@Builder
public class Factura {
    private LocalDateTime fecha;
    @Builder.Default
    private UUID id=UUID.randomUUID();
    private double total;
    private double subTotal;
}
