package com.example.calofitv2.calofit.data.DataFit

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

@Entity
data class PlatoEntity(
    @PrimaryKey(autoGenerate = true)
    val Id: Int?=null,
    val Nombre: String,
    val Descripcion: String ,
    val Calorias: Int
)


