package com.example.calofitv2.calofit.ViewModels

import com.example.calofitv2.calofit.data.DataFit.PacienteEntity
import com.example.calofitv2.calofit.data.DataFit.PlatoEntity
import com.example.calofitv2.calofit.data.DataFit.RegistroEntity
import java.util.*


data class RegistroState(
    val idpaciente:String? = null,
    val PacienteID: String = "",
    val PlatoID: String = "",
    val Fecha: String = "",
    val Porciones: String = "",

    val Registros:List<RegistroEntity> = emptyList(),
    //val
)
