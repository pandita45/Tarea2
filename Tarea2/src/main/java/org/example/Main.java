package org.example;

public class Main {
    public static void main(String[] args) {
        Reunion r = new ReunionPresencial("204");
        Departamento d = new Departamento("Casa Javier");
        Empleado e = new Empleado("420", "Javier", "Castle", "Jacastle@gmail.com");
        d.addEmpleado(e);
        d.invitar(r);
        r.agregarAsistencias(e);
        System.out.println(r.obtenerAsistencia());
        r.iniciar(3,20);
        r.finalizar(3,30);
        System.out.println(r.calcularTiempoReal());
        }
    }