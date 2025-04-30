package co.edu.uniquindio.poo.proyectoclinica.repositorios;

import co.edu.uniquindio.poo.proyectoclinica.model.Paciente;
import co.edu.uniquindio.poo.proyectoclinica.model.Suscripcion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class RepositorioPacientes {
    private final List<Paciente> pacientes;

    public RepositorioPacientes() {
        this.pacientes = new ArrayList<>();
    }


    public void agregarPaciente(Paciente paciente) throws Exception{
        if(paciente==null){
            throw new Exception(" el paciente no puede ser nuleishon");
        }
        if(buscarPaciente(paciente.getCedula())!=null){
            throw new Exception(" el paciente ya esta registrado.");
        }
        this.pacientes.add(paciente);
    }
    /**
     * Elimina un paciente por su cédula
     *
     * @param cedula Cédula del paciente a eliminar
     * @throws IllegalArgumentException si la cédula es nula o vacía
     */
    public void eliminarPaciente(String cedula) {
        if (cedula == null) {
            throw new IllegalArgumentException("El cedula no puede ser nulo");
        }
        pacientes.removeIf(c -> c.getCedula().equals(cedula));
    }

    /**
     * Busca un paciente por cédula
     *
     * @param cedula Cédula del paciente a buscar
     * @return Optional con el paciente si existe, vacío si no
     * @throws IllegalArgumentException si la cédula es nula o vacía
     */
    public Paciente buscarPaciente(String cedula) throws IllegalArgumentException {
        if (cedula == null || cedula.isBlank()) {
            throw new IllegalArgumentException("La cedula no puede ser nulo");
        }
        return pacientes.stream()
                .filter(paciente -> paciente.getCedula().equals(cedula))
                .findFirst()
                .orElse(null);
    }

    public void actualizarPaciente(String cedula,String nombre,String email,String telefono,Suscripcion suscripcion ) throws Exception{
        Paciente paciente=buscarPaciente(cedula);

        if(paciente==null){
            throw new Exception(" el paciente con el id"+cedula+"no existe");
        }
        if (nombre == null || email.isBlank() || telefono.isBlank() || suscripcion==null) {
            throw new Exception("Todos los campos son obligatorios");
        }

        paciente.setNombre(nombre);
        paciente.setEmail(email);
        paciente.setTelefono(telefono);
        paciente.setSuscripcion(suscripcion);
    }

    /**
     * Obtiene una lista inmutable de todos los pacientes
     *
     * @return Lista de pacientes
     */

    public List<Paciente> listarPacientes() {
        return Collections.unmodifiableList(pacientes);
    }

    /**
     * Filtra pacientes por tipo de suscripción
     *
     * @param suscripcion Tipo de suscripción a filtrar
     * @return Lista de pacientes con la suscripción especificada
     * @throws IllegalArgumentException si la suscripción es nula
     */
    public List<Paciente> listarPacientePorSuscripcion(Suscripcion suscripcion) throws Exception {
        if (suscripcion == null) {
            throw new IllegalArgumentException("El tipo desuscripcion no puede ser nulo");
        }
        return pacientes.stream()
                .filter(paciente -> paciente.getSuscripcion().equals(suscripcion))
                .collect(Collectors.toList());


    }

    public boolean existePaciente(String cedula) {
        return buscarPaciente(cedula) != null;
    }
}










