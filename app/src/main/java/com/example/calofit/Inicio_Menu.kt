package com.example.calofit

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Inicio_Menu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio_menu)
        //Call a las funciones creadas
        abrirRegistroPaciente()
        abrirRegistroPlatos()
        abrirRegistroRegister()
        abrirVerPaciente()
        abrirVerPlato()
        abrirVerRegistro()
        volverLogin()
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
    fun abrirVerPlato(){
        var btnViewPlatos: Button
        btnViewPlatos = findViewById(R.id.btn_plato)
        btnViewPlatos.setOnClickListener{
            AbrirVerPlato()
        }
    }

    fun AbrirVerPlato(){
        val intent= Intent(this, Ver_Platos::class.java).apply {  }
        startActivity(intent)
    }
    fun abrirVerPaciente(){
        var btnViewPlatos: Button
        btnViewPlatos = findViewById(R.id.btn_paciente)
        btnViewPlatos.setOnClickListener{
            AbrirVerPaciente()
        }
    }
    fun AbrirVerPaciente(){
        val intent= Intent(this, Ver_Paciente::class.java).apply {  }
        startActivity(intent)
    }
    fun abrirVerRegistro(){
        var btnViewPlatos: Button
        btnViewPlatos = findViewById(R.id.btn_registro)
        btnViewPlatos.setOnClickListener{
            AbrirVerRegistro()
        }
    }

    fun AbrirVerRegistro(){
        val intent= Intent(this, Ver_Registro::class.java).apply {  }
        startActivity(intent)
    }

    fun volverLogin(){
        var btnCerrarSesion: Button
        btnCerrarSesion = findViewById(R.id.btnCerrarSesion)
        btnCerrarSesion.setOnClickListener{
            VolverLogin()
        }
    }
    fun VolverLogin(){
        val intent= Intent(this, MainActivity::class.java).apply {  }
        startActivity(intent)
    }
}