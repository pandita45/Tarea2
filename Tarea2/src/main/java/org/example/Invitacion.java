package org.example;

import java.time.Instant;

public class Invitacion {
    private Instant hora;
    private Invitable invitado;
    public Invitacion(Instant h, Invitable b){
        this.hora=h;
        this.invitado = b;
    }
    public Invitable getInvitado() {
        return this.invitado;
    }
}