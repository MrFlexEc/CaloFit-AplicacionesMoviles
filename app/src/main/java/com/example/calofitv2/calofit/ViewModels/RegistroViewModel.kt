package com.example.calofitv2.calofit.ViewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calofitv2.calofit.data.DataFit.*
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class RegistroViewModel @Inject constructor(
    private val Repository: RegistroRepository,
    private val platoRepository: PlatoRepository,
    private val pacienteRepository: PacienteRepository
): ViewModel() {
    var state by mutableStateOf(RegistroState())
        private set

    private var registroSeleccionado: RegistroEntity? = null

    //usarse para dropmenu
    val platos: Flow<List<PlatoEntity>> = platoRepository.getPlatos()
    val pacientes: Flow<List<PacienteEntity>> = pacienteRepository.getPacientes()

    var pacienteNombre by mutableStateOf("")
    var platoNombre by mutableStateOf("")

    init {
        viewModelScope.launch {
            Repository.getRegistros().collectLatest {
                state = state.copy(
                    Registros =it
                )
            }
        }
    }


    fun PlatoN(platoid:String){
        state = state.copy(
            PlatoID = platoid
        )
    }
    fun PacienteN(pacienteid:String){
        state = state.copy(
            PacienteID = pacienteid
        )
    }



    fun FechaRegistro(fecha:String){
        state = state.copy(
            Fecha = fecha
        )
    }
    fun Porciones(porcion:String){
        state = state.copy(
            Porciones = porcion
        )
    }

    fun GuardarRegistro() {
        val pacienteId = if (state.PacienteID.isNotBlank()) state.PacienteID.toLong() else 0L
        val platoId = if (state.PlatoID.isNotBlank()) state.PlatoID.toLong() else 0L

        val registro = RegistroEntity(
            PacienteId = pacienteId,
            PlatotId = platoId,
            Fecha = state.Fecha,
            Porciones = state.Porciones.toInt()
        )

        viewModelScope.launch {
            Repository.Insertregistro(registro)
        }
    }

    fun EliminarRegistro(registro: RegistroEntity){
        viewModelScope.launch {
            Repository.deletearRegistro(registro)
        }
    }

    fun seleccionarRegistro(registro: RegistroEntity) {
        viewModelScope.launch {
            registroSeleccionado = registro
            val paciente = pacienteRepository.getPacienteById(registro.PacienteId)
            val plato = platoRepository.getPlatoById(registro.PlatotId)
            pacienteNombre = paciente?.Nombre ?: ""
            platoNombre = plato?.Nombre ?: ""
            state = state.copy(
                PacienteID = registro.PacienteId.toString(),
                PlatoID = registro.PlatotId.toString(),
                Fecha = registro.Fecha,

                Porciones = registro.Porciones.toString()
            )
        }
    }

    fun si(){

    }


    fun ModificarPlato() {
        val registroSeleccionado = registroSeleccionado ?: return
        val registroModificado = RegistroEntity(
            Id = registroSeleccionado.Id,
            PacienteId = state.PacienteID.toLong(),
            PlatotId = state.PlatoID.toLong(),
            Fecha = state.Fecha,
            Porciones= state.Porciones.toInt()
        )
        viewModelScope.launch {
            Repository.ModificarRegistro(registroModificado)
        }
        // Restablecer los campos de texto después de la modificación
        state = state.copy(
            PacienteID="",
            PlatoID="",
            Fecha="",
            Porciones=""
        )
    }



}