package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class Main {
    public static void main(String[] args) {        Date f = Date.from(Instant.now());
        ReunionVirtual reunion = new ReunionVirtual(f, Instant.now(), Duration.ofHours(2),"hola.com", TipoReunion.MARKETING);
        Empleado empleado1 = new Empleado("12", "Traductor", "De Ingenieria", "TraductorDeIng@yahoo.com");
        empleado1.invitar(reunion);
        reunion.agregarAsistencias(empleado1);
        reunion.iniciar();

        reunion.finalizar();
        System.out.println(reunion.toString());
        reunion.escribirArchivo(reunion.toString());
        }
    }