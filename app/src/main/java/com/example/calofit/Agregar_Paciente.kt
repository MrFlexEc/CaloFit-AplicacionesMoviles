package com.example.calofit

import android.app.Activity
import android.app.AlertDialog
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat
import androidx.core.content.IntentCompat
import com.example.calofit.databinding.ActivityAgregarPacienteBinding

class Agregar_Paciente : AppCompatActivity() {
    private lateinit var binding: ActivityAgregarPacienteBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAgregarPacienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener{ requestPermission() }

        val simpleDialog = AlertDialog.Builder(this)
            .setTitle("Plato registrado")
            .setMessage("El plato se guardo exitosamente")
            .setPositiveButton("Aceptar"){_,_ ->
                Toast.makeText(this, "Plato registrado", Toast.LENGTH_SHORT).show()
            }
            .create()

        binding.button2.setOnClickListener{simpleDialog.show()}
    }

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
            binding.imageView.setImageURI(data)
        }
    }
    private fun pickPhotoFromGallery(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startForActivityGallery.launch(intent)
    }
}