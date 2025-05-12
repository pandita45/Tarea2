package org.example;

import java.time.Instant;

public class Invitacion {
    private Instant hora;
    private Invitable invitado;
    public Invitacion(Instant hora,Invitable b){
        this.hora= Instant.now();
        this.invitado = b;
    }
    public Invitable getInvitado() {
        return this.invitado;
    }
}