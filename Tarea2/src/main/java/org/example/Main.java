package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        Reunion r = new ReunionPresencial(Date.from(Instant.now()), Instant.now(), Duration.ofHours(2), "202");
        Empleado e = new Empleado("23", "Javier", "Castle", "xavier@yahoo.com");
        Empleado b = new Empleado("22", "Bryan", "Rook", "BAguirre@yahoo.com");
        r.agregarNotas("Hola soy el Bryan probando una nota, vamonos a paro");
        r.invitarAReunion(e);
        r.invitarAReunion(b);
        r.agregarAsistencias(e);
        r.iniciar();
        r.agregarAsistencias(b);
        r.finalizar();

        System.out.println(r.toString());
        }
    }