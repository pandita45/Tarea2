package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
interface Invitable {
    String toString();
}
class AsistenciaTest {

    private Asistencia asistencia;
    private Invitable invitadoFalso;

    @BeforeEach
    void setUp() {
        invitadoFalso = new Invitable() {
            @Override
            public String toString() {
                return "Invitado: William Wallace";
            }
        };
        asistencia = new Asistencia(invitadoFalso);
    }

    @AfterEach
    void tearDown() {
        asistencia = null;
        invitadoFalso = null;
    }

    @Test
    void getInvitado() {
        assertNotNull(asistencia.getInvitado());
        assertEquals(invitadoFalso, asistencia.getInvitado());
    }

    @Test
    void testToString() {
        assertEquals("Invitado: William Wallace", asistencia.toString());
    }
}
