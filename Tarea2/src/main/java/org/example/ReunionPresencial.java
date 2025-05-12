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

    public ReunionPresencial(Date f, Instant j, Duration k, String sala) {
        super(f, j, k);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }
    public void setSala(String a){
        this.sala=a;
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
                "sala=" + sala +
                "\nfecha=" + fechaTexto +
                "\nhoraPrevista=" + fechaPrevista +
                "\nduracionPrevista=" + duracionPrevista.toString() +
                "\nhoraInicio=" + fechaInicio +
                "\nhoraFinal=" + fechaFinal +
                "\nasistencias=" + asistencias +
                "\ninvitaciones=" + invitaciones +
                "\nretrasos=" + retrasos +
                "\nnotas=" + notas;
    }
}
