package com.example.calofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class Splash_Screen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Una vez abra el splash pues abrira la pantalla principal
        startActivity(Intent(this, MainActivity::class.java))
    }
}