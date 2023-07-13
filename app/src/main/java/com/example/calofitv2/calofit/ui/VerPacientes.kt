package com.example.calofitv2.calofit.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.calofitv2.R
import com.example.calofitv2.calofit.ViewModels.PacienteViewModel
import com.example.calofitv2.calofit.ViewModels.PlatoViewModel
import com.example.calofitv2.calofit.navigation.AppScreen
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun VerPacientesScreen(navController: NavController,viewModel: PacienteViewModel= hiltViewModel()){
    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color(0xFF97DF6D)
        ) {
            Image(painter = painterResource(R.drawable.inicioicon)
                , contentDescription = ""
                , modifier = Modifier
                    .clickable {
                        navController.navigate(route = AppScreen.Inicio.route)

                    }
                    .size(35.dp)
            )
            Text(text = "Ver Pacientes",
                fontSize =25.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentSize(align = Alignment.Center)
            )
        }
    }) {

        Box(
            Modifier
                .fillMaxSize()
                .padding(8.dp),
        ){
            //Se crea el login y se centra los elementos
            VerPacientesInterface(Modifier.align(Alignment.TopCenter),viewModel)
        }

    }
}
@Composable
fun VerPacientesInterface(modifier: Modifier, viewModel: PacienteViewModel) {
    val state = viewModel.state

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        TextField(
            value = state.NombrePaciente,
            onValueChange = { viewModel.NombrePaciente(it) },
            placeholder = { Text(text = "Nombre") }
        )
        TextField(
            value = state.CedulaPaciente,
            onValueChange = { viewModel.CedulaPaciente(it) },
            placeholder = { Text(text = "Cedula") }
        )
        TextField(
            value = state.EdadPaciente,
            onValueChange = { viewModel.EdadPaciente(it) },
            placeholder = { Text(text = "Edad") }
        )
        TextField(
            value = state.AlturaPaciente,
            onValueChange = { viewModel.AlturaPaciente(it) },
            placeholder = { Text(text = "Altura") }
        )
        Button(onClick = { viewModel.ModificarPaciente() }) {
            Text(text = "Modificar")
        }
        Spacer(modifier = Modifier.padding(10.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.Pacientes) { paciente ->
                PacientesItems(
                    paciente = paciente,
                    modifier = Modifier.fillMaxWidth(),
                    onEdit = { viewModel.seleccionarPaciente(paciente) },
                    onDelete = { viewModel.EliminarPaciente(paciente) }
                )
            }
        }
    }
}

