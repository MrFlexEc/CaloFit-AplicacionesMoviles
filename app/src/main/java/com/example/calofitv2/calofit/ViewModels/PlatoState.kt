package com.example.calofitv2.calofit.ViewModels

import com.example.calofitv2.calofit.data.DataFit.PlatoEntity


data class PlatoState(

    val idplato:String? = null,

    val NombrePlato: String = "",
    val DescripcionPlato: String = "",
    val CaloriasPlato: String = "",

    val Platos:List<PlatoEntity> = emptyList(),


    )
