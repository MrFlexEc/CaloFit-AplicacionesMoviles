package com.example.calofitv2.calofit.ViewModels

import androidx.compose.runtime.getValue
import androidx.lifecycle.ViewModel
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.calofitv2.calofit.navigation.AppScreen
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
   // private val Repository: PacienteRepository
):ViewModel() {
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

/*
    //PACIENTE
    var stateP by mutableStateOf(PacienteState())
        private set

    fun NombrePaciente(nombre:String){
        stateP = stateP.copy(
            NombrePaciente = nombre
        )
    }

    fun CedulaPaciente(cedula:String){
        stateP = stateP.copy(
            CedulaPaciente = cedula
        )
    }
    fun EdadPaciente(edad:String){
        stateP = stateP.copy(
            EdadPaciente = edad
        )
    }
    fun AlturaPaciente(altura:String){
        stateP = stateP.copy(
            AlturaPaciente = altura
        )
    }

    fun GuardarPaciente(){
        val paciente = Paciente(
            NombrePaciente = stateP.NombrePaciente,
            CedulaPaciente = stateP.CedulaPaciente,
            EdadPaciente = stateP.EdadPaciente,
            AlturaPaciente = stateP.AlturaPaciente
        )
        viewModelScope.launch {
            Repository.InsertPaciente(paciente)
        }
    }

    */
    }

