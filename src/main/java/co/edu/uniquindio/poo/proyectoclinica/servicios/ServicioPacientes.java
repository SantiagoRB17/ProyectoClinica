package co.edu.uniquindio.poo.proyectoclinica.servicios;

import co.edu.uniquindio.poo.proyectoclinica.model.Paciente;
import co.edu.uniquindio.poo.proyectoclinica.model.Suscripcion;
import co.edu.uniquindio.poo.proyectoclinica.repositorios.RepositorioPacientes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServicioPacientes {
    private final RepositorioPacientes repositorioPacientes=RepositorioPacientes.getInstance();

    public ServicioPacientes() {
    }

    public void registrarPaciente(String cedula,String nombre,String email,String telefono,Suscripcion suscripcion) throws Exception {
        if(cedula==null||cedula.isEmpty() || nombre==null || nombre.isEmpty()||email==null || email.isEmpty()
                ||telefono==null || telefono.isEmpty()){
            throw new Exception("Todos los campos son obligatorios");
        }
        if(!validarExpresionRegular(email)){
            throw new Exception("Formato de correo invalido");
        }
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

    /**
     * Metodo que válida si una direccion de correo es válida
     */
    public static boolean validarExpresionRegular(String correo){
        String regexEmail="^[a-zA-Z0-9._%+-]+@[a-zA-z0-9.-]+\\.[a-zA-Z]{2,6}$";
        Pattern expresionValida=Pattern.compile(regexEmail);
        Matcher matcher=expresionValida.matcher(correo);
        boolean valido;
        valido= matcher.matches();
        return valido;
    }
}
