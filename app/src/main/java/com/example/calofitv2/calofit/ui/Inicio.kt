package com.example.calofitv2.calofit.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import com.example.calofitv2.R
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.calofitv2.calofit.navigation.AppScreen

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun InicioScreen(navController: NavController){

    Scaffold(topBar = {
        TopAppBar(backgroundColor = Color(0xFF97DF6D)
            ) {
            Text(text = "Bienvenido",
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
            InicioInterface(Modifier.align(Alignment.TopCenter),navController)
        }

    }

}
@Composable
fun InicioInterface(modifier: Modifier,navController: NavController){
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center,modifier = modifier) {
        Spacer(modifier = Modifier.padding(20.dp))
        FilaVer(navController)
        Spacer(modifier = Modifier.padding(30.dp))
        AgregarPlatoInicio(navController)
        Spacer(modifier = Modifier.padding(23.dp))
        AgregarPacienteInicio(navController)
        Spacer(modifier = Modifier.padding(23.dp))
        AgregarRegistroInicio(navController)
        Spacer(modifier = Modifier.padding(28.dp))
        CerrarSesionInicio(navController)
        //Subtitulo1(Modifier.align(Alignment.CenterHorizontally))
        //Spacer(modifier = Modifier.padding(5.dp))
       // Subtitulo2(Modifier.align(Alignment.CenterHorizontally))
       // Spacer(modifier = Modifier.padding(15.dp))
      //  DatosInicioSesion()
    }

}



@Composable
fun FilaVer(navController: NavController){
    Row(modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
        ) {
        VerPacientesInicio(Modifier.align(Alignment.CenterVertically), navController)
        Spacer(modifier = Modifier.padding(20.dp))
        VerPlatosInicio(Modifier.align(Alignment.CenterVertically),navController)
        Spacer(modifier = Modifier.padding(20.dp))
        VerRegistrosInicio(Modifier.align(Alignment.CenterVertically),navController)
    }
}

@Composable
fun VerPacientesInicio(modifier: Modifier, navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center,modifier = modifier) {
        Image(painter = painterResource(R.drawable.paciente ) , contentDescription = "",
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .size(75.dp)
                .background(color = Color(0xFF97DF6D))
            )
        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = { navController.navigate(route = AppScreen.VerPacientes.route)
                         },
            colors = ButtonDefaults.buttonColors(
                    backgroundColor = Color(0xFFECEDC1)),
            shape = RoundedCornerShape(25),
            modifier = Modifier.height(28.dp)
            ) {
            Text(text = "PACIENTES",
                fontSize = 10.sp,
                color = Color.Black,
                )
        }
    }
}

@Composable
fun VerPlatosInicio(modifier: Modifier, navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center,modifier = modifier) {
        Image(painter = painterResource(R.drawable.platos ) , contentDescription = "",
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .size(75.dp)
                .background(color = Color(0xFF97DF6D))
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = { navController.navigate(route = AppScreen.VerPlatos.route) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFECEDC1)),
            shape = RoundedCornerShape(25),
            modifier = Modifier.height(28.dp)
        ) {
            Text(text = "PLATOS",
                fontSize = 10.sp,
                color = Color.Black,
            )
        }
    }
}

@Composable
fun VerRegistrosInicio(modifier: Modifier, navController: NavController) {
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center,modifier = Modifier) {
        Image(painter = painterResource(R.drawable.registro ) , contentDescription = "",
            modifier = Modifier
                .clip(RoundedCornerShape(6.dp))
                .size(75.dp)
                .background(color = Color(0xFF97DF6D))
        )
        Spacer(modifier = Modifier.padding(5.dp))
        Button(onClick = { navController.navigate(route = AppScreen.VerRegistros.route) },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Color(0xFFECEDC1)),
            shape = RoundedCornerShape(25),
            modifier = Modifier.height(28.dp)
        ) {
            Text(text = "REGISTRO",
                fontSize = 10.sp,
                color = Color.Black,
            )
        }
    }
}


@Composable
fun AgregarPlatoInicio(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreen.AgregarPlato.route) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFECEDC1)
        ),
        shape = RoundedCornerShape(25),
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(),

    ) {
        Image(
            painter = painterResource(R.drawable.agregarplatos),
            contentDescription ="",
            modifier = Modifier.size(30.dp))
        Text(
            text = "Agregar Plato",
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.CenterStart),
            textAlign = TextAlign.Start,
           // modifier = Modifier.padding(start = 10.dp)
            //.wrapContentSize(align = Alignment.CenterStart)
        )


    }
}

@Composable
fun CerrarSesionInicio(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreen.Login.route) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF97DF6D)
        ),
        shape = RoundedCornerShape(25),
        modifier = Modifier.height(40.dp).width(200.dp)

        ) {
        Image(
            painter = painterResource(R.drawable.cerrarsesion),
            contentDescription ="",
            modifier = Modifier.size(30.dp))
        Text(
            text = "Cerrar Sesion",
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier.fillMaxWidth()
                .wrapContentSize(align = Alignment.Center),
            textAlign = TextAlign.Start,
            // modifier = Modifier.padding(start = 10.dp)
            //.wrapContentSize(align = Alignment.CenterStart)
        )


    }
}

@Composable
fun AgregarPacienteInicio(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreen.AgregarPaciente.route) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFECEDC1)
        ),
        shape = RoundedCornerShape(25),
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(),

        ) {
        Image(
            painter = painterResource(R.drawable.agregarpaciente),
            contentDescription ="",
            modifier = Modifier.size(30.dp))
        Text(
            text = "Agregar Paciente",
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.CenterStart),
            textAlign = TextAlign.Start,
            // modifier = Modifier.padding(start = 10.dp)
            //.wrapContentSize(align = Alignment.CenterStart)
        )


    }
}

@Composable
fun AgregarRegistroInicio(navController: NavController) {
    Button(
        onClick = { navController.navigate(route = AppScreen.AgregarRegistro.route) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFFECEDC1)
        ),
        shape = RoundedCornerShape(25),
        modifier = Modifier
            .height(40.dp)
            .fillMaxWidth(),

        ) {
        Image(
            painter = painterResource(R.drawable.agregarregistro),
            contentDescription ="",
            modifier = Modifier.size(30.dp))
        Text(
            text = "Agregar Registro",
            fontSize = 15.sp,
            color = Color.Black,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.CenterStart),
            textAlign = TextAlign.Start,
            // modifier = Modifier.padding(start = 10.dp)
            //.wrapContentSize(align = Alignment.CenterStart)
        )


    }
}

/*
//@Preview(showBackground = true, showSystemUi = true)
@Preview(showBackground = true)
@Composable
fun PreviewInicio(){
    InicioScreen()
   //AgregarPlatoInicio()
}
*/