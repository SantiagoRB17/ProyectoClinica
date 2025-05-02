package co.edu.uniquindio.poo.proyectoclinica.model;

import java.time.LocalDateTime;

public class FactorySuscripcion {

    public static Suscripcion crearSuscripcion(TipoSuscripcion suscripcion) {
        Suscripcion suscripcionNueva= null;
        switch (suscripcion) {
            case Premium:
                suscripcionNueva=new SuscripcionPremium();
                break;
            case Basica:
                suscripcionNueva= new SuscripcionBasica();
                break;
            case SinSuscripcion:
                suscripcionNueva= new SinSuscripcion();
                break;
        }
        return suscripcionNueva;
    }

}
