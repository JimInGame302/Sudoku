package com.example.sudoku

import android.os.Bundle
import android.widget.EditText
import android.widget.GridLayout
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.sudoku.Logic.CreateBoard
import com.example.sudoku.ui.theme.SudokuTheme
import com.example.sudoku.Logic.Randomizer
import com.example.sudoku.databinding.GameActivityBinding

class MainActivity : ComponentActivity() {

    val randomizer = Randomizer()
    val createBoard = CreateBoard()
    private lateinit var binding: GameActivityBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SudokuTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    binding = GameActivityBinding.inflate(layoutInflater)
                    setContentView(binding.root)
                    val board = Array(9) { IntArray(9) { 0 } }
                    val tablero=randomizer.randomizer(board)
                    createBoard.createBoard(findViewById<GridLayout>(R.id.gridLayoutTablero),tablero)

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

