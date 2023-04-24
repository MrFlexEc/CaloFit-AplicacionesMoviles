package com.example.calofit

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast

class Ver_Platos : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ver_platos)

        var btnVer: Button = findViewById(R.id.btn_pl1)

        val simpleDialog = AlertDialog.Builder(this)
            .setTitle("Plato: Caldo de Pata")
            .setMessage("Calorías: 1200")
            .setPositiveButton("Cerrar"){_,_ ->
                Toast.makeText(this, "Cerrando...", Toast.LENGTH_SHORT).show()
            }
            .create()

        btnVer.setOnClickListener{simpleDialog.show()}


        var btnVer2: Button = findViewById(R.id.btn_pl2)

        val simpleDialog2 = AlertDialog.Builder(this)
            .setTitle("Plato: Caldo de Gallina")
            .setMessage("Calorías: 800")
            .setPositiveButton("Cerrar"){_,_ ->
                Toast.makeText(this, "Cerrando...", Toast.LENGTH_SHORT).show()
            }
            .create()

        btnVer2.setOnClickListener{simpleDialog2.show()}
    }
}