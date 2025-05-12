package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.Dictionary;
import java.util.List;

abstract public class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFinal;
    private ArrayList<Asistencia> asistencias;
    private ArrayList<Invitacion> invitaciones;
    private ArrayList<Retraso> retrasos;
    public Reunion(){
        asistencias = new ArrayList<>();
        invitaciones = new ArrayList<>();
        retrasos = new ArrayList<>();
    }

    public void agregarAsistencias(Invitable i){
        if(Instant.now().isAfter(horaInicio)){
            Retraso a = new Retraso(Instant.now(),i);
            retrasos.add(a);
        }
        else {
            Asistencia a = new Asistencia(i);
            asistencias.add(a);
        }
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

    public Duration calcularTiempoReal(){
        return Duration.between(horaFinal,horaInicio);
    }
    public void iniciar(int hora, int minuto){
        this.horaInicio = Instant.now();
    }
    public void finalizar(int horas, int minutos){
        this.horaFinal = horaInicio.plus(Duration.ofHours(horas)).plus(Duration.ofMinutes(minutos));
    }
}
