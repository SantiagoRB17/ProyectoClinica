package co.edu.uniquindio.poo.proyectoclinica.repositorios;

import co.edu.uniquindio.poo.proyectoclinica.model.Cita;
import co.edu.uniquindio.poo.proyectoclinica.model.Servicio;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.UUID;

public class RepositorioCitas {
    @Getter
    private final ArrayList<Cita> citas;

    public RepositorioCitas() {
        this.citas = new ArrayList<>();
    }

    /**
     * Metodo que permite agregar una cita a la lista de citas
     * @param cita cita a agregar
     * @throws Exception arroja una excepcion si la cita ya existe
     */
    public void agregarCita(Cita cita) throws Exception{
        if(!validarCita(cita)) {
            citas.add(cita);
        }else{
            throw new Exception("La cita ya existe");
        }
    }

    /**
     * Metodo que valida si hay citas con la misma hora y fecha
     * @param fecha fecha y hora de la cita
     * @return true si hay una cita, false si no hay citas con esa hora y fecha
     */
    public boolean validarHoraCita(LocalDateTime fecha){
        return citas.stream().anyMatch(cita -> cita.getFecha().equals(fecha));
    }

    /**
     * Metodo que valida si una cita existe en la lista de citas
     * @param cita cita a validar
     * @return true si la cita existe false si no existe
     */
    public boolean validarCita(Cita cita){
        return citas.stream().anyMatch(c-> c.getId().equals(cita.getId()));
    }

    /**
     * Metodo que permite cancelar una cita
     * @param id ide de la cita a cancelar
     * @throws Exception arroja no excepcion si no encuentra una cita
     */
    public void cancelarCita(UUID id) throws Exception{
        Cita citaAEliminar=buscarCita(id);
        if(citaAEliminar!=null) {
            citas.remove(citaAEliminar);
        }else{
            throw new Exception("Cita no encontrada");
        }
    }

    /**
     * Metodo que que busca una cita segun su id
     * @param id de la cita
     * @return la cita encontrada o null si no encontro una cita
     */
    public Cita buscarCita(UUID id) {
        return citas.stream().filter(c -> c.getId().equals(id)).findFirst().orElse(null);
    }
}
