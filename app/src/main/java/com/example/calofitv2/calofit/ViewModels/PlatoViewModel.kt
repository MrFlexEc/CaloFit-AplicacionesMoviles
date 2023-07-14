package com.example.calofitv2.calofit.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calofitv2.calofit.data.DataFit.PacienteEntity
import com.example.calofitv2.calofit.data.DataFit.PlatoEntity
import com.example.calofitv2.calofit.data.DataFit.PlatoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlatoViewModel @Inject constructor(
    private val Repository: PlatoRepository
): ViewModel() {
    var state by mutableStateOf(PlatoState())
        private set

    private var platoSeleccionado: PlatoEntity? = null

    init {
        viewModelScope.launch {
            Repository.getPlatos().collectLatest {
                state = state.copy(
                    Platos =it
                )
            }
        }
    }


    fun NombrePlato(nombre:String){
        state = state.copy(
            NombrePlato = nombre
        )
    }

    fun DescripcionPlato(descripcion:String){
        state = state.copy(
            DescripcionPlato = descripcion
        )
    }
    fun CaloriasPlato(calorias:String){
        state = state.copy(
            CaloriasPlato = calorias
        )
    }

    fun GuardarPlato(){
        val plato = PlatoEntity(
            Nombre = state.NombrePlato,
            Descripcion = state.DescripcionPlato,
            Calorias = state.CaloriasPlato.toInt()

        )
        viewModelScope.launch {
            Repository.Insertplato(plato)
        }
    }

    fun EliminarPlatos(plato:PlatoEntity){
        viewModelScope.launch {
            Repository.deletearPlato(plato)
        }
    }

    fun seleccionarPlato(plato: PlatoEntity) {
        platoSeleccionado = plato
        state = state.copy(
            NombrePlato = plato.Nombre,
            DescripcionPlato = plato.Descripcion,
            CaloriasPlato = plato.Calorias.toString()
        )
    }

    fun ModificarPlato() {
        val platoSeleccionado = platoSeleccionado ?: return
        val platoModificado = PlatoEntity(
            Id = platoSeleccionado.Id,
            Nombre = state.NombrePlato,
            Descripcion = state.DescripcionPlato,
            Calorias = state.CaloriasPlato.toInt(),
        )
        viewModelScope.launch {
            Repository.ModificarPlato(platoModificado)
        }
        // Restablecer los campos de texto después de la modificación
        state = state.copy(
            NombrePlato = "",
            DescripcionPlato = "",
            CaloriasPlato = ""
        )
    }


}