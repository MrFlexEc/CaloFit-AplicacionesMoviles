package com.example.calofit

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import com.example.calofit.databinding.ActivityAgregarPlatosBinding

class Agregar_Platos : AppCompatActivity() {
    //Crear una variable binding apuntando a la actividad en la que nos ubicamos
    private lateinit var binding: ActivityAgregarPlatosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //Inflate a la variable binding de nuestra actividad
        binding = ActivityAgregarPlatosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        //Recoleccion de evento del boton de guardado
        binding.button3.setOnClickListener{requestPermission()}

        //Creacion del metodo para mostrar alerta al guardar
        val simpleDialog = AlertDialog.Builder(this)
            .setTitle("Plato registrado")
            .setMessage("El plato se guardo exitosamente")
            .setPositiveButton("Aceptar"){_,_ ->
                Toast.makeText(this, "Plato registrado", Toast.LENGTH_SHORT).show()
            }
            .create()

        binding.button4.setOnClickListener{simpleDialog.show()}
    }
    //Funcion para pedir los permisos para acceder a la galeria
    private fun requestPermission(){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            when{
                ContextCompat.checkSelfPermission(
                    this,
                    android.Manifest.permission.READ_EXTERNAL_STORAGE
                )== PackageManager.PERMISSION_GRANTED->{
                    pickPhotoFromGallery()
                }
                else-> requestPermissionLauncher.launch(android.Manifest.permission.READ_EXTERNAL_STORAGE)
            }
        }else{
            pickPhotoFromGallery()
        }
    }
    private val requestPermissionLauncher = registerForActivityResult(
        ActivityResultContracts.RequestPermission()
    ){isGranted->
        if (isGranted){
            pickPhotoFromGallery()
        }else{
            Toast.makeText(this, "You need to enable the permission", Toast.LENGTH_SHORT).show()
        }
    }
    private val startForActivityGallery = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ){result->
        if(result.resultCode == Activity.RESULT_OK){
            val data = result.data?.data
            binding.imageView2.setImageURI(data)
        }
    }
    private fun pickPhotoFromGallery(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startForActivityGallery.launch(intent)
    }
}