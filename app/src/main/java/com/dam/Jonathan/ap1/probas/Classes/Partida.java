package com.dam.Jonathan.ap1.probas.Classes;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;


import com.dam.Jonathan.ap1.probas.interficias.Resultat;

public class Partida implements Resultat {
    private String nom = "JUEGO DE LA OCA";
    private Jugador[] listaJUgadores = new Jugador[6];
    private Integer index = 0;
    private Random random = new Random();
    private Integer indexJugados = 0;
    private static final Set<Integer> POSICIONES_OCA = new HashSet<>();

    private String[] listaColores = {"rojo","azul","amarillo","verde","negro","rosa"};
    public Partida() {
        int[] posiciones = {5, 9, 14, 18, 23, 27, 30, 34, 39, 41, 45, 50, 54, 59};
        for (int pos : posiciones) {
            POSICIONES_OCA.add(pos);
        }
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
        int t = tirada;
        tirada += j.getPosisio();
        j.setPosisio(tirada);
        System.out.println("la posisio del jugador " +j.getNom() + ":" + j.getPosisio() + " i a sortit un=" + t);
        if (j.getPosisio() > 63) {
            System.out.println("ups tas pasat");
           int p = j.getPosisio();
           int difarencia = p - 63;
           j.setPosisio(63- difarencia);
            System.out.println("la posisio del jugador " +j.getNom() + ":" + j.getPosisio());


        }
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
       actualitza(j,t);
       while (casellaespacial(j)){
           t = tirada(j);
           actualitza(j,t);
       }

    }

    private boolean casellaespacial(Jugador j) {
        if (POSICIONES_OCA.contains(j.getPosisio())) {
            System.out.println("ta tocat la oca torna a tira");
            return true;
        }
        if (j.getPosisio() == 6){
            System.out.println("as caigut el pont et mous a la casella 12 i et torna a tocar tira");
            j.setPosisio(12);
            return true;
        }
        if (j.getPosisio() == 12){
            System.out.println("as caigut el pont et mous a la casella 6 i et torna a tocar tira");
            j.setPosisio(6);
            return true;
        }
        if (j.getPosisio() == 58){
            System.out.println("ups tas mort torna a la casilla 0");
            j.setPosisio(0);
        }
        return false;
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
