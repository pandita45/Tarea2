package org.example;
import java.util.ArrayList;

public class Departamento implements Invitable{
    private String nombre;
    protected ArrayList<Empleado> empleados;

    /** Constructor de Departamento
     *
     * @param nombre es un String con el nombre del departamento
     */
    public Departamento(String nombre){
        this.nombre = nombre;
        this.empleados = new ArrayList<>();
    }

    /** Getter de nombre del departamento
     *
     * @return String con el nombre del departamento
     */
    public String getNombre() {
        return nombre;
    }

    /** Setter del nombre del departamento
     *
     * @param newNombre String con el nuevo nombre del departamento
     */
    public void setNombre(String newNombre){
        this.nombre = newNombre;
    }

    /** Metodo para agregar empleado al departamento
     *
     * @param a es un empleado
     */
    public void addEmpleado(Empleado a){
        empleados.add(a);
    }

    /** Metodo para obtener cantidad de empleados
     *
     * @return un int con la cantidad de empleados
     */
    public int obtenerCantidadEmpleados(){
        return empleados.size();
    }

    /** Metodo para invitar un departamento a una reunion
     *
     * @param a es una reunion
     */
    @Override
    public void invitar(Reunion a) {
        for(Empleado empleados : empleados){
            a.invitarAReunion(empleados);
        }
    }

    /**Metodo toString
     *
     * @return String con los datos del departamento
     */
    @Override
    public String toString() {
        return "Departamento " +nombre + ", empleados=" + empleados;
    }
}