package com.dam.Jonathan.ap1.probas

import com.dam.Jonathan.ap1.probas.Classes.Jugador
import com.dam.Jonathan.ap1.probas.Classes.Partida

fun main() {


    var nj: Int? = null

    while (nj == null) {
        println("¿Cuántos jugadores seréis?")
        val input = readLine()
        nj = input?.toIntOrNull()
        if (nj == null || nj <= 0) {
            println("Entrada no válida. Por favor, ingrese un número entero positivo.")
        }
    }
    val partida =  Partida();
    for (i in 0..(nj -1)) {
        println("jugador $i cual es tu nombre?")
        val input = readLine()
        val nom = input.toString()

        val color = partida.demanarColor()
        val j = Jugador(nom)
        partida.afaixi_jugador(j)
    }
    while ( partida.posisioMaxima() < 63) {
        partida.nextTirada();
    }
    partida.guanyador()

}
