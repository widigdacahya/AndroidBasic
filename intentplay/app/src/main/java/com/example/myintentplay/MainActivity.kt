package com.example.myintentplay

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnChangeActivity: Button = findViewById(R.id.btnMoveActivityUI)
        btnChangeActivity.setOnClickListener (this)

        val btnChangeActivityWithData : Button = findViewById(R.id.btnMoveWithDataUI)
        btnChangeActivityWithData.setOnClickListener (this)

        val btnDialSomeone: Button = findViewById(R.id.btnImplicitIntentUI)
        btnDialSomeone.setOnClickListener (this)
    }

    override fun onClick(v: View?) {

        when(v?.id) {
            R.id.btnMoveActivityUI -> {
                val intentToMoveActivity = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(intentToMoveActivity)
            }
            R.id.btnMoveWithDataUI -> {
                val intentMoveWithData = Intent(this@MainActivity, MoveActivityWithData::class.java)
                intentMoveWithData.putExtra(MoveActivityWithData.EXTRA_NAME, "Cahyadesthian R. Widigda")
                intentMoveWithData.putExtra(MoveActivityWithData.EXTRA_AGE,22)
                startActivity(intentMoveWithData)
            }
            R.id.btnImplicitIntentUI -> {
                val phoneNumber = "085746641537"
                val dialPhoneIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialPhoneIntent)
            }

        }
    }
}