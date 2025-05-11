package org.example;

public class ReunionPresencial extends Reunion {
    private String sala;
    public ReunionPresencial(String a){
        this.sala=a;
    }
    public String getSala() {
        return sala;
    }
    public void setSala(String a){
        this.sala=a;
    }
}
