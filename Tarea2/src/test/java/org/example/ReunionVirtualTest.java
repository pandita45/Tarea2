package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReunionVirtualTest {
    protected Date fechaf;
    protected Instant horaPrevistaf;
    protected Duration duracionPrevistaf;
    private ReunionVirtual a;
    @BeforeEach
    void setUp() {
        fechaf = Date.from(Instant.now());
        horaPrevistaf = Instant.now();
        duracionPrevistaf = Duration.ofHours(2);
        a = new ReunionVirtual(fechaf, horaPrevistaf, duracionPrevistaf, "32", TipoReunion.MARKETING);

    }
    @Test
    void testToString() {
        a.iniciar();
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        String fechaTexto = formato.format(a.getFecha());

        ZonedDateTime fechaInicio1 = a.getHoraInicio().atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String fechaInicio = formatter.format(fechaInicio1);

        ZonedDateTime fechaInicio2 = a.getHoraPrevista().atZone(ZoneId.systemDefault());
        String fechaPrevista = formatter.format(fechaInicio2);
        a.finalizar();
        ZonedDateTime fechaInicio3 = a.getHoraFinal().atZone(ZoneId.systemDefault());
        String fechaFinal = formatter.format(fechaInicio3);
        long horas = a.getDuracionPrevista().toHours();
        long minutos = a.getDuracionPrevista().minusHours(horas).toMinutes();
        String formatted = String.format("%02d:%02d:%02d", horas, minutos,0);

        assertEquals(a.toString(),"ReunionVirtual" +
                "\nlink = " + a.getEnlace() +"\nfecha = " + fechaTexto +
                "\nhoraPrevista = " + fechaPrevista +
                "\nduracionPrevista = " + formatted +
                "\nhoraInicio = " + fechaInicio +
                "\nhoraFinal = " + fechaFinal +
                "\nasistencias = " + a.obtenerAsistencia() +
                "\ninvitaciones = " + a.getInvitaciones() +
                "\nretrasos = " + a.obtenerRetrasos() +
                "\nausencias = " + a.obtenerAusencias()+
                "\nnotas = " + a.getNotas());
    }
}
