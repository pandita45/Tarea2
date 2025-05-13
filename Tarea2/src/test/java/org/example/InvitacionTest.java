package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class InvitacionTest {
    private Invitable invitadof;
    private Invitacion invitacion;
    private Instant hora;
    @BeforeEach
    void setUp() {
        invitadof = new Empleado("12", "Traductor", "De Ingenieria", "TraductorDeIng@yahoo.com");
        invitacion = new Invitacion(invitadof);
        hora = Instant.now();
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void getInvitado() {
        assertEquals(invitadof,invitacion.getInvitado());
    }

    @Test
    void testToString() {
        ZonedDateTime fechaInicio = hora.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String hora = formatter.format(fechaInicio);
        assertEquals("hora = " + hora + ", invitado = " + invitadof, invitacion.toString());
    }
}