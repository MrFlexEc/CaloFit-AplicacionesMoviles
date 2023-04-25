package com.example.calofit

import android.app.Activity
import android.app.AlertDialog
import android.app.Instrumentation.ActivityResult
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
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

        binding.btnImagenPaciente.setOnClickListener{ requestPermission() }

        val simpleDialog = AlertDialog.Builder(this)
            .setTitle("Paciente registrado")
            .setMessage("El paciente se guardo exitosamente")
            .setPositiveButton("Aceptar"){_,_ ->
                Toast.makeText(this, "Paciente registrado", Toast.LENGTH_SHORT).show()
            }
            .create()

        binding.btnguardarPaciente.setOnClickListener{simpleDialog.show()}

        /*
        var BtnInicioMenu: ImageButton
        BtnInicioMenu=findViewById(R.id.btnHome)

        BtnInicioMenu.setOnClickListener {
            AbrirInicio()
        }*/
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
            binding.ImagenPaciente.setImageURI(data)
        }
    }
    private fun pickPhotoFromGallery(){
        val intent = Intent(Intent.ACTION_GET_CONTENT)
        intent.type = "image/*"
        startForActivityGallery.launch(intent)
    }

    /*
    fun AbrirInicio(){
        val intent= Intent(this, Inicio_Menu::class.java).apply {  }
        startActivity(intent)
    }*/

}