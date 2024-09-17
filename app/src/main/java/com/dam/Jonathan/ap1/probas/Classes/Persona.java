package com.dam.Jonathan.ap1.probas.Classes;

public class Persona {

    private String nom;

    public Persona() {
        this.nom = "Desconegut";
    }

    public Persona(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nom='" + nom + '\'' +
                '}';
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


}
