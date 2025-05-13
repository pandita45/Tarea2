package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class EmpleadoTest {
    private Empleado empleado;
    private Reunion a;
    @BeforeEach
    void setUp() {
        empleado = new Empleado("12", "Traductor", "De Ingenieria", "TraductorDeIng@yahoo.com");
        Date h = new Date();
        TipoReunion MARKETING = TipoReunion.MARKETING;
        a = new ReunionPresencial(h, Instant.now(), Duration.ofHours(2), "402",MARKETING );
    }

    @AfterEach
    void tearDown() {}

    @Test
    void invitar() {
        empleado.invitar(a);
        assertTrue(a.estaInvitado(empleado));
    }

    @Test
    void testToString() {
        assertEquals("Empleado{" + "id='" + empleado.getId() + '\'' + ", Apellidos='" + empleado.getApellidos() + '\'' + ", Nombre='" + empleado.getNombre() + '\'' + ", Correo='" + empleado.getCorreo() + '\'' + '}', empleado.toString());
    }
}