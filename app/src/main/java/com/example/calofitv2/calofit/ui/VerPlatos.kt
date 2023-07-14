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
fun VerPlatosScreen(navController: NavController,viewModel: PlatoViewModel= hiltViewModel()){
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
            Text(text = "Ver Platos",
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
            VerPlatosInterface(Modifier.align(Alignment.TopCenter),viewModel)
        }

    }
}
@Composable
fun VerPlatosInterface(modifier: Modifier, viewModel: PlatoViewModel) {
    val state = viewModel.state

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = modifier
    ) {
        TextField(
            value = state.NombrePlato,
            onValueChange = { viewModel.NombrePlato(it) },
            placeholder = { Text(text = "Nombre") }
        )
        TextField(
            value = state.DescripcionPlato,
            onValueChange = { viewModel.DescripcionPlato(it) },
            placeholder = { Text(text = "Descripcion") }
        )
        TextField(
            value = state.CaloriasPlato,
            onValueChange = { viewModel.CaloriasPlato(it) },
            placeholder = { Text(text = "Calorias") }
        )
        Button(onClick = { viewModel.ModificarPlato() }) {
            Text(text = "Modificar")
        }
        Spacer(modifier = Modifier.padding(10.dp))

        LazyColumn(modifier = Modifier.fillMaxWidth()) {
            items(state.Platos) { plato ->
                PlatosItems(
                    plato = plato,
                    modifier = Modifier.fillMaxWidth(),
                    onEdit = { viewModel.seleccionarPlato(plato) },
                    onDelete = { viewModel.EliminarPlatos(plato) }
                )
            }
        }
    }
}

