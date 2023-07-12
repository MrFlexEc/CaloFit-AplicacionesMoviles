package com.example.calofitv2.calofit.ViewModels

import com.example.calofitv2.calofit.data.DataFit.Paciente
import com.example.calofitv2.calofit.data.DataFit.PacienteEntity

data class PacienteState(
    val idpaciente:String = "",
    val NombrePaciente: String = "",
    val CedulaPaciente: String = "",
    val EdadPaciente: String = "",
    val AlturaPaciente: String = "",

    val Pacientes:List<PacienteEntity> = emptyList(),


    )
