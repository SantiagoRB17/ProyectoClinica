package co.edu.uniquindio.poo.proyectoclinica.servicios;

import co.edu.uniquindio.poo.proyectoclinica.model.Paciente;
import co.edu.uniquindio.poo.proyectoclinica.model.Suscripcion;
import co.edu.uniquindio.poo.proyectoclinica.repositorios.RepositorioPacientes;

import java.util.List;

public class ServicioPacientes {
    private final RepositorioPacientes repositorioPacientes;

    public ServicioPacientes() {
        this.repositorioPacientes = new RepositorioPacientes();
    }

    public void registrarPaciente(String cedula,String nombre,String email,String telefono,Suscripcion suscripcion) throws Exception {
        Paciente paciente = Paciente.builder()
                .cedula(cedula)
                .nombre(nombre)
                .email(email)
                .telefono(telefono)
                .suscripcion(suscripcion)
                .build();
        repositorioPacientes.agregarPaciente(paciente);
    }

    public void actualizarPaciente(String cedula,String nombre,String apellido,String email,String telefono,Suscripcion suscripcion) throws Exception {
        Paciente paciente=repositorioPacientes.buscarPaciente(cedula);
        if(paciente==null){
            throw  new Exception("El Paciente  no esta registrado");
        }
        repositorioPacientes.actualizarPaciente(nombre,apellido,email,telefono,suscripcion);

    }

    public void eliminarPaciente(String cedula) {
        repositorioPacientes.eliminarPaciente(cedula);
    }

    public Paciente  buscarPaciente(String cedula) {
        return repositorioPacientes.buscarPaciente(cedula);
    }

    public List<Paciente> listarPacientes() {
         return repositorioPacientes.listarPacientes();
    }

    public List<Paciente> listarPacientesPorSuscripcion(Suscripcion suscripcion) throws Exception {
        return repositorioPacientes.listarPacientePorSuscripcion(suscripcion);
    }

    public boolean existePaciente(String cedula) {
        return repositorioPacientes.existePaciente(cedula);
    }
}
