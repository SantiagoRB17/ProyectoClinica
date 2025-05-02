module ProyectoClinica {
    requires javafx.controls;
    requires javafx.fxml;
    requires static lombok;
    requires com.dlsc.gemsfx;
    requires java.desktop;

    opens co.edu.uniquindio.poo.proyectoclinica to javafx.fxml;
    exports co.edu.uniquindio.poo.proyectoclinica;
    exports co.edu.uniquindio.poo.proyectoclinica.model;
    exports co.edu.uniquindio.poo.proyectoclinica.servicios;
    exports co.edu.uniquindio.poo.proyectoclinica.controllers;
    opens co.edu.uniquindio.poo.proyectoclinica.controllers to javafx.fxml;
}