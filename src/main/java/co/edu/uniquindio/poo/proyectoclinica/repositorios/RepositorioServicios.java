package co.edu.uniquindio.poo.proyectoclinica.repositorios;

import co.edu.uniquindio.poo.proyectoclinica.model.Servicio;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RepositorioServicios{
    /**
     * Lista de servicios premium
     */
    @Getter
    public List<Servicio> serviciosPremium=List.of(
            Servicio.builder().nombre("Cardiologia").precio(80000).build(),
            Servicio.builder().nombre("Pediatria").precio(50000).build(),
            Servicio.builder().nombre("Dermatologia").precio(30000).build(),
            Servicio.builder().nombre("Terapia Respiratoria").precio(70000).build(),
            Servicio.builder().nombre("Control Prenatal").precio(40000).build()
    );
    /**
     *Lista de servicios basicos
     */
    @Getter
    public  List<Servicio> serviciosBasica=List.of(
            Servicio.builder().nombre("Nutricionismo").precio(50000).build(),
            Servicio.builder().nombre("Odontologia").precio(50000).build(),
            Servicio.builder().nombre("Electrocardiograma").precio(70000).build(),
            Servicio.builder().nombre("Radiografia").precio(50000).build()
    );
    /**
     * Lista de servicios sin suscripcion
     */
    @Getter
    public List<Servicio> serviciosSinSuscripcion=List.of(
            Servicio.builder().nombre("Examen visual").precio(20000).build(),
            Servicio.builder().nombre("Consulta psicología").precio(40000).build(),
            Servicio.builder().nombre("Terapia fisica").precio(40000).build()
    );
    /**
     * Todos los servicios disponibles, premium, basicos y los que no pertenecen a ninguna suscripcion
     */
    @Getter
    public List<Servicio> serviciosDisponibles= Stream.of(
            serviciosSinSuscripcion,
            serviciosPremium,
            serviciosBasica
    ).flatMap(List::stream).collect(Collectors.toList());


}