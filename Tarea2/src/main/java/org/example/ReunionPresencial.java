package org.example;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;

public class ReunionPresencial extends Reunion {
    private String sala;

    public ReunionPresencial(Date f, Instant j, Duration k, String sala) {
        super(f, j, k);
        this.sala = sala;
    }

    public String getSala() {
        return sala;
    }
    public void setSala(String a){
        this.sala=a;
    }
}
