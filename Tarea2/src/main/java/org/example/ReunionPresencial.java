package org.example;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;

    /**
     * Constructor de ReunionPresencial que como extiende a Reunion, usamos super() y como variable extra tiene la sala
     *
     * @param f Fecha en la que será la Reunion
     * @param j A que hora sera la reunion
     * @param k Que duracion se tiene prevista para la reunion
     * @param sala La sala de la reunion
     * @param t Qué tipo de reunion es, se usa el enum
     */
    public ReunionPresencial(Date f, Instant j, Duration k, String sala, TipoReunion t) {
        super(f, j, k, t);
        this.sala = sala;
    }

    /** Metodo getter de la sala
     *
     * @return devuelve String con la sala de la reunion
     */
    public String getSala() {
        return sala;
    }

    /** Metodo setter de la sala
     *
     * @param a Nuevo valor que se le asignara al String de sala
     */
    public void setSala(String a){
        this.sala=a;
    }

    /** Metodo toString de la Reunion para que devuelva toda la información de esta.
     *
     * @return Devuelve un String con toda la información de la Reunion, es el mismo de la clase abstracta Reunion
     *         pero con una sala.
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
        return "ReunionPresencial" +
                "\nsala = " + sala +
                super.toString();

    }
}
