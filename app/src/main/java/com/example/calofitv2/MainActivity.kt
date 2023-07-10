package com.example.calofitv2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.room.Room
import com.example.calofitv2.calofit.ViewModels.LoginViewModel
import com.example.calofitv2.calofit.ViewModels.PacienteViewModel
import com.example.calofitv2.calofit.data.Database.AppDatabase
import com.example.calofitv2.calofit.data.DataFit.PacienteRepository
import com.example.calofitv2.calofit.navigation.AppNavigation
import com.example.calofitv2.ui.theme.CaloFitv2Theme
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        //val viewModell by viewModels<LoginViewModel>()
        super.onCreate(savedInstanceState)
        //val db = Room.databaseBuilder(this, PacienteDatabase::class.java, "Calofitv2"). allowMainThreadQueries().build()
        //val dao = db.dao
       // val Repository = PacienteRepository()
        //val viewModel = PacienteViewModel()
        //val viewModel by viewModels<LoginViewModel> ()
        //val viewModel by viewModels<PacienteViewModel> ()
        setContent {
            CaloFitv2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}
