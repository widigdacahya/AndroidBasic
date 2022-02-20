package com.example.myintentplay

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MoveActivityWithData : AppCompatActivity() {

    companion object {
        const val EXTRA_AGE = "extra_age"
        const val EXTRA_NAME ="extra_name"
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        val tvDataReceived : TextView = findViewById(R.id.tvDataActivityUI)

        val theName = intent.getStringExtra(EXTRA_NAME)
        val theAge = intent.getIntExtra(EXTRA_AGE,0)

        val textModifier = "\uD83D\uDC64Name : $theName\n☕Age : $theAge"
        tvDataReceived.text = textModifier

    }
}