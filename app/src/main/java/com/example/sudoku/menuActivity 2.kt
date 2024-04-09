package com.example.sudoku

class menuActivity : ComponentActivity() {
    private lateinit var binding: GameActivityBinding
    private val randomizer = Randomizer()
    private val createBoard = CreateBoard()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = GameActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Encuentra los botones de dificultad
        val buttonEasy = findViewById<Button>(R.id.button_easy)
        val buttonMedium = findViewById<Button>(R.id.button_medium)
        val buttonHard = findViewById<Button>(R.id.button_hard)

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
    enum class Dificultad {
        FACIL, MEDIO, DIFICIL
    }
}
