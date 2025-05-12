package org.example;

public class Nota {
    private String contenido;
    public Nota(String n){
        this.contenido=n;
    }

    @Override
    public String toString() {
        return contenido;
    }
}
