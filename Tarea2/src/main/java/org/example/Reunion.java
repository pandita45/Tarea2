package org.example;
import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.List;

abstract public class Reunion {
    private Date fecha;
    private Instant horaPrevista;
    private Duration duracionPrevista;
    private Instant horaInicio;
    private Instant horaFinal;

    public List obtenerAsistencia(){
        return List.of();
    }
    public List obtenerAusencias(){
        return List.of();
    }
    public List obtenerRetrasos(){
        return List.of();
    }
    public int obtenerTotalAsistencias(){
        return 1;
    }
    public float obtenerPorcentajeAsistencia(){
        return 1;
    }
    public float calcularTiempoReal(){
        return 1;
    }
    public void iniciar(){

    }
    public void finalizar(){

    }
    
}
