package com.example.calofitv2.calofit.navigation

import AgregarPlatoScreen
import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calofitv2.calofit.ViewModels.LoginViewModel
import com.example.calofitv2.calofit.ViewModels.PacienteViewModel
import com.example.calofitv2.calofit.ui.*
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavigation(){
    //Esta vaina permite navegar entre aja interfaces
    val navController = rememberNavController()
    NavHost(navController = navController,
        //startDestination =AppScreen.SplashScreen.route
       // startDestination =AppScreen.AgregarPaciente.route
         startDestination =AppScreen.AgregarRegistro.route

    ){
        composable(AppScreen.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(AppScreen.Login.route){
            LoginScreen(navController, auth = FirebaseAuth.getInstance())
        }
        composable(AppScreen.Inicio.route){
            InicioScreen(navController)
        }
        composable(AppScreen.VerPlatos.route){
            VerPlatosScreen(navController)
        }
        composable(AppScreen.VerPacientes.route){
            VerPacientesScreen(navController)
        }
        composable(AppScreen.VerRegistros.route){
            VerRegistrosScreen(navController)
        }
        composable(AppScreen.AgregarPlato.route){
            AgregarPlatoScreen(navController)
        }
        composable(AppScreen.AgregarPaciente.route){
            AgregarPacienteScreen(navController)
        }
        composable(AppScreen.AgregarRegistro.route){
            AgregarRegistroScreen(navController)
        }
    }
}