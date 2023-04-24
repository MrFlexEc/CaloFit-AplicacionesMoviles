package com.example.calofit

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Ver_Registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_registro)

        var btnVer: Button = findViewById(R.id.btn_reg1)

        val simpleDialog = AlertDialog.Builder(this)
            .setTitle("Registro 1")
            .setMessage("Paciente: Pedro Paramo"+"\r\n"+
                    "Plato: Caldo de Pata"+"\r\n"+
                    "Fecha: 10/04/2023"+"\r\n"+
                    "Calorias: 1200"+"\r\n"+
                    "Porciones: 1")
            .setPositiveButton("Cerrar"){_,_ ->
                Toast.makeText(this, "Cerrando...", Toast.LENGTH_SHORT).show()
            }
            .create()

        btnVer.setOnClickListener{simpleDialog.show()}


        var btnVer2: Button = findViewById(R.id.btn_reg2)

        val simpleDialog2 = AlertDialog.Builder(this)
            .setTitle("Registro 2")
            .setMessage("Paciente: Florencita Quijije"+"\r\n"+
                    "Plato: Caldo de Gallina"+"\r\n"+
                    "Fecha: 11/04/2023"+"\r\n"+
                    "Calorias: 800"+"\r\n"+
                    "Porciones: 1")
            .setPositiveButton("Cerrar"){_,_ ->
                Toast.makeText(this, "Cerrando...", Toast.LENGTH_SHORT).show()
            }
            .create()

        btnVer2.setOnClickListener{simpleDialog2.show()}
    }
}