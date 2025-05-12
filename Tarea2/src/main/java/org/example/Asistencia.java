package org.example;

public class Asistencia {
    private Invitable invitado;

    public Asistencia(Invitable invitado) {
        this.invitado = invitado;
    }

    public Invitable getInvitado(){
        return this.invitado;
    }
}