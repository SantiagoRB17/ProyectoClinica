package co.edu.uniquindio.poo.proyectoclinica.utils;

import org.simplejavamail.api.email.Email;
import org.simplejavamail.api.mailer.Mailer;
import org.simplejavamail.api.mailer.config.TransportStrategy;
import org.simplejavamail.email.EmailBuilder;
import org.simplejavamail.mailer.MailerBuilder;

import java.time.LocalDateTime;


public class EnvioEmail {


    public static void enviarNotificacion(String destinatario, String asunto, String mensaje) {


        Email email = EmailBuilder.startingBlank()
                .from("fuentesthomasito777@gmail.com")
                .to(destinatario)
                .withSubject(asunto)
                .withPlainText(mensaje)
                .buildEmail();


        try (Mailer mailer = MailerBuilder
                .withSMTPServer("smtp.gmail.com", 587, "fuentesthomasito777@gmail.com", "igfs alxn gezv qogs")
                .withTransportStrategy(TransportStrategy.SMTP_TLS)
                .withDebugLogging(true)
                .buildMailer()) {


            mailer.sendMail(email);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static String construirMensajeCita (String nombrePaciente, String nombreServicio, LocalDateTime fecha){
        return "Hola " + nombrePaciente + ",\n\n" +
                "Su cita para el servicio \"" + nombreServicio + "\" ha sido registrada exitosamente para el día " +
                fecha.toLocalDate() + " a las " + fecha.toLocalTime() + ".\n\n" +
                "Gracias por confiar en nosotros.\n\n" +
                "Atentamente,\nClínica  ";
    }
}