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
import com.example.sudoku.Logic.Randomizer

class MainActivity : ComponentActivity() {

    val randomizer = Randomizer()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SudokuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val board = Array(9) { IntArray(9) { 0 } }
                    PrintTablero(randomizer.randomizer(board))
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

