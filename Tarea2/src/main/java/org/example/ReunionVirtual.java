package org.example;

public class ReunionVirtual extends Reunion {
    private String enlace;
    public ReunionVirtual(String a){
        this.enlace=a;
    }

    public String getEnlace() {
        return enlace;
    }

    public void setEnlace(String a){
        this.enlace=a;
    }
}
