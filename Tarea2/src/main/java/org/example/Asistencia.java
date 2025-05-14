package org.example;

public class Asistencia {
    protected Invitable invitado;

    /** Constructor de Asistencia
     *
     * @param invitado Es un invitable
     */
    public Asistencia(Invitable invitado) {
        this.invitado = invitado;
    }

    /** Getter del invitado
     *
     * @return un invitable
     */
    public Invitable getInvitado(){
        return this.invitado;
    }

    /** Metodo ToString
     *
     * @return String con los datos del invitado
     */
    @Override
    public String toString() {
        return invitado.toString();
    }
}