package com.example.sudoku

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sudoku.ui.theme.SudokuTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SudokuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val board = Array(9) { IntArray(9) { 0 } }
                    PrintTablero(randomizer(board))
                }
            }
        }
    }
}

@Composable
fun PrintTablero(tablero: Array<IntArray>) {
    val tableroString = buildString {
        for (fila in tablero) {
            append(fila.joinToString(", ") + "\n")
        }
    }

    Text(text = tableroString)
}

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