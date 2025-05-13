package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ReunionTest {
    protected TipoReunion tipoReunion;
    protected Date fechaf;
    protected Instant horaPrevistaf;
    protected Duration duracionPrevistaf;
    protected Instant horaIniciof;
    protected Instant horaFinalf;
    protected ArrayList<Asistencia> asistenciasf;
    protected ArrayList<Invitacion> invitacionesf;
    protected ArrayList<Retraso> retrasosf;
    protected ArrayList<Nota> notasf;
    private ReunionPresencial a;
    private Empleado empleado1;
    private Empleado empleado2;
    @BeforeEach
    void setUp() {
        fechaf = Date.from(Instant.now());
        horaPrevistaf = Instant.now();
        asistenciasf = new ArrayList<>();
        duracionPrevistaf = Duration.ofHours(2);
        a = new ReunionPresencial(fechaf, horaPrevistaf, duracionPrevistaf, "32", TipoReunion.MARKETING);
        empleado1 = new Empleado("1", "Traductor", "De Ingenieria", "TraductorDeIng@yahoo.com");
        empleado2 = new Empleado("2", "Geoffrey", "Fuentes Castillo","GeoffreyFCAS@hotmail.com" );
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void agregarAsistencias() {
        //cuando llega puntual
        empleado1.invitar(a);
        a.agregarAsistencias(empleado1);
        Asistencia asis = new Asistencia(empleado1);
        assertEquals(asis.getInvitado(), a.asistencias.get(0).getInvitado());


        //cuando llega atrasado
        empleado2.invitar(a);
        a.iniciar();
        a.agregarAsistencias(empleado2);
        Asistencia asis2 = new Asistencia(empleado2);
        assertEquals(asis2.getInvitado(), a.asistencias.get(1).getInvitado());
        a.finalizar();
    }

    @Test
    void invitarAReunion() {
        Invitacion inv = new Invitacion(empleado2);
        a.invitarAReunion(empleado2);
        assertEquals(inv.getInvitado(), a.invitaciones.get(0).getInvitado());
    }

    @Test
    void obtenerAsistencia() {
        empleado1.invitar(a);
        a.agregarAsistencias(empleado1);
        assertEquals(empleado1, a.asistencias.get(0).getInvitado());
    }

    @Test
    void obtenerAusencias() {
        empleado1.invitar(a);
        a.iniciar();
        a.finalizar();
        assertEquals(empleado1, a.obtenerAusencias().get(0));
    }

    @Test
    void obtenerRetrasos() {
        empleado1.invitar(a);
        a.iniciar();
        a.agregarAsistencias(empleado1);
        assertEquals(empleado1, a.obtenerRetrasos().get(0).getInvitado());
        a.finalizar();
    }

    @Test
    void obtenerTotalAsistencias() {
        empleado1.invitar(a);
        empleado2.invitar(a);
        a.agregarAsistencias(empleado1);
        assertEquals(1,a.obtenerTotalAsistencias());

    }

    @Test
    void obtenerPorcentajeAsistencia() {
        empleado1.invitar(a);
        empleado2.invitar(a);
        a.agregarAsistencias(empleado1);
        assertEquals(50,a.obtenerPorcentajeAsistencia());
    }

    @Test
    void calcularTiempoReal() {
        a.iniciar();
        horaIniciof = a.getHoraInicio();
        a.finalizar();
        horaFinalf = a.getHoraFinal();
        duracionPrevistaf = Duration.between(horaIniciof,horaFinalf);
        assertEquals(duracionPrevistaf,a.calcularTiempoReal());
    }

    @Test
    void agregarNotas() {
        Nota nota1 = new Nota("Hola Soy Una Nota");
        a.agregarNotas(nota1.toString());
        assertEquals(nota1.toString(),a.notas.get(0).toString());

    }

    @Test
    void iniciar() {
        a.iniciar();
        assertNotNull(a.horaInicio);
    }

    @Test
    void finalizar() {
        a.iniciar();
        a.finalizar();
        assertNotNull(a.horaFinal);
    }
    //omitimos los gets


    @Test
    void estaInvitado() {
        empleado1.invitar(a);
        assertTrue(a.estaInvitado(empleado1));
    }

    @Test
    void testToString() {
        notasf = new ArrayList<>();
        a.iniciar();
        a.finalizar();
        a.invitarAReunion(empleado1);
        a.invitarAReunion(empleado2);
        a.agregarAsistencias(empleado1);
        Nota nota1 = new Nota("Hola yo acepto el paro indefinido gracias");
        notasf.add(nota1);
        a.agregarNotas(nota1.toString());

        assertTrue(a.toString().contains("ReunionPresencial"));
        assertTrue(a.toString().contains("fecha = " + fechaf));
        assertTrue(a.toString().contains("notas = " + notasf));
    }
}