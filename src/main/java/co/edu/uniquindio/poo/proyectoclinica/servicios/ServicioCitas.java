package co.edu.uniquindio.poo.proyectoclinica.servicios;

import co.edu.uniquindio.poo.proyectoclinica.model.Cita;
import co.edu.uniquindio.poo.proyectoclinica.model.Paciente;
import co.edu.uniquindio.poo.proyectoclinica.model.Servicio;
import co.edu.uniquindio.poo.proyectoclinica.repositorios.RepositorioCitas;
import co.edu.uniquindio.poo.proyectoclinica.repositorios.RepositorioPacientes;
import co.edu.uniquindio.poo.proyectoclinica.repositorios.RepositorioServicios;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

public class ServicioCitas {

    private final RepositorioCitas repositorioCitas= new RepositorioCitas();
    private final RepositorioPacientes repositorioPacientes = RepositorioPacientes.getInstance();

    /**
     * Metodo que permite crear y agregar una cita
     * @param cedula cedula del paciente
     * @param servicio servicio perteneciente a la cita
     * @param fecha fecha y hora de la cita
     * @throws Exception excepcion si los campos estan vacios, el paciente no existe o ya hay una cita en esa misma hora
     */
    public void agregarCita(String cedula, Servicio servicio, LocalDateTime fecha) throws Exception{
        if(cedula==null || cedula.isEmpty() || fecha==null){
            throw new Exception("Todos los campos son obligatorios");
        }
        if(servicio==null){
            throw new Exception("Seleccione un servicio");
        }
        if(repositorioCitas.validarHoraCita(fecha)){
            throw new Exception("Ya hay una cita programada en esta hora y fecha");
        }
        Paciente paciente = repositorioPacientes.buscarPaciente(cedula);
        if(paciente==null){
            throw new Exception("Paciente no encontrado");
        }
        Cita cita= Cita.builder()
                .paciente(paciente)
                .servicio(servicio)
                .fecha(fecha)
                .build();
        repositorioCitas.agregarCita(cita);
        }

    /**
     * Metodo que permite eliminar una cita
     * @param id id de la cita a eliminar
     * @throws Exception
     */
    public void cancelarCita(UUID id) throws Exception {
        repositorioCitas.cancelarCita(id);
    }

    /**
     * Metodo que recupera la lista de citas del repositorio
     * @return lista de citas
     */
    public List<Cita> listarCitas(){
        return repositorioCitas.getCitas();
    }

}
