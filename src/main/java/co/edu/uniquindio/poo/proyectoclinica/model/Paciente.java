package co.edu.uniquindio.poo.proyectoclinica.model;

import co.edu.uniquindio.poo.proyectoclinica.servicios.ServicioPacientes;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@AllArgsConstructor
@Setter
@Getter

public class Paciente   {
    String nombre;

    String telefono;
    final  String  cedula;
    String email;
    Suscripcion suscripcion;


}
