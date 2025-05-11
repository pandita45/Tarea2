package org.example;

public enum TipoReunion {
    TECNICA(3),
    MARKETING(2),
    OTRO(1);
    private final int valor;
    TipoReunion(int valor){
        this.valor = valor;
    }

}
