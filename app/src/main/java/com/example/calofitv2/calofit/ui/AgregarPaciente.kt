package com.example.calofitv2.calofit.ui

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
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
import com.example.calofitv2.R
import com.example.calofitv2.calofit.navigation.AppScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AgregarPacienteScreen(navController: NavController){
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
            Text(text = "Agregar Paciente",
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
            AgregarPacienteInterface(Modifier.align(Alignment.TopCenter))
        }

    }
}

//parte Inter7az
@Composable
fun AgregarPacienteInterface(modifier: Modifier){

    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center,modifier = modifier) {

        Spacer(modifier = Modifier.padding(10.dp))
        AgregarImagenPaciente()
        Spacer(modifier = Modifier.padding(15.dp))
        NombrePaciente()
        Spacer(modifier = Modifier.padding(15.dp))
        CedulaPaciente()
        Spacer(modifier = Modifier.padding(15.dp))
        EdadPaciente()
        Spacer(modifier = Modifier.padding(15.dp))
        AlturaPaciente()
        Spacer(modifier = Modifier.padding(25.dp))
        btnGuardarPaciente()


    }
}
@Composable
fun btnGuardarPaciente() {
    Button(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF97DF6D)
        ),
        shape = RoundedCornerShape(25),
        modifier = Modifier
            .height(40.dp)
            .width(200.dp)

    ) {
        Text(
            text = "Guardar",
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.Center),
            textAlign = TextAlign.Start,
            // modifier = Modifier.padding(start = 10.dp)
            //.wrapContentSize(align = Alignment.CenterStart)
        )
    }
}

@Composable
fun NombrePaciente() {
    var nombrePaciente by remember { mutableStateOf("") }
    OutlinedTextField(
        value = nombrePaciente,
        onValueChange = {nombrePaciente=it},
        label = { Text(text = "Nombre")},
        placeholder = { Text(text = "Nombre")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth()
        ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFECEDC1),
            placeholderColor = Color.Black,
            focusedLabelColor = Color.Black
        ))
}

@Composable
fun CedulaPaciente() {
    var cedulaPaciente by remember { mutableStateOf("") }
    OutlinedTextField(
        value = cedulaPaciente,
        onValueChange = {cedulaPaciente=it},
        label = { Text(text = "Cedula")},
        placeholder = { Text(text = "Cedula")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth()
        ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFECEDC1),
            placeholderColor = Color.Black,
            focusedLabelColor = Color.Black
        ))
}
@Composable
fun EdadPaciente(){
    var edadPaciente by remember { mutableStateOf("") }
    OutlinedTextField(
        value = edadPaciente,
        onValueChange = {edadPaciente=it},
        label = { Text(text = "Edad")},
        placeholder = { Text(text = "Edad")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth()
        ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFECEDC1),
            placeholderColor = Color.Black,
            focusedLabelColor = Color.Black
        ))
}


@Composable
fun AlturaPaciente(){
    var alturaPaciente by remember { mutableStateOf("") }
    OutlinedTextField(
        value = alturaPaciente,
        onValueChange = {alturaPaciente=it},
        label = { Text(text = "Altura")},
        placeholder = { Text(text = "Altura")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth()
        ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFECEDC1),
            placeholderColor = Color.Black,
            focusedLabelColor = Color.Black
        ))
}


@Composable
fun BtnSleccionImagenPaciente() {
    Button(
        onClick = {  },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color(0xFF97DF6D)
        ),
        shape = RoundedCornerShape(25),
        modifier = Modifier
            .height(40.dp)
            .width(220.dp)

    ) {
        Text(
            text = "SELECCIONAR IMAGEN",
            fontSize = 15.sp,
            color = Color.White,
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentSize(align = Alignment.Center),
            //textAlign = TextAlign.Start,
            // modifier = Modifier.padding(start = 10.dp)
            //.wrapContentSize(align = Alignment.CenterStart)
        )


    }
}

@Composable
fun AgregarImagenPaciente() {
    Image(painter = painterResource(R.drawable.logofinal)
        , contentDescription =""
        ,modifier = Modifier
            .size(150.dp)
    )
}

/*
@Preview(showBackground = true, showSystemUi = true)
//@Preview(showBackground = true)
@Composable
fun PreviewInicio(){
     AgregarPacienteScreen()
}*/