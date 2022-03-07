package com.example.cahyasanote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cahyasanote.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {

    private lateinit var aboutBinding: ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        aboutBinding = ActivityAboutBinding.inflate(layoutInflater)
        setContentView(aboutBinding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }
}