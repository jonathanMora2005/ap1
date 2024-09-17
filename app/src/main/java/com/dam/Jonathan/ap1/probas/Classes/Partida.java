package com.dam.Jonathan.ap1.probas.Classes;

import android.graphics.Color;

import java.util.Random;
import java.util.Scanner;


import com.dam.Jonathan.ap1.probas.interficias.Resultat;

public class Partida implements Resultat {
    private String nom = "JUEGO DE LA OCA";
    private Jugador[] listaJUgadores = new Jugador[6];
    private Integer index = 0;
    private Random random = new Random();
    private Integer indexJugados = 0;
    private String[] listaColores = {"rojo","azul","amarillo","verde","negro","rosa"};
    public Partida() {
    }
    public void afaixi_jugador(Jugador j) {
        listaJUgadores[index] = j;
        index++;
    }
    public void eliminarColor(int i){
        String[] nuevaListaColores = new String[listaColores.length - 1];
        int I = 0;
        int e = 0;
        while (I < listaColores.length){
            if (i != I){
                nuevaListaColores[e] = listaColores[I];
                I++;
                e++;
            }
            else {
                I++;
            }
        }



        listaColores = nuevaListaColores;
    }
    public String demanarColor(){
        int i = 0;
        for (String color : listaColores) {
                System.out.print(i + ": ");
                System.out.println(color);
                i++;
            }
        Scanner scanner = new Scanner(System.in);
        int input = Integer.parseInt(scanner.nextLine());
        String coloorJugador = listaColores[input];
        eliminarColor(input);
        return coloorJugador;
    }
    public int posisioMaxima(){
        int pm = 0;
        for (int e = 0; e < index; e++){
           if (listaJUgadores[e].getPosisio() > pm) {
               pm = listaJUgadores[e].getPosisio();
           }
        }
        return pm;
    }
    public int tirada(Jugador j) {
        Scanner scanner = new Scanner(System.in);

        System.out.println(" jugador "+j.getNom() + "et toca tira:");
        String input = scanner.nextLine();
        return random.nextInt(6) + 1;
    }
    public int actualitza(Jugador j,int tirada){
        tirada += j.getPosisio();
        j.setPosisio(tirada);
        System.out.println("la posisio del jugador " +j.getNom() + ":" + j.getPosisio() + "i a sortit un=" + tirada);
        return j.getPosisio();
    }

    public Jugador nextJugador(){
        Jugador js = listaJUgadores[indexJugados];
        if (indexJugados < (index -1)){
            indexJugados++;
        }
        else {
            indexJugados = 0;
        }
        return js;
    }
    public void nextTirada() {
       Jugador j = this.nextJugador();
       int t = tirada(j);
       int p = actualitza(j,t);
       boolean oca = posiblaOca(p);
       while (oca){
           System.out.println("oca torna a tira");
           t = tirada(j);
           p = actualitza(j,t);
           oca = posiblaOca(p);
       }
    }

    private boolean posiblaOca(int p) {
        return p == 5 || p == 9 || p == 14 || p == 18 || p == 23 || p == 27 ||
                p == 30 || p == 34 || p == 39 || p == 41 || p == 45 || p == 50 ||
                p == 54 || p == 59;
    }

    @Override
    public void guanyador() {
        String guanyador = "";
        int posisioGuanyadora = posisioMaxima();
        for (int e = 0; e < index; e++ ){
            if (listaJUgadores[e].getPosisio() == posisioGuanyadora) {
                guanyador= listaJUgadores[e].getNom();
                break;
            }
        }
        System.out.println("el guanyador es = " + guanyador );
    }
}
