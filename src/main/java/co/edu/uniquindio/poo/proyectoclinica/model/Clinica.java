package co.edu.uniquindio.poo.proyectoclinica.model;

import lombok.Builder;

import java.util.ArrayList;

@Builder
public class Clinica {
    private ArrayList<Cita> citas;
    private ArrayList<Servicio> servicios;
    private ArrayList<Paciente> pacientes;
    public Clinica() {
        this.citas = new ArrayList<>();
        this.servicios = new ArrayList<>();
        this.pacientes = new ArrayList<>();
    }


}
