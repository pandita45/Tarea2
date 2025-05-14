package org.example;

public class Nota {
    private String contenido;

    /** Constructor de Nota
     *
     * @param n recibe el String de la nota
     */
    public Nota(String n){
        this.contenido=n;
    }

    /** toString
     *
     * @return String con el contenido de la nota
     */
    @Override
    public String toString() {
        return contenido;
    }
}
