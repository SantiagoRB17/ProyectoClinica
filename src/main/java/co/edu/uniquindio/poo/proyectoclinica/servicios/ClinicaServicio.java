package co.edu.uniquindio.poo.proyectoclinica.servicios;

import co.edu.uniquindio.poo.proyectoclinica.model.*;
import co.edu.uniquindio.poo.proyectoclinica.repositorios.RepositorioPacientes;
import co.edu.uniquindio.poo.proyectoclinica.utils.EnvioEmail;
import javafx.scene.control.Alert;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClinicaServicio implements IClinicaServicio{

    ServicioCitas servicioCitas = new ServicioCitas();
    ServicioPacientes servicioPacientes = new ServicioPacientes();
    ServicioServiciosDisponibles servicioServiciosDisponibles = new ServicioServiciosDisponibles();

    @Override
    public void registrarPaciente(String nombre, String telefono, String cedula, String email,
                                  Suscripcion suscripcion) throws Exception {
        servicioPacientes.registrarPaciente(cedula,nombre,email, telefono, suscripcion);
    }

    /**
     * Metodo que recupera la lista de todos los servicios
     * @return lista de servicios disponibles
     */
    @Override
    public List<Servicio> getServiciosDisponibles() {
        return servicioServiciosDisponibles.getServiciosDisponibles();
    }

    /**
     * Metodo que permite registrar una cita
     * @param cedula cedula del paciente
     * @param servicio servicio que sera prestado en la cita
     * @param fecha fecha de la cita
     * @throws Exception
     */
    @Override
    public void registrarCita(String cedula, Servicio servicio, LocalDateTime fecha) throws Exception {
        servicioCitas.agregarCita(cedula, servicio, fecha);
        Paciente paciente = servicioPacientes.buscarPaciente(cedula);

        // Construir y enviar mensaje de confirmación
        String mensaje = EnvioEmail.construirMensajeCita(paciente.getNombre(), servicio.getNombre().toString(), fecha);
        EnvioEmail.enviarNotificacion(paciente.getEmail(), "Confirmación de Cita", mensaje);

        // Recuperar la cita recién creada
        List<Cita> citas = recuperarlistaCitas();
        Cita citaRecienCreada = citas.get(citas.size() - 1); // Se asume que es la última cita agregada

        // Mostrar factura emergente
        mostrarFacturaEmergente(citaRecienCreada);
    }

    /**
     * Metodo que permite cancelar una cita
     * @param id id de la cita a cancelar
     * @throws Exception
     */
    @Override
    public void cancelarCita(UUID id) throws Exception {
        servicioCitas.cancelarCita(id);
    }

    /**
     * metodo para generar la factura referente a una cita
     * @param cita
     * @return una factura asociada a una cita
     * @throws Exception
     */
    @Override
    public Factura generarFactura(Cita cita) throws Exception {
        Paciente paciente= RepositorioPacientes.getInstance().buscarPaciente(cita.getPaciente().getCedula());
        Servicio servicio= cita.getServicio();

        Factura factura= paciente.getSuscripcion().generarFacturaCobro(paciente,servicio);

        factura.setFecha(LocalDateTime.now());

        return factura;
    }

    public void mostrarFacturaEmergente(Cita cita) {
        try {
            Factura factura = generarFactura(cita);
            Servicio servicio = cita.getServicio();
            Paciente paciente = cita.getPaciente();

            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Factura Generada");
            alert.setHeaderText("Detalle de la Cita");

            String descuentoMsg = "";
            if (factura.getTotal() < factura.getSubTotal()) {
                descuentoMsg = String.format("\nDescuento (%s): $%,.2f",
                        paciente.getSuscripcion(),
                        (factura.getSubTotal() - factura.getTotal()));
            }

            String contenido = String.format(
                    "Paciente: %s\n" +
                            "Servicio: %s\n" +
                            "Tipo Servicio: %s\n" +
                            "Precio Base: $%,.2f%s\n" +
                            "TOTAL A PAGAR: $%,.2f",
                    paciente.getNombre(),
                    servicio.getNombre(),
                    obtenerTipoServicio(servicio),
                    factura.getSubTotal(),
                    descuentoMsg,
                    factura.getTotal()
            );

            alert.setContentText(contenido);
            alert.showAndWait();

        } catch (Exception e) {
            Alert error = new Alert(Alert.AlertType.ERROR);
            error.setContentText("Error al generar factura: " + e.getMessage());
            error.showAndWait();
        }
    }

    private String obtenerTipoServicio(Servicio servicio) {
        ServicioServiciosDisponibles servicios = new ServicioServiciosDisponibles();

        if (servicios.getServiciosPremium().stream().anyMatch(s -> s.getNombre() == servicio.getNombre())) {
            return "Premium";
        } else if (servicios.getServiciosBasicos().stream().anyMatch(s -> s.getNombre() == servicio.getNombre())) {
            return "Básico";
        } else {
            return "Sin Suscripción";
        }
    }


    /**
     * Metodo que recupera la lista de servicios segun la suscripcion
     * @param suscripcion suscripcion
     * @return lista de servicios disponibles segun la suscripcion
     */
    @Override
    public List<Servicio> getServiciosDisponibles(Suscripcion suscripcion) {
        return suscripcion.getServiciosDisponibles();
    }

    /**
     * Metodo que lista las suscripciones como una cadena para enviarlo al combo box
     * @return lista de cadenas
     */
    public List<TipoSuscripcion> listarSuscripciones() {
        return List.of(TipoSuscripcion.values());
    }

    /**
     * Metodo que recupera la lista de citas de la clase servicio citas
     * @return lista de citas
     */
    public List<Cita> recuperarlistaCitas() {
        return servicioCitas.listarCitas();
    }

    public List<Paciente> recuperarlistaPacientes() {
        return servicioPacientes.listarPacientes();
    }

    public List<Servicio> recuperarServiciosPremium() {
        return servicioServiciosDisponibles.getServiciosPremium();
    }
    public List<Servicio> recuperarServiciosBasicos() {
        return servicioServiciosDisponibles.getServiciosBasicos();
    }
    public List<Servicio> recuperarServiciosSinSuscripcion() {
        return servicioServiciosDisponibles.getServiciosSinSuscripcion();
    }
    public Suscripcion asginarSuscripcion(TipoSuscripcion tipoSuscripcion) {
        return servicioPacientes.asignarSuscripcionSeleccionada(tipoSuscripcion);
}
}