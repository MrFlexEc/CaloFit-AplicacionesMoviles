package com.example.calofitv2.calofit.ViewModels

import com.example.calofitv2.calofit.data.DataFit.Plato


data class PlatoState(

    val NombrePlato: String = "",
    val DescripcionPlato: String = "",
    val CaloriasPlato: String = "",

    val RegistroLt:List<Plato> = emptyList(),


    )
