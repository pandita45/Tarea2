package org.example;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Invitacion {
    private Instant hora;
    private Invitable invitado;

    /**Constructor de Invitacion
     *
     * @param b recibe el Invitable para crear la invitacion
     */
    public Invitacion(Invitable b){
        this.hora= Instant.now();
        this.invitado = b;
    }

    /** Getter del Invitado
     *
     * @return Invitable para obtener al invitado
     */
    public Invitable getInvitado() {
        return this.invitado;
    }

    /** Metodo toString
     *
     * @return string con los datos de la invitacion(la hora de llegada de la invitacion y a quien invito)
     */
    @Override
    public String toString() {
        ZonedDateTime fechaInicio = hora.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String hora = formatter.format(fechaInicio);
        return "hora = " + hora + ", invitado = " + invitado;
    }
}