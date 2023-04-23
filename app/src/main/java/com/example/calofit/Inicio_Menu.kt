package com.example.calofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Inicio_Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_menu)
        abrirRegistroPaciente()
        abrirRegistroPlatos()
        abrirRegistroRegister()
    }
    //Abrir pantalla de registro de Platos
    fun abrirRegistroPlatos(){
        var btnAddPlatos: Button
        btnAddPlatos = findViewById(R.id.button1_add_plato)
        btnAddPlatos.setOnClickListener{
            AbrirAgregarPlatos()
        }
    }
    fun AbrirAgregarPlatos(){
        val intent= Intent(this, Agregar_Platos::class.java).apply {  }
        startActivity(intent)
    }
    //Abrir pantalla de registro de pacientes
    fun abrirRegistroPaciente(){
        var btnAddPatient: Button
        btnAddPatient = findViewById(R.id.button2_add_pacient)
        btnAddPatient.setOnClickListener{
            AbrirAgregarPaciente()
        }
    }
    fun AbrirAgregarPaciente(){
        val intent= Intent(this, Agregar_Paciente::class.java).apply {  }
        startActivity(intent)
    }
    //Abrir pantalla de registro de REGISTRO
    fun abrirRegistroRegister(){
        var btnAddRegister: Button
        btnAddRegister = findViewById(R.id.button3_add_registr)
        btnAddRegister.setOnClickListener{
            AbrirAgregarRegistro()
        }
    }
    fun AbrirAgregarRegistro(){
        val intent= Intent(this, Agregar_Registro::class.java).apply {  }
        startActivity(intent)
    }
}