package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

abstract public class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFinal;
    private ArrayList<Asistencia> asistencias;
    private ArrayList<Invitacion> invitaciones;
    public Reunion(){
        asistencias = new ArrayList<>();
        invitaciones = new ArrayList<>();
    }

    public void agregarAsistencias(Asistencia a){
        asistencias.add(a);
    }

    public void invitarAReunion(Invitable a){
        Invitacion inv = new Invitacion(Instant.now(), a);
        invitaciones.add(inv);
    }

    public ArrayList<Asistencia> obtenerAsistencia(){
        return asistencias;
    }

    public ArrayList<Invitable> obtenerAusencias(){
        ArrayList<Invitable> ausencias = new ArrayList<>();
        for(Invitacion invitacion : invitaciones){
            ausencias.add(invitacion.getInvitado());
        }
        for(Asistencia asistencia: asistencias){
            ausencias.remove(asistencia.getInvitado());
        }
        return ausencias;
    }
    public List obtenerRetrasos(){
        return List.of();
    }
    public int obtenerTotalAsistencias(){
        return asistencias.size();
    }
    public float obtenerPorcentajeAsistencia(){
        float porcentaje = (float) asistencias.size()/invitaciones.size();
        return porcentaje*100;
    }

    public float calcularTiempoReal(){
        return 1;
    }
    public void iniciar(){

    }
    public void finalizar(){

    }
}
