package co.edu.uniquindio.poo.proyectoclinica;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ClinicaApp extends Application{

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(ClinicaApp.class.getResource("/panel.fxml"));

        Parent parent= loader.load();
        Scene scene = new Scene(parent);
        stage.setScene(scene);
        stage.setTitle("Clinica");
        stage.setMaximized(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch(ClinicaApp.class,args);
    }
}
