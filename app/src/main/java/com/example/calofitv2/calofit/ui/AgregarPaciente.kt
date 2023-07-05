package com.example.calofitv2.calofit.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.calofitv2.R
import com.example.calofitv2.calofit.ViewModels.PacienteViewModel
import com.example.calofitv2.calofit.navigation.AppScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AgregarPacienteScreen(navController: NavController,viewModel: PacienteViewModel= hiltViewModel()){
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
            AgregarPacienteInterface(Modifier.align(Alignment.TopCenter),viewModel, navController)
        }

    }
}

//parte Inter7az
@Composable
fun AgregarPacienteInterface(modifier: Modifier, viewModel: PacienteViewModel, navController: NavController){
    //var show by rememberSaveable{ mutableStateOf(false)}
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center,modifier = modifier) {

        Spacer(modifier = Modifier.padding(10.dp))
        AgregarImagenPaciente()
        Spacer(modifier = Modifier.padding(8.dp))
        NombrePaciente(viewModel)
        Spacer(modifier = Modifier.padding(8.dp))
        CedulaPaciente(viewModel)
        Spacer(modifier = Modifier.padding(8.dp))
        EdadPaciente(viewModel)
        Spacer(modifier = Modifier.padding(8.dp))
        AlturaPaciente(viewModel)
        Spacer(modifier = Modifier.padding(15.dp))
        btnGuardarPaciente(viewModel)





    }
}
@Composable
fun btnGuardarPaciente(viewModel: PacienteViewModel) {
    var show by rememberSaveable{ mutableStateOf(false)}
    Button(
        onClick = { viewModel.GuardarPaciente();show=true },
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
    //DialogoGuardado(show)
    DialogoGuardado(show, { },{show=false})
}

@Composable
fun DialogoGuardado(
    show:Boolean,
    onDismiss: ()->Unit,
    onConfirm: ()->Unit

){
    if(show){
        AlertDialog(onDismissRequest = { onDismiss() },
            confirmButton = {
                Button(onClick = { onConfirm()}) {
                Text(text = "Aceptar")
            }},
            title = { Text(text = "Calofit", fontSize = 15.sp, color=Color.Black,textAlign = TextAlign.Center)},
            text = { Text(text = "El paciente se ha ingresado correctamente")}
        )
    }


}




@Composable
fun NombrePaciente(viewModel:PacienteViewModel) {
    val state = viewModel.state
    OutlinedTextField(
        value = state.NombrePaciente,
        onValueChange = {viewModel.NombrePaciente(it)},
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
fun CedulaPaciente(viewModel: PacienteViewModel) {
    val state = viewModel.state
    OutlinedTextField(
        value = state.CedulaPaciente,
        onValueChange = {viewModel.CedulaPaciente(it)},
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
fun EdadPaciente(viewModel: PacienteViewModel){
    val state = viewModel.state
    var edadPaciente by remember { mutableStateOf("") }
    OutlinedTextField(
        value = state.EdadPaciente.toString(),
        onValueChange = {viewModel.EdadPaciente(it)},
        label = { Text(text = "Edad")},
        placeholder = { Text(text = "Edad")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth()
        ,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
        ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFECEDC1),
            placeholderColor = Color.Black,
            focusedLabelColor = Color.Black
        ))
}


@Composable
fun AlturaPaciente(viewModel: PacienteViewModel){
    val state = viewModel.state
    OutlinedTextField(
        value = state.AlturaPaciente,
        onValueChange = {viewModel.AlturaPaciente(it)},
        label = { Text(text = "Altura")},
        placeholder = { Text(text = "Altura")},
        singleLine =  true,
        modifier = Modifier
            .fillMaxWidth()
        ,

        //keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
       // ,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Color(0xFFECEDC1),
            placeholderColor = Color.Black,
            focusedLabelColor = Color.Black
        ))
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