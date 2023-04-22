package com.example.calofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        VerificarCuenta()
    }
    fun VerificarCuenta(){
        var btnInicioSesion: Button
        btnInicioSesion=findViewById(R.id.btnIniciarSesion)

        btnInicioSesion.setOnClickListener {
            AbrirInicio()
        }
    }

    fun AbrirInicio(){
        val intent= Intent(this, Inicio_Menu::class.java).apply {  }
        startActivity(intent)
    }
}