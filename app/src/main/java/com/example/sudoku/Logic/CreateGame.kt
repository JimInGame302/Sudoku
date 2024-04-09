package com.example.sudoku.Logic

import kotlin.random.Random

class CreateGame {
    fun createGame(board: Array<IntArray>): Array<IntArray> {
        val random = Random
        for (i in 0 until 9) {
            val pistas = MutableList(3) { 0 } // Lista para almacenar los números a eliminar
            for (k in 0 until 3) {
                var numeroSeleccionado: Int
                do {
                    numeroSeleccionado = random.nextInt(1, 10) // Genera un número aleatorio del 1 al 9
                } while (pistas.contains(numeroSeleccionado)) // Repite si el número ya está en la lista
                pistas[k] = numeroSeleccionado // Almacena el número seleccionado
            }
            for (j in 0 until 9) {
                if (!pistas.contains(board[i][j])) {
                    board[i][j] = 0
                }
            }
        }
        return board
    }
}