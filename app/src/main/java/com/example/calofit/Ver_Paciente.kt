package com.example.calofit

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.calofit.databinding.ActivityAgregarPacienteBinding

class Ver_Paciente : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_paciente)

        var btnVer: Button = findViewById(R.id.btn_pac1)

        val simpleDialog = AlertDialog.Builder(this)
            .setTitle("Paciente: Pedro Paramo")
            .setMessage("C.I: 1304857151"+"\r\n"+
            "Edad: 26 años"+"\r\n"+
            "Peso: 85 Kg"+"\r\n"+
            "Altura: 182 cm")
            .setPositiveButton("Cerrar"){_,_ ->
                Toast.makeText(this, "Cerrando...", Toast.LENGTH_SHORT).show()
            }
            .create()

        btnVer.setOnClickListener{simpleDialog.show()}


        var btnVer2: Button = findViewById(R.id.btn_pac2)

        val simpleDialog2 = AlertDialog.Builder(this)
            .setTitle("Paciente: Florencita Quijije")
            .setMessage("C.I: 1316824221"+"\r\n"+
                    "Edad: 24 años"+"\r\n"+
                    "Peso: 60 Kg"+"\r\n"+
                    "Altura: 162 cm")
            .setPositiveButton("Cerrar"){_,_ ->
                Toast.makeText(this, "Cerrando...", Toast.LENGTH_SHORT).show()
            }
            .create()

        btnVer2.setOnClickListener{simpleDialog2.show()}
    }
}