package com.example.calofitv2.calofit.navigation

//estas son como las rutas
sealed class AppScreen (val route: String){
    //representar 2 objetos que seran las rutas de las pantallas
    object SplashScreen: AppScreen("Splash_Screen")
    object Login: AppScreen("Login_Screen")
    object Inicio: AppScreen("Inicio_Screen")
    object VerPacientes: AppScreen("Ver_Pacientes_Screen")
    object VerPlatos: AppScreen("Ver_Platos_Screen")
    object VerRegistros: AppScreen("Ver_Registro_Screen")
    object AgregarPaciente: AppScreen("Agregar_Paciente_Screen")
    object AgregarPlato: AppScreen("Agregar_Plato_Screen")
    object AgregarRegistro: AppScreen("Agregar_Registro_Screen")
}