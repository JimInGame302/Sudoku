package com.example.sudoku

import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.GridLayout
import androidx.activity.ComponentActivity
import com.example.sudoku.Logic.CreateBoard
import com.example.sudoku.Logic.CreateGame
import com.example.sudoku.Logic.Randomizer
import com.example.sudoku.Logic.SelectNumber
import com.example.sudoku.databinding.ActivityMenuBinding
import com.example.sudoku.databinding.GameActivityBinding

class MainActivity : ComponentActivity() {

    private lateinit var binding: GameActivityBinding

    val randomizer = Randomizer()
    val createBoard = CreateBoard()
    val createGame = CreateGame()
    val selectNumber = SelectNumber(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GameActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val board = Array(9) { IntArray(9) { 0 } }
        val tablero = randomizer.randomizer(board)
        val game = createGame.createGame(tablero)
        createBoard.createBoard(findViewById<GridLayout>(R.id.gridLayoutTablero), game)

        var selectedEditText: EditText? = null

        val drawable = GradientDrawable().apply {
            setColor(Color.GREEN)
            setStroke(4, Color.BLACK)
        }

        for (i in 0 until findViewById<GridLayout>(R.id.gridLayoutTablero).childCount) {
            val child = findViewById<GridLayout>(R.id.gridLayoutTablero).getChildAt(i)
            if (child is EditText) {
                child.setOnClickListener {
                    val text = child.text.toString().trim()
                    if (text.isEmpty()) {
                        selectedEditText = child as EditText
                        child.background = drawable
                    }

                }
            }
        }
        val buttonOne = findViewById<Button>(R.id.oneButton)
        buttonOne.setOnClickListener {
            // Establece el número 1 en el EditText seleccionado
            selectNumber.selectNumber(1, selectedEditText)
            selectedEditText = null
        }
        val buttonTwo = findViewById<Button>(R.id.twoButton)
        buttonTwo.setOnClickListener {
            // Establece el número 1 en el EditText seleccionado
            selectNumber.selectNumber(2, selectedEditText)
            selectedEditText = null
        }
        val buttonThree = findViewById<Button>(R.id.threeButton)
        buttonThree.setOnClickListener {
            // Establece el número 1 en el EditText seleccionado
            selectNumber.selectNumber(3, selectedEditText)
            selectedEditText = null
        }
        val buttonFour = findViewById<Button>(R.id.fourButton)
        buttonFour.setOnClickListener {
            // Establece el número 1 en el EditText seleccionado
            selectNumber.selectNumber(4, selectedEditText)
            selectedEditText = null
        }
        val buttonFive = findViewById<Button>(R.id.fiveButton)
        buttonFive.setOnClickListener {
            // Establece el número 1 en el EditText seleccionado
            selectNumber.selectNumber(5, selectedEditText)
            selectedEditText = null
        }
        val buttonSix = findViewById<Button>(R.id.sixButton)
        buttonSix.setOnClickListener {
            // Establece el número 1 en el EditText seleccionado
            selectNumber.selectNumber(6, selectedEditText)
            selectedEditText = null
        }
        val buttonSeven= findViewById<Button>(R.id.sevenButton)
        buttonSeven.setOnClickListener {
            // Establece el número 1 en el EditText seleccionado
            selectNumber.selectNumber(7, selectedEditText)
            selectedEditText = null
        }
        val buttonEight = findViewById<Button>(R.id.eightButton)
        buttonEight.setOnClickListener {
            // Establece el número 1 en el EditText seleccionado
            selectNumber.selectNumber(8, selectedEditText)
            selectedEditText = null
        }
        val buttonNine = findViewById<Button>(R.id.nineButton)
        buttonNine.setOnClickListener {
            // Establece el número 1 en el EditText seleccionado
            selectNumber.selectNumber(9, selectedEditText)
            selectedEditText = null
        }

    }
}