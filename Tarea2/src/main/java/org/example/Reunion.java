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
    protected TipoReunion tipoReunion;
    protected Date fecha;
    protected Instant horaPrevista;
    protected Duration duracionPrevista;
    protected Instant horaInicio;
    protected Instant horaFinal;
    protected ArrayList<Asistencia> asistencias;
    protected ArrayList<Invitacion> invitaciones;
    protected ArrayList<Retraso> retrasos;
    protected ArrayList<Nota> notas;
    public Reunion(Date f,Instant j,Duration k,TipoReunion t){
        asistencias = new ArrayList<>();
        invitaciones = new ArrayList<>();
        retrasos = new ArrayList<>();
        notas = new ArrayList<>();
        this.tipoReunion = t;
        this.fecha= f;
        this.horaPrevista=j;
        this.duracionPrevista=k;
        this.horaInicio=null;
        this.horaFinal=null;
    }
    public void agregarAsistencias(Invitable i){
        if(horaInicio!=null && estaInvitado(i)){
            Retraso a = new Retraso(Instant.now(),i);
            retrasos.add(a);
            asistencias.add(a);
        }
        else if(estaInvitado(i)){
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

    public ArrayList<Invitacion> getInvitaciones() {
        return invitaciones;
    }

    public ArrayList<Nota> getNotas() {
        return notas;
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
        if(this.horaInicio != null){
            this.horaFinal = Instant.now();
        }
        else{

        }

    }

    public TipoReunion getTipoReunion() {
        return tipoReunion;
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

    public boolean estaInvitado(Invitable i){
        for(Invitacion invitacion : invitaciones){
            if(invitacion.getInvitado() == i){
                return true;
            }
        }
        return false;
    }

    public Instant getHoraInicio() {
        return horaInicio;
    }

    public Instant getHoraFinal() {
        return horaFinal;
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

        long horas = duracionPrevista.toHours();
        long minutos = duracionPrevista.minusHours(horas).toMinutes();
        String formatted = String.format("%02d:%02d:%02d", horas, minutos,0);
        return
                "\nfecha = " + fechaTexto +
                "\nhoraPrevista = " + fechaPrevista +
                "\nduracionPrevista = " + formatted +
                "\nhoraInicio = " + fechaInicio +
                "\nhoraFinal = " + fechaFinal +
                "\nasistencias = " + asistencias +
                "\ninvitaciones = " + invitaciones +
                "\nretrasos = " + retrasos +
                "\nausencias = " + obtenerAusencias() +
                "\nnotas = " + notas;
    }
}
