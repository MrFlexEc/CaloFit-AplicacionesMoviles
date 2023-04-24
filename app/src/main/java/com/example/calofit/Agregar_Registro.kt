package com.example.calofit

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast

class Agregar_Registro : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_registro)

        var btnSave:Button = findViewById(R.id.button5)

        val simpleDialog = AlertDialog.Builder(this)
            .setTitle("Plato registrado")
            .setMessage("El plato se guardo exitosamente")
            .setPositiveButton("Aceptar"){_,_ ->
                Toast.makeText(this, "Plato registrado", Toast.LENGTH_SHORT).show()
            }
            .create()

        btnSave.setOnClickListener{simpleDialog.show()}



        val items = listOf("Material", "Design", "Components", "Android")

        val autoComplete : AutoCompleteTextView = findViewById(R.id.auto_complete)

        val adapter = ArrayAdapter(this,R.layout.list_item, items)

        autoComplete.setAdapter(adapter)

        autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
                adapterView, view, i, l ->
            val itemSelected = adapterView.getItemAtPosition(i)
            Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
        }

    }
}