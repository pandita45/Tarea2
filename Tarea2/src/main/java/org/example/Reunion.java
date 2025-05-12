package org.example;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

abstract public class Reunion {
    protected Date fecha;
    protected Instant horaPrevista;
    protected Duration duracionPrevista;
    protected Instant horaInicio;
    protected Instant horaFinal;
    protected ArrayList<Asistencia> asistencias;
    protected ArrayList<Invitacion> invitaciones;
    protected ArrayList<Retraso> retrasos;
    protected ArrayList<Nota> notas;
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
        Invitacion inv = new Invitacion(a);
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
        if(horaInicio==null || horaFinal==null){
            return null;
        }
        return Duration.between(horaFinal,horaInicio);
    }
    public void agregarNotas(String k){
        notas.add(new Nota(k));
    }

    public void iniciar(){
        this.horaInicio = Instant.now();
    }
    public void finalizar(){
        this.horaFinal = Instant.now();
    }

    public Date getFecha() {
        return fecha;
    }

    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    @Override
    public String toString() {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTexto = formato.format(fecha);

        ZonedDateTime fechaInicio1 = horaInicio.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fechaInicio = formatter1.format(fechaInicio1);

        ZonedDateTime fechaInicio2 = horaPrevista.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter2 = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fechaPrevista = formatter2.format(fechaInicio2);

        ZonedDateTime fechaInicio3 = horaFinal.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fechaFinal = formatter.format(fechaInicio3);
        return "ReunionPresencial{" +
                "\nfecha=" + fechaTexto +
                "\nhoraPrevista=" + fechaPrevista +
                "\nduracionPrevista=" + duracionPrevista.toString() +
                "\nhoraInicio=" + fechaInicio +
                "\nhoraFinal=" + fechaFinal +
                "\nasistencias=" + asistencias +
                "\ninvitaciones=" + invitaciones +
                "\nretrasos=" + retrasos +
                "\nnotas=" + notas +
                '}';
    }
}
