package org.example;

public class Invitacion {
    private int hora;
    private Invitable invitado;
    public Invitacion(int h, Invitable b){
        this.hora=h;
        this.invitado = b;
    }
    public Invitable getInvitado() {
        return this.invitado;
    }
}
