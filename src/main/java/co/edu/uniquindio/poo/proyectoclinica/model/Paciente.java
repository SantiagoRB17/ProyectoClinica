package co.edu.uniquindio.poo.proyectoclinica.model;

import lombok.Builder;

@Builder
public class Paciente {
    String nombre;
    String telefono;
    String cedula;
    String email;
    Suscripcion suscripcion;

}
