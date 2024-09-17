package com.dam.Jonathan.ap1.probas.Classes;

public class Jugador extends Persona {


    private  Integer posisio = 0;
    String Color;

    public Jugador(String nom) {
        super(nom);

    }

    public Integer getPosisio() {
        return posisio;
    }

    public void setPosisio(Integer posisio) {
        this.posisio = posisio;
    }

}
