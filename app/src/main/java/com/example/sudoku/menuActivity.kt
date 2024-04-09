package com.example.sudoku

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import com.example.sudoku.Logic.CreateBoard
import com.example.sudoku.Logic.Randomizer
import com.example.sudoku.databinding.GameActivityBinding

class menuActivity : ComponentActivity() {
    private lateinit var binding: GameActivityBinding
    private val randomizer = Randomizer()
    private val createBoard = CreateBoard()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GameActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Encuentra los botones de dificultad
        val buttonEasy = findViewById<Button>(R.id.easyButton)
        val buttonMedium = findViewById<Button>(R.id.mediumButton)
        val buttonHard = findViewById<Button>(R.id.hardButton)

        // Establece OnClickListener para cada botón
        buttonEasy.setOnClickListener {
            startGameActivity(Dificultad.FACIL)
        }

        buttonMedium.setOnClickListener {
            startGameActivity(Dificultad.MEDIO)
        }

        buttonHard.setOnClickListener {
            startGameActivity(Dificultad.DIFICIL)
        }
    }

    private fun startGameActivity(dificultad: Dificultad) {
        // Crea un intent para iniciar la actividad del juego
        val intent = GameActivity.newIntent(this, dificultad)
        startActivity(intent)
    }
}

class GameActivity {
    companion object {
        private const val DIFICULTAD = "com.example.sudoku.dificultad"

        fun newIntent(context: Context, dificultad: Dificultad): Intent {
            val intent = Intent(context, GameActivity::class.java)
            intent.putExtra(DIFICULTAD, dificultad)
            return intent
        }
    }

}

enum class Dificultad {
    FACIL, MEDIO, DIFICIL
}
