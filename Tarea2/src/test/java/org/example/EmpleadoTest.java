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
    private String idf;
    private String apellidosf;
    private String nombref;
    private String correof;
    private Reunion a;
    @BeforeEach
    void setUp() {
        empleado = new Empleado("12", "Traductor", "De Ingenieria", "TraductorDeIng@yahoo.com");
        idf = "12";
        apellidosf = "De Ingenieria";
        nombref = "Traductor";
        correof = "TraductorDeIng@yahoo.com";
        Date h = new Date();
        TipoReunion MARKETING = TipoReunion.MARKETING;
        a = new ReunionPresencial(h, Instant.now(), Duration.ofHours(2), "402",MARKETING );
    }

    @AfterEach
    void tearDown() {}

    @Test
    void getId() {
        assertEquals(idf, empleado.getId());
    }

    @Test
    void getApellidos() {
        assertEquals(apellidosf, empleado.getApellidos());
    }

    @Test
    void getNombre() {
        assertEquals(nombref, empleado.getNombre());
    }

    @Test
    void getCorreo() {
        assertEquals(correof,empleado.getCorreo());
    }

    @Test
    void invitar() {
        empleado.invitar(a);
        assertTrue(a.estaInvitado(empleado));
    }

    @Test
    void testToString() {
        assertEquals("Empleado{" + "id='" + idf + '\'' + ", Apellidos='" + apellidosf + '\'' + ", Nombre='" + nombref + '\'' + ", Correo='" + correof + '\'' + '}', empleado.toString());
    }
}