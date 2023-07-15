package com.example.calofitv2.calofit.ui

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import com.example.calofitv2.calofit.ViewModels.RegistroViewModel
import com.example.calofitv2.calofit.navigation.AppScreen


@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun AgregarRegistroScreen(navController: NavController,viewModel: RegistroViewModel = hiltViewModel()){
    Scaffold(
        topBar = {
            TopAppBar(backgroundColor = Color(0xFF97DF6D)
            )   {
                Image(painter = painterResource(R.drawable.inicioicon)
                    , contentDescription = ""
                    , modifier = Modifier
                        .clickable {
                            navController.navigate(route = AppScreen.Inicio.route)

                        }
                        .size(35.dp)
                )
                Text(text = "Agregar Registro",
                    fontSize =25.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White,
                    textAlign = TextAlign.Center,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentSize(align = Alignment.Center)
                )
            }
        }
    ) {

        Box(
            Modifier
                .fillMaxSize()
                .padding(8.dp),
        ){
            //Se crea el login y se centra los elementos
            AgregarRegistroInterface(Modifier.align(Alignment.TopCenter),viewModel)
        }

    }
}

//parte Inter7az
@Composable
fun AgregarRegistroInterface(modifier: Modifier,viewModel: RegistroViewModel){
    //var show by rememberSaveable{ mutableStateOf(false)}
    Column(horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement =Arrangement.Center,modifier = modifier) {

        Spacer(modifier = Modifier.padding(10.dp))
        AgregarImagenRegistro()
        Spacer(modifier = Modifier.padding(8.dp))
        Pacientemenu(viewModel)
        Spacer(modifier = Modifier.padding(8.dp))
        Platomenu(viewModel)
        Spacer(modifier = Modifier.padding(8.dp))
        FechaRegistro(viewModel)
        Spacer(modifier = Modifier.padding(8.dp))
        PorcionesRegistro(viewModel)
        Spacer(modifier = Modifier.padding(15.dp))
        btnGuardarRegistro(viewModel)





    }
}
@Composable
fun btnGuardarRegistro(viewModel: RegistroViewModel) {

    var show by rememberSaveable{ mutableStateOf(false)}
    // viewModel.GuardarPaciente();show=true
    Button(
        onClick = { viewModel.GuardarRegistro();show=true },
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
    DialogoGuardado2(show, { },{show=false})
}

@Composable
fun DialogoGuardado2(
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
            text = { Text(text = "El registro se ha ingresado correctamente")}
        )
    }


}




@Composable
fun Pacientemenu(viewModel: RegistroViewModel) {
    val state = viewModel.state
    val pacientes by viewModel.pacientes.collectAsState(initial = emptyList())


    //Estado para determinar si se despliega o no
    var expanded by remember { mutableStateOf(false) }
    //Estado inicial del item seleccionado
    var selectedItem by remember { mutableStateOf("Paciente") }

    Box(Modifier
        .background(color = Color(0xFFECEDC1))
        .fillMaxWidth()
    ) {
        Text(
            text = selectedItem,
            modifier = Modifier
                //Metodo CLICKABLE para desplegar el DropDownMenu
                //puedes hacerlo con un BUTTON
                .clickable { expanded = true }
                .padding(16.dp)
                .fillMaxWidth()
        )
        DropdownMenu(
            //expanded apuntando a la propiedad
            expanded = expanded,
            //Metodo para replegar el DropDownMenu
            onDismissRequest = { expanded = false },
        ) {
            //For each para mostrar los items
            pacientes.forEach{paciente ->
                DropdownMenuItem(onClick = {
                    //Asignacion de variable y estado del expanded
                    selectedItem = paciente.Nombre
                    expanded = false

                    viewModel.PacienteN(paciente.Id.toString())
                }) {
                    //En el texto mostramos el item seleccionado
                    Text(text = paciente.Nombre)
                }

            }
        }
    }
}
@Composable
fun Platomenu(viewModel: RegistroViewModel) {
    val state = viewModel.state
    val platos by viewModel.platos.collectAsState(initial = emptyList())


    //Estado para determinar si se despliega o no
    var expanded by remember { mutableStateOf(false) }
    //Estado inicial del item seleccionado
    var selectedItem by remember { mutableStateOf("Plato") }

    Box(Modifier
        .background(color = Color(0xFFECEDC1))
        .fillMaxWidth()
    ) {
        Text(
            text = selectedItem,
            modifier = Modifier
                //Metodo CLICKABLE para desplegar el DropDownMenu
                //puedes hacerlo con un BUTTON
                .clickable { expanded = true }
                .padding(16.dp)
                .fillMaxWidth()
        )
        DropdownMenu(
            //expanded apuntando a la propiedad
            expanded = expanded,
            //Metodo para replegar el DropDownMenu
            onDismissRequest = { expanded = false },
        ) {
            //For each para mostrar los items
            platos.forEach{plato ->
                DropdownMenuItem(onClick = {
                    //Asignacion de variable y estado del expanded
                    selectedItem = plato.Nombre
                    expanded = false
                    viewModel.PlatoN(plato.Id.toString())
                }) {
                    //En el texto mostramos el item seleccionado
                    Text(text = plato.Nombre)
                }

            }
        }
    }
}
@Composable
fun FechaRegistro(viewModel: RegistroViewModel){
    val state = viewModel.state
    OutlinedTextField(
        value = state.Fecha,
        onValueChange = {viewModel.FechaRegistro(it)},
        label = { Text(text = "Fecha")},
        placeholder = { Text(text = "Fecha")},
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
        )
    )
}


@Composable
fun PorcionesRegistro(viewModel: RegistroViewModel){
    //var porciones by remember { mutableStateOf("") }
    val state = viewModel.state
    OutlinedTextField(
        value = state.Porciones,
        onValueChange = {viewModel.Porciones(it)},
        label = { Text(text = "Porciones")},
        placeholder = { Text(text = "Porciones")},
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
fun AgregarImagenRegistro() {
    Image(painter = painterResource(R.drawable.logofinal)
        , contentDescription =""
        ,modifier = Modifier
            .size(150.dp)
    )
}

