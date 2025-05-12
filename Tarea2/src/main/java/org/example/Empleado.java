package org.example;

public class Empleado implements Invitable {
    private String id;
    private String Apellidos;
    private String Nombre;
    private String Correo;

    public Empleado(String id, String nombre, String apellidos, String correo){
        this.id = id;
        this.Apellidos = apellidos;
        this.Nombre = nombre;
        this.Correo = correo;
    }
    public String getId(){
        return id;
    }
    public String getApellidos(){
        return Apellidos;
    }
    public String getNombre(){
        return Nombre;
    }
    public String getCorreo(){
        return Correo;
    }

    @Override
    public void invitar(Reunion a) {
        a.invitarAReunion(this);
    }

    @Override
    public String toString() {
        return "Empleado{" + "id='" + id + '\'' + ", Apellidos='" + Apellidos + '\'' + ", Nombre='" + Nombre + '\'' + ", Correo='" + Correo + '\'' + '}';
    }
}