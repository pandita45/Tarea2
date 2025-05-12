package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

abstract public class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFinal;
    private ArrayList<Asistencia> asistencias;
    private ArrayList<Invitacion> invitaciones;
    private ArrayList<Retraso> retrasos;
    private ArrayList<Nota> notas;
    public Reunion(Date f,Instant j,Duration k){
        asistencias = new ArrayList<>();
        invitaciones = new ArrayList<>();
        retrasos = new ArrayList<>();
        notas = new ArrayList<>();
        this.fecha= f;
        this.horaPrevista=j;
        this.duracionPrevista=k;
        this.horaInicio=null;
        this.horaFinal=null;
    }
    public void agregarAsistencias(Invitable i){
        if(horaInicio!=null){
            Retraso a = new Retraso(Instant.now(),i);
            retrasos.add(a);
            asistencias.add(a);
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
    public ArrayList<Retraso> obtenerRetrasos(){
        return retrasos;
    }
    public int obtenerTotalAsistencias(){
        return asistencias.size();
    }
    public float obtenerPorcentajeAsistencia(){
        float porcentaje = (float) asistencias.size()/invitaciones.size();
        return porcentaje*100;
    }

    public Duration calcularTiempoReal(){
        if(horaFinal==null || horaFinal==null){
            return null;
        }
        return Duration.between(horaFinal,horaInicio);
    }
    public void añadirNotas(String k){
        notas.add(new Nota(k));
    }

    public void iniciar(){
        this.horaInicio = Instant.now();
    }
    public void finalizar(){
        this.horaFinal = Instant.now();
    }
}
