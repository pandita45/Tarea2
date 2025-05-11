package org.example;

public enum TipoReunion {
    TECNICA(1),
    MARKETING(2),
    OTRO(3);
    private final int valor;
    TipoReunion(int valor){
        this.valor = valor;
    }

}
