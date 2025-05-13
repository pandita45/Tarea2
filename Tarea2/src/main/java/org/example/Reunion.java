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

    /** Constructor de la clase en donde crearemos y asignaremos todos los valores a nuestras variables
     *
     * @param f Fecha en la que será la Reunion
     * @param j A que hora sera la reunion
     * @param k Que duracion se tiene prevista para la reunion
     * @param t Qué tipo de reunion es, se usa el enum
     */
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

    /** Se agrega al array de asistencias y en caso de ser necesario tambien al de retrasos, en caso de no estar invitado
     * no se agrega a ninguno de estos.
     *
     * @param i Invitado que se asistira a la Reunion
     */
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

    /** Metodo para crear invitacion de un Invitable
     *
     * @param a Invitable al que se le creara la invitacion
     */
    public void invitarAReunion(Invitable a){
        Invitacion inv = new Invitacion(a);
        invitaciones.add(inv);
    }

    /** Metodo getter del array de Invitados que asistieron a la Reunion
     *
     * @return array de Invitados que asistieron
     */
    public ArrayList<Asistencia> obtenerAsistencia(){
        return asistencias;
    }

    /** Metodo getter del array de Invitaciones
     *
     * @return array con todas las Invitaciones
     */
    public ArrayList<Invitacion> getInvitaciones() {
        return invitaciones;
    }

    /** Metodo getter del array de Notas
     *
     * @return array con todas las Notas
     */
    public ArrayList<Nota> getNotas() {
        return notas;
    }

    /** Metodo que llena un array con todas las Invitaciones y luego saca a todos los que asistieron, dejando solo los
     * ausentes en el array
     *
     * @return devuelve el array con los que NO asistieron a la Reunion
     */
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

    /** Metodo getter de retrasos
     *
     * @return array con los retrasos
     */
    public ArrayList<Retraso> obtenerRetrasos(){
        return retrasos;
    }

    /**
     * @return devuelve el tamaño del array de asistencias (cantidad de personas que asistieron)
     */
    public int obtenerTotalAsistencias(){
        return asistencias.size();
    }

    /**
     * @return devuelve porcentaje de Invitados que asistieron a la Reunion
     */
    public float obtenerPorcentajeAsistencia(){
        float porcentaje = (float) asistencias.size()/invitaciones.size();
        return porcentaje*100;
    }

    /**
     * @return devuelve el tiempo que duro la reunion
     */
    public Duration calcularTiempoReal(){
        if(horaInicio==null || horaFinal==null){
            return null;
        }
        return Duration.between(horaFinal,horaInicio);
    }

    /**
     * @param k agrega este String al array de Notas
     */
    public void agregarNotas(String k){
        notas.add(new Nota(k));
    }

    /**
     * Inicia la Reunion dandole un valor a horaInicio
     */
    public void iniciar(){
        this.horaInicio = Instant.now();
    }

    /**
     * Se finaliza la reunion si y solo si es que la reunion inicio y se le asigna el valor a la horaFinal
     */
    public void finalizar(){
        if(this.horaInicio != null){
            this.horaFinal = Instant.now();
        }
    }

    /** Metodo getter del tipo de reunion
     *
     * @return devuelve el tipo de reunion
     */
    public TipoReunion getTipoReunion() {
        return tipoReunion;
    }

    /** Metodo getter de la fecha de la Reunion
     *
     * @return devuelve la fecha en la que será la reunion
     */
    public Date getFecha() {
        return fecha;
    }

    /** Metodo getter de la Hora Prevista a la que iniciara la Reunion
     *
     * @return devuelve la Hora Prevista para que inicie la Reunion
     */
    public Instant getHoraPrevista() {
        return horaPrevista;
    }

    /** Metodo getter de la duracion prevista de la reunion
     *
     * @return devuelve la duracion prevista que dure la reunion
     */
    public Duration getDuracionPrevista() {
        return duracionPrevista;
    }

    /** Metodo que chequea si es que e Invitable esta invitado o no a la Reunion
     *
     * @param i Invitable que se verificara si es que esta invitado
     * @return devuelve valor de verdad de si esta invitado o no a la reunion
     */
    public boolean estaInvitado(Invitable i){
        for(Invitacion invitacion : invitaciones){
            if(invitacion.getInvitado() == i){
                return true;
            }
        }
        return false;
    }

    /** Metodo getter de la hora de inicio de la Reunion
     *
     * @return devuelve la hora de inicio
     */
    public Instant getHoraInicio() {
        return horaInicio;
    }

    /** Metodo getter de la hora la cual se finalizo de la Reunion
     *
     * @return devuelve la hora la cual finalizo
     */
    public Instant getHoraFinal() {
        return horaFinal;
    }

    /**
     * @return Devuelve un String con toda la información sobre la Reunion, las clases que extienden a esta luego agregaran
     * más información a este String.
     */
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
