package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class DepartamentoTest {
    Departamento name;
    Date d = Date.from(Instant.now());
    Instant j = Instant.now();
    Duration k = Duration.ofHours(2);
    TipoReunion t = TipoReunion.MARKETING;
    Reunion r = new ReunionPresencial(d, j, k, "34", t);
    Empleado a = new Empleado("54", "Jose", "Fuentes", "JoseF@Yopmail.com");
    Empleado b = new Empleado("53", "Joel", "Gonzales", "JoelM@Yopmail.com");
    int cantidad;

    @BeforeEach
    void setUp() {
        name = new Departamento("CDC");
        name.addEmpleado(a);
        name.addEmpleado(b);
        cantidad = name.empleados.size();
        name.invitar(r);
    }

    @AfterEach
    void tearDown() {
        name = null;
    }

    @Test
    void getNombre() {
        assertEquals("CDC", name.getNombre());
    }

    @Test
    void setNombre() {
        assertEquals("CDC", name.getNombre());
        name.setNombre("FFA");
        assertEquals("FFA", name.getNombre());
    }


    @Test
    void addEmpleado() {
        assertEquals(a, name.empleados.get(0));
        assertEquals(b, name.empleados.get(1));
    }


    @Test
    void obtenerCantidadEmpleados() {
        assertEquals(cantidad, name.empleados.size());
    }

    @Test
    void invitar() {
        for (Empleado empleado : name.empleados) {
            assertEquals(true, r.estaInvitado(empleado));
        }
    }

    @Test
    void testToString() {
        assertEquals("Departamento " + name.getNombre() + ", empleados=" + name.empleados, name.toString());
    }
}