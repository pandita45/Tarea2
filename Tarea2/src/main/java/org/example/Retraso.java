package org.example;
import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class Retraso extends Asistencia{
    private Instant hora;

    /** Constructor de Retraso
     *
     * @param h recibe la hora a la que llego(Instant)
     * @param i recibe el invitable que llego retrasado
     */
    public Retraso(Instant h, Invitable i){
        super(i);
        this.hora=h;
    }

    /** Getter de hora de atraso
     *
     * @return Instant con la hora a la que llego
     */
    public Instant getHoraAtraso(){
        return hora;
    }

    /** Metodo toString
     *
     * @return String con los datos del retraso (la hora a la que llego y quien fue)
     */
    @Override
    public String toString() {
        ZonedDateTime fechaInicio = hora.atZone(ZoneId.systemDefault());
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String hora = formatter.format(fechaInicio);
        return "hora = " + hora +" "+ invitado;
    }
}
