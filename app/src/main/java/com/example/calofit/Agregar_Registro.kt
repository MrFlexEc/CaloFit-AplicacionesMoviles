package com.example.calofit

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class Agregar_Registro : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_registro)

        var btnSave:Button
        btnSave= findViewById(R.id.btnGuardarRegistro)

        val simpleDialog = AlertDialog.Builder(this)
            .setTitle("Registro Realizado")
            .setMessage("El registro se guardo exitosamente")
            .setPositiveButton("Aceptar"){_,_ ->
                Toast.makeText(this, "Registro realizado", Toast.LENGTH_SHORT).show()
            }
            .create()

        btnSave.setOnClickListener{simpleDialog.show()}

        //agregar informacion estatica en los spinners de naombre y platos

        val SpinnerNombres = findViewById<Spinner>(R.id.AGR_NombreRegistro)
        val SpinnerPlatos = findViewById<Spinner>(R.id.AGR_PlatosRegistro)

        //Arreglo de Nombres
        val OpcionesNombres = arrayOf("Pedro Paramo","Florencita Quijije")
        SpinnerNombres.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, OpcionesNombres)

        //Arreglo de Platos
        val OpcionesPlatos = arrayOf("Caldo de Pata","Caldo de Gallina")
        SpinnerPlatos.adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, OpcionesPlatos)
        //val items = listOf("Material", "Design", "Components", "Android")

        //val autoComplete : AutoCompleteTextView = findViewById(R.id.auto_complete)

        //val adapter = ArrayAdapter(this,R.layout.list_item, items)

        //autoComplete.setAdapter(adapter)

        //autoComplete.onItemClickListener = AdapterView.OnItemClickListener{
         //       adapterView, view, i, l ->
         //   val itemSelected = adapterView.getItemAtPosition(i)
         //   Toast.makeText(this, "Item: $itemSelected", Toast.LENGTH_SHORT).show()
       // }

    }
}