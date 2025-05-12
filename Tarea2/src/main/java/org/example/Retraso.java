package org.example;
import java.time.Instant;
public class Retraso extends Asistencia{
    private Instant hora;
    public Retraso(Instant h, Invitable i){
        super(i);
        this.hora=h;
    }
    public Instant getHoraAtraso(){
        return hora;
    }
}
