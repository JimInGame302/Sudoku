package com.example.sudoku.Logic

import android.content.Context
import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import android.media.MediaPlayer
import android.widget.EditText
import com.example.sudoku.R

class SelectNumber(private val context: Context) {
    private lateinit var mediaPlayer: MediaPlayer

    fun selectNumber(number: Int, selectedEditText: EditText?) {
        val drawable = GradientDrawable().apply {
            setColor(Color.WHITE)
            setStroke(4, Color.BLACK)
        }

        mediaPlayer = MediaPlayer.create(context, R.raw.ding)

        selectedEditText?.let {
            it.setText(number.toString())
            it.background = drawable
            mediaPlayer.seekTo(100)
            mediaPlayer.start()
        }
    }
}