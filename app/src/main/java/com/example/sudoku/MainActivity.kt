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
import androidx.compose.ui.tooling.preview.Preview
import com.example.sudoku.ui.theme.SudokuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SudokuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val tablero = Array(9) { IntArray(9) { 0 } }
                    randomizer(tablero)
                    PrintTablero(tablero)
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

fun randomizer(tablero: Array<IntArray>) {
    var i = 0
    while (i < tablero.size) {
        var j = 0
        while (j < tablero[i].size) {
            val numerosDisponibles = (1..9).toMutableList()
            tablero[i].forEach { numeroExistente -> numerosDisponibles.remove(numeroExistente) }
            numerosDisponibles.shuffle()
            val numero = numerosDisponibles.first()
            if (verificarNum(tablero, numero, i, j)==true) {
                tablero[i][j] = numero
            }
            j++
        }
        i++
    }
}

fun verificarNum(tablero: Array<IntArray>, numero: Int, fila: Int, columna: Int): Boolean{
    for (i in 0 until tablero.size){
        if(tablero[fila][i]!=null) {
            if (tablero[fila][i] == numero) {
                return false
            }
        }
    }
    return true
}