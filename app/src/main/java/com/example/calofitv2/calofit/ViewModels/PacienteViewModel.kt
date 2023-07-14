package com.example.calofitv2.calofit.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calofitv2.calofit.data.DataFit.PacienteEntity
import com.example.calofitv2.calofit.data.DataFit.PacienteRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class PacienteViewModel @Inject constructor  (
    private val Repository:PacienteRepository
        ):ViewModel(){
    var state by mutableStateOf(PacienteState())
        private set
    private var pacienteSeleccionado: PacienteEntity? = null


    init {
        viewModelScope.launch {
            Repository.getPacientes().collectLatest {
                state = state.copy(
                    Pacientes =it
                )
            }
        }
    }

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
        val paciente = PacienteEntity(
            Nombre = state.NombrePaciente,
            Cedula = state.CedulaPaciente,
            Edad = state.EdadPaciente.toInt(),
            Altura = state.AlturaPaciente.toInt()

        )
        viewModelScope.launch {
            Repository.InsertPaciente(paciente)
        }
    }

    fun EliminarPaciente(paciente:PacienteEntity){
        viewModelScope.launch {
            Repository.deletearPaciente(paciente)
        }
    }

    fun seleccionarPaciente(paciente: PacienteEntity) {
        pacienteSeleccionado = paciente
        state = state.copy(
            NombrePaciente = paciente.Nombre,
            CedulaPaciente = paciente.Cedula,
            EdadPaciente = paciente.Edad.toString(),
            AlturaPaciente = paciente.Altura.toString()
        )
    }

    fun ModificarPaciente() {
        val pacienteSeleccionado = pacienteSeleccionado ?: return
        val pacienteModificado = PacienteEntity(
            Id = pacienteSeleccionado.Id,
            Nombre = state.NombrePaciente,
            Cedula = state.CedulaPaciente,
            Edad = state.EdadPaciente.toInt(),
            Altura = state.AlturaPaciente.toInt()
        )
        viewModelScope.launch {
            Repository.ModificarPaciente(pacienteModificado)
        }
        // Restablecer los campos de texto después de la modificación
        state = state.copy(
            NombrePaciente = "",
            CedulaPaciente = "",
            EdadPaciente = "",
            AlturaPaciente = ""
        )
    }



    /*
    // Función para cargar los datos de un paciente seleccionado
    fun cargarPacienteSeleccionado(paciente: PacienteEntity) {
        state = state.copy(
            NombrePaciente = paciente.Nombre,
            CedulaPaciente = paciente.Cedula,
            EdadPaciente = paciente.Edad.toString(),
            AlturaPaciente = paciente.Altura.toString()
        )
    }*/




}

