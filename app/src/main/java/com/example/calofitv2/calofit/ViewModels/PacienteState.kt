package com.example.calofitv2.calofit.ViewModels

import com.example.calofitv2.calofit.data.PacienteFit.Paciente

data class PacienteState(

    val NombrePaciente: String = "",
    val CedulaPaciente: String = "",
    val EdadPaciente: String = "",
    val AlturaPaciente: String = "",

    val Pacientes:List<Paciente> = emptyList(),


    )
