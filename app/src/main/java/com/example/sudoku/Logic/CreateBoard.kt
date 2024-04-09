package com.example.sudoku.Logic

import android.content.res.Resources
import android.text.InputType
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
                layoutParams.height = (Resources.getSystem().displayMetrics.widthPixels/8)
                layoutParams.width = (Resources.getSystem().displayMetrics.widthPixels/10)
                layoutParams.rowSpec = GridLayout.spec(i)
                layoutParams.columnSpec = GridLayout.spec(j)
                editText.layoutParams = layoutParams
                gridLayout.addView(editText)
                if(board[i][j]!=0){
                    editText.setText(board[i][j].toString())
                }
                editText.inputType = InputType.TYPE_NULL
            }
        }
    }
}