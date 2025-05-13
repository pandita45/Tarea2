package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class ExternoTest {
    private Externo externo;
    private Reunion r;

    @BeforeEach
    void setUp() {
        externo = new Externo("Yuzito", "Gonzalez", "yuzito111@yahoo.com");
        Date h = new Date();
        TipoReunion MARKETING = TipoReunion.MARKETING;
        r = new ReunionPresencial(h, Instant.now(), Duration.ofHours(2), "402",MARKETING );
    }

    @AfterEach
    void tearDown() {}

    @Test
    void invitar() {
        externo.invitar(r);
        assertTrue(r.estaInvitado(externo));
    }

    @Test
    void testToString() {
        assertEquals("Externo{" +
                "id='" + externo.getId() + '\'' +
                ", apellidos='" + externo.getApellidos() + '\'' +
                ", nombre='" + externo.getNombre() + '\'' +
                ", correo='" + externo.getCorreo() + '\'' +
                '}', externo.toString());
    }
}