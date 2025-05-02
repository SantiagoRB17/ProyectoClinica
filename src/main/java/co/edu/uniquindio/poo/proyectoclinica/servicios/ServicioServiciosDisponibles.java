package co.edu.uniquindio.poo.proyectoclinica.servicios;

import co.edu.uniquindio.poo.proyectoclinica.model.Servicio;
import co.edu.uniquindio.poo.proyectoclinica.repositorios.RepositorioServicios;

import java.util.List;

public class ServicioServiciosDisponibles {
    private final RepositorioServicios repositorioServicios = new RepositorioServicios();

    /**
     * Metodo que recupera todos los servicios disponibles
     *
     * @return lista de servicios disponibles premium
     */
    public List<Servicio> getServiciosDisponibles() {
        return repositorioServicios.getServiciosDisponibles();
    }

    /**
     * Metodo que recupera la lista de servicios premium
     *
     * @return lista de servicios premium
     */
    public List<Servicio> getServiciosPremium() {
        return repositorioServicios.getServiciosPremium();
    }

    /**
     * Metodo que recupera la lista de servicios basicos
     *
     * @return lista de servicios basicos
     */
    public List<Servicio> getServiciosBasicos() {
        return repositorioServicios.getServiciosBasica();
    }
    public List<Servicio> getServiciosSinSuscripcion() {
        return repositorioServicios.getServiciosSinSuscripcion();
    }
}
