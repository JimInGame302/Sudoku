package com.example.sudoku.Logic

import android.widget.EditText
import android.widget.GridLayout
import com.example.sudoku.R

class CreateBoard {
    fun createBoard(gridLayout: GridLayout, board: Array<IntArray>) {
        for (i in 0 until 9) {
            for (j in 0 until 9) {
                val editText = EditText(gridLayout.context)
                editText.textSize = 18f
                editText.gravity = android.view.Gravity.CENTER
                editText.setBackgroundResource(R.drawable.borde_casillas)
                val layoutParams = GridLayout.LayoutParams()
                layoutParams.rowSpec = GridLayout.spec(i)
                layoutParams.columnSpec = GridLayout.spec(j)
                //layoutParams.setMargins(4, 4, 4, 4)
                editText.layoutParams = layoutParams
                gridLayout.addView(editText)
                editText.setText(board[i][j].toString())
            }
        }
    }
}