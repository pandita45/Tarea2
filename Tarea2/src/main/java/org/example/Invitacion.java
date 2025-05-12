package org.example;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Invitacion {
    private Instant hora;
    private Invitable invitado;
    public Invitacion(Invitable b){
        this.hora= Instant.now();
        this.invitado = b;
    }
    public Invitable getInvitado() {
        return this.invitado;
    }

    @Override
    public String toString() {
        ZonedDateTime fechaInicio = hora.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String hora = formatter.format(fechaInicio);
        return "hora = " + hora + ", invitado = " + invitado;
    }
}