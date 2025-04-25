module ProyectoClinica {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;

    opens co.edu.uniquindio.poo.proyectoclinica.model to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectoclinica.model;
    exports co.edu.uniquindio.poo.proyectoclinica.servicios;
    opens co.edu.uniquindio.poo.proyectoclinica.servicios to javafx.fxml;
}