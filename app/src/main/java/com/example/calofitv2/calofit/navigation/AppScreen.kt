package com.example.calofitv2.calofit.navigation

//estas son como las rutas
sealed class AppScreen (val route: String){
    //representar 2 objetos que seran las rutas de las pantallas
    object SplashScreen: AppScreen("Splash_Screen")
    object Login: AppScreen("Login_Screen")
    object Inicio: AppScreen("Inicio_Screen")
}