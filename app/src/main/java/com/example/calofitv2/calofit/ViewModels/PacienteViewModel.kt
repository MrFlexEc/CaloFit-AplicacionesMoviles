package com.example.calofitv2.calofit.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calofitv2.calofit.data.DataFit.Paciente
import com.example.calofitv2.calofit.data.DataFit.PacienteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PacienteViewModel @Inject constructor  (
    private val Repository:PacienteRepository
        ):ViewModel(){
    var state by mutableStateOf(PacienteState())
        private set

    fun NombrePaciente(nombre:String){
        state = state.copy(
            NombrePaciente = nombre
        )
    }

    fun CedulaPaciente(cedula:String){
        state = state.copy(
            CedulaPaciente = cedula
        )
    }
    fun EdadPaciente(edad:String){
        state = state.copy(
            EdadPaciente = edad
        )
    }
    fun AlturaPaciente(altura:String){
        state = state.copy(
            AlturaPaciente = altura
        )
    }

    fun GuardarPaciente(){
        val paciente = Paciente(
            NombrePaciente = state.NombrePaciente,
            CedulaPaciente = state.CedulaPaciente,
            EdadPaciente = state.EdadPaciente,
            AlturaPaciente = state.AlturaPaciente,
            idpaciente = state.idpaciente

        )
        viewModelScope.launch {
            Repository.InsertPaciente(paciente)
        }
    }




}

