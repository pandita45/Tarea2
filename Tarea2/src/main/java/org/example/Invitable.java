package org.example;

/**
 * Esta interfaz sirve para que todas las clases que implementen esto puedan ser invitados a una reunion
 */
public interface Invitable {
    /**
     *
     * @param a recibe la reunion a la cual invitar
     */
    public void invitar(Reunion a);
}