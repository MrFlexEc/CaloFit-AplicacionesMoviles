package com.example.calofitv2.calofit.ViewModels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.calofitv2.calofit.data.DataFit.Plato
import com.example.calofitv2.calofit.data.DataFit.PlatoRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class PlatoViewModel @Inject constructor(
    private val Repository: PlatoRepository
): ViewModel() {
    var state by mutableStateOf(PlatoState())
        private set
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
        val plato = Plato(
            NombrePlato = state.NombrePlato,
            DescripcionPlato = state.DescripcionPlato,
            CaloriasPlato = state.CaloriasPlato

        )
        viewModelScope.launch {
            Repository.Insertplato(plato)
        }
    }







}