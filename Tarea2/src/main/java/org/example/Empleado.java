package org.example;

public class Empleado implements Invitable {
    private String id;
    private String Apellidos;
    private String Nombre;
    private String Correo;

    /** Constructor de la clase empleado
     * 
     * @param id inicializa el id del empleado
     * @param nombre inicializa el nombre del empleado
     * @param apellidos inicializa los apellidos del empleado
     * @param correo inicializa el correo del empleado
     */
    public Empleado(String id, String nombre, String apellidos, String correo){
        this.id = id;
        this.Apellidos = apellidos;
        this.Nombre = nombre;
        this.Correo = correo;
    }

    /** Metodo getter de id
     * 
     * @return String con el id del empleado
     */
    public String getId(){
        return id;
    }

    /** Metodo getter de los apellidos
     * 
     * @return String con los apellidos del empleado
     */
    public String getApellidos(){
        return Apellidos;
    }

    /** Metodo getter del nombre
     * 
     * @return String con el nombre del empleado
     */
    public String getNombre(){
        return Nombre;
    }

    /** Metodo getter de correo
     * 
     * @return el String con el correo del empleado
     */
    public String getCorreo(){
        return Correo;
    }

    /** Metodo para invitar a una reunion
     *
     * @param a es la reunion a la que se invitara al empleado
     */
    @Override
    public void invitar(Reunion a) {
        a.invitarAReunion(this);
    }

    /** Metodo ToString
     *
     * @return String con todos los datos del empleado
     */
    @Override
    public String toString() {
        return "Empleado{" + "id='" + id + '\'' + ", Apellidos='" + Apellidos + '\'' + ", Nombre='" + Nombre + '\'' + ", Correo='" + Correo + '\'' + '}';
    }
}