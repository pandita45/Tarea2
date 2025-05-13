package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class RetrasoTest {
    private Instant horaf;
    private Empleado invitadof;
    private Retraso retrasadof;
    @BeforeEach
    void setUp() {
        horaf = Instant.now();
        invitadof = new Empleado("11", "Bryan", "Aguirre Castillo", "BryanAguirreCast2004@hotmail.com");
        retrasadof = new Retraso(horaf,invitadof);
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    void testToString() {
        ZonedDateTime fechaInicio = horaf.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaf = formatter.format(fechaInicio);
        assertEquals("hora = " + horaf +" "+ invitadof, retrasadof.toString());
    }
}