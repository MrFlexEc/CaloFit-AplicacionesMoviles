package com.example.calofitv2.calofit.data.PacienteFit

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PacienteEntity(
    @PrimaryKey(autoGenerate = true)
    val Id: Int?=null,
    val Nombre: String,
    val Cedula: String ,
    val Edad: Int,
    val Altura: Int
)
