package org.example;

public class Departamento {
    private String nombre;

    public Departamento(String nombre){
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String newNombre){
        this.nombre = newNombre;
    }
}
