package com.example.calofitv2.calofit.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calofitv2.calofit.ui.InicioScreen
import com.example.calofitv2.calofit.ui.LoginScreen
import com.example.calofitv2.calofit.ui.SplashScreen
import com.google.firebase.auth.FirebaseAuth

@Composable
fun AppNavigation(){
    //Esta vaina permite navegar entre aja interfaces
    val navController = rememberNavController()
    NavHost(navController = navController,
        startDestination =AppScreen.SplashScreen.route){
        composable(AppScreen.SplashScreen.route){
            SplashScreen(navController)
        }
        composable(AppScreen.Login.route){
            LoginScreen(navController, auth = FirebaseAuth.getInstance())
        }
        composable(AppScreen.Inicio.route){
            InicioScreen(navController)
        }
    }
}