package org.example;

public class Externo implements Invitable{
    private String id;
    private String nombre;
    private String apellidos;
    private String correo;

    /** Constructor de Externo(para invitar a una persona externa a la empresa)
     *
     * @param n String con el nombre de la persona
     * @param a String con los apellidos de la persona
     * @param c String con el correo de la persona
     */
    public Externo(String n, String a, String c){
        this.nombre = n;
        this.apellidos = a;
        this.correo = c;
        this.id = "No es empleado";
    }

    /** Metodo para invitar a la persona
     *
     * @param a una reunion a la cual ser invitado
     */
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

    /** Metodo toString
     *
     * @return string con los datos de la persona
     */
    @Override
    public String toString() {
        return "Externo{" +
                "id='" + id + '\'' +
                ", apellidos='" + apellidos + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                '}';
    }
}
