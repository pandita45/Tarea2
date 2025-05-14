package org.example;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ReunionVirtual extends Reunion {
    private String enlace;

    /**
     * Constructor de ReunionVirtual que como extiende a Reunion, usamos super() y como variable extra tiene el enlace
     *
     * @param f Fecha en la que será la Reunion
     * @param j A que hora sera la reunion
     * @param k Que duracion se tiene prevista para la reunion
     * @param enlace El enlace de la reunion
     * @param t Qué tipo de reunion es, se usa el enum
     */
    public ReunionVirtual(Date f, Instant j, Duration k, String enlace, TipoReunion t) {
        super(f, j, k, t);
        this.enlace = enlace;
    }

    /** Metodo getter de enlace
     *
     * @return Devuelve el enlace de la reunion
     */
    public String getEnlace() {
        return enlace;
    }

    /** Metodo setter de enlace
     *
     * @param a Nuevo enlace de la reunion
     */
    public void setEnlace(String a){
        this.enlace=a;
    }

    /** Metodo toString de la Reunion para que devuelva toda la información de esta.
     *
     * @return Devuelve un String con toda la información de la Reunion, es el mismo de la clase abstracta Reunion
     *         pero con un link.
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
        return "ReunionVirtual" +
                "\nlink = " + enlace +
                super.toString();

    }
}
