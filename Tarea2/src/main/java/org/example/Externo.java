package org.example;

public class Externo implements Invitable{
    private String nombre;
    private String apellidos;
    private String correo;

    public Externo(String n, String a, String c){
        this.nombre = n;
        this.apellidos = a;
        this.correo = c;
    }
    @Override
    public void invitar(Reunion a) {
        a.invitarAReunion(this);
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellidos() {
        return apellidos;
    }
    public String getCorreo() {
        return correo;
    }
    public String getId(){
        return "No es empleado";
    }

    @Override
    public String toString() {
        return "Externo{" +
                "nombre='" + nombre + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
