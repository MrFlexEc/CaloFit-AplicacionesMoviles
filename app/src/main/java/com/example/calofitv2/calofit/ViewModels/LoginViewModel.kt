package com.example.calofitv2.calofit.ViewModels

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.calofitv2.calofit.navigation.AppScreen
import com.google.android.play.core.integrity.e
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await


class LoginViewModel:ViewModel() {
    var state by mutableStateOf(LoginState())
        private set

    fun ObtenerEmail(email:String){
        state=state.copy(
            email=email
        )
    }

    fun ObtenerPassword(password:String){
        state=state.copy(
            password=password
        )
    }

    fun Login(navController: NavController, auth: FirebaseAuth){
        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(state.email,state.password ).await()
                navController.navigate(route = AppScreen.Inicio.route)
            }
            catch (e: Exception){
                val message = e.message
                println(message)
            }
        }
        }
    }

