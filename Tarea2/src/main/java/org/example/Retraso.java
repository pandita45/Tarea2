package org.example;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Retraso extends Asistencia{
    private Instant hora;
    public Retraso(Instant h, Invitable i){
        super(i);
        this.hora=h;
    }
    public Instant getHoraAtraso(){
        return hora;
    }

    @Override
    public String toString() {
        ZonedDateTime fechaInicio = hora.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String hora = formatter.format(fechaInicio);
        return "Retraso{" + "hora=" + hora +" "+ invitado + "}";
    }
}
