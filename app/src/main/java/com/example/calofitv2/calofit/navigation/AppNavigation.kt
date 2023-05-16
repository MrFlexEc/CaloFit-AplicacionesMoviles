package com.example.calofitv2.calofit.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.calofitv2.calofit.ui.LoginScreen
import com.example.calofitv2.calofit.ui.SplashScreen

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
            LoginScreen()
        }
    }
}