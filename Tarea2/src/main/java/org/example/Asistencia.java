package org.example;

public class Asistencia {
    protected Invitable invitado;

    public Asistencia(Invitable invitado) {
        this.invitado = invitado;
    }

    public Invitable getInvitado(){
        return this.invitado;
    }

    @Override
    public String toString() {
        return invitado.toString();
    }
}