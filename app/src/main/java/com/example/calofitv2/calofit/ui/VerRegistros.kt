package com.example.calofitv2.calofit.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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
import com.example.calofitv2.calofit.ViewModels.RegistroViewModel
import com.example.calofitv2.calofit.navigation.AppScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun VerRegistrosScreen(navController: NavController,viewModel: RegistroViewModel = hiltViewModel()){
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
            Text(text = "Ver Registros",
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
            VerRegistrosInterface(Modifier.align(Alignment.TopCenter),viewModel)
        }

    }
}
@Composable
fun VerRegistrosInterface(modifier: Modifier, viewModel: RegistroViewModel) {
    val state = viewModel.state
    val pacientes by viewModel.pacientes.collectAsState(initial = emptyList())
    val platos by viewModel.platos.collectAsState(initial = emptyList())

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        TextField(
            value = viewModel.pacienteNombre,
            onValueChange = { viewModel.PacienteN(it) },
            placeholder = { Text(text = "Paciente") }
        )
        TextField(
            value = viewModel.platoNombre,
            onValueChange = { viewModel.PlatoN(it) },
            placeholder = { Text(text = "Plato") }
        )
        TextField(
            value = state.Fecha,
            onValueChange = { viewModel.FechaRegistro(it) },
            placeholder = { Text(text = "Fecha") }
        )
        TextField(
            value = state.Porciones,
            onValueChange = { viewModel.Porciones(it) },
            placeholder = { Text(text = "Calorias") }
        )
        Button(onClick = { viewModel.ModificarPlato() }) {
            Text(text = "Modificar")
        }
        Spacer(modifier = Modifier.padding(10.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.Registros) { registro ->
                RegistrosItems(
                    registro = registro,
                    modifier = Modifier.fillMaxWidth(),
                    onEdit = { viewModel.seleccionarRegistro(registro) },
                    onDelete = { viewModel.EliminarRegistro(registro) },
                    pacientes = pacientes,
                    platos = platos
                )
            }
        }
    }
}