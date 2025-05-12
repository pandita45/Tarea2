package org.example;


import java.util.ArrayList;

public class Departamento implements Invitable{
    private String nombre;
    private ArrayList<Empleado> empleados;
    public Departamento(String nombre){
        this.nombre = nombre;
        this.empleados= new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String newNombre){
        this.nombre = newNombre;
    }
    public void addEmpleado(Empleado a){
        empleados.add(a);
    }
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    @Override
    public void invitar(Reunion a) {
        for(Empleado empleados : empleados){
            a.invitarAReunion(empleados);
        }
    }

    @Override
    public String toString() {
        return "Departamento "+nombre + ", empleados=" + empleados;
    }
}