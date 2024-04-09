package com.example.sudoku.Logic

import kotlin.random.Random

class Randomizer {
    fun randomizer(board: Array<IntArray>): Array<IntArray> {

        for (i in 0 until 9) {
            for (j in 0 until 9) {
                board[i][j] = (j * 3 + j / 3 + i) % 9 + 1
            }
        }

        for (i in 0 until 100) {
            val r = Random.nextInt(0, 3)
            val n1 = r * 3 + Random.nextInt(0, 3)
            val n2 = r * 3 + Random.nextInt(0, 3)
            val temp = board[n1]
            board[n1] = board[n2]
            board[n2] = temp
            for (j in 0 until 9) {
                val temp2 = board[j][n1]
                board[j][n1] = board[j][n2]
                board[j][n2] = temp2
            }
        }

        return board
    }
}